package ep2;

/*********************************************************************/
/** ACH 2002 - Introducao a Analise de Algoritmos                   **/
/** EACH-USP - Segundo Semestre de 2018                             **/
/**                                                                 **/
/** <04> - <Norton Trevisan Roman>                                  **/
/**                                                                 **/
/** Segundo  Exercicio-Programa                                     **/
/**                                                                 **/
/** <Maraiza Adami Pereira>  		                             **/
/**                                                                 **/
/*********************************************************************/


public abstract class MetodosGulosos {

	
// Reordenar em ordem crescente do menor peso para o maior
	public static Objeto[] OrdenaPeso ( Objeto[] listaDeObjetosDisponiveis) {
		int i = 0;
		Objeto[]aux = new Objeto [listaDeObjetosDisponiveis.length];
		boolean troca = true;

		while (troca) {
                  troca = false;
			 for (i = 0; i < listaDeObjetosDisponiveis.length -1; i++) {
				 if (listaDeObjetosDisponiveis[i].getPeso() > listaDeObjetosDisponiveis[i+1].getPeso()) {
					aux [i]= listaDeObjetosDisponiveis[i];
                         		 listaDeObjetosDisponiveis[i] = listaDeObjetosDisponiveis[i+1];
                         		 listaDeObjetosDisponiveis[i+1] = aux [i];
                          		troca = true;
				}    	
			}
		}
		
    		for (i = 0; i < listaDeObjetosDisponiveis.length -1; i++) {
		    	int menor = i;
		   for (i = menor +1; i < listaDeObjetosDisponiveis.length -1; i++) {
		    	if (listaDeObjetosDisponiveis[i].getPeso() == listaDeObjetosDisponiveis[i+1].getPeso()){
				if (listaDeObjetosDisponiveis[i].getValor() < listaDeObjetosDisponiveis [i+1].getValor()) {
		        		listaDeObjetosDisponiveis[menor] = listaDeObjetosDisponiveis[i];
		       		}
		   	 }
		    
			if (listaDeObjetosDisponiveis[menor].getPeso()  == listaDeObjetosDisponiveis[i].getPeso() ) {
				if (listaDeObjetosDisponiveis[i].getValor() > listaDeObjetosDisponiveis [i+1].getValor()) {
		      			aux[i] = listaDeObjetosDisponiveis[i] ;
		      			listaDeObjetosDisponiveis[i]  = listaDeObjetosDisponiveis[menor];
		      			listaDeObjetosDisponiveis[menor] = aux [i];
		    		}
		  	}
		   }
		}
		return (listaDeObjetosDisponiveis);
 	}

	public static Objeto[] OrdenaValor ( Objeto[] listaDeObjetosDisponiveis) {
		int i;
		Objeto[]aux = new Objeto [listaDeObjetosDisponiveis.length];
		boolean troca = true;

		while (troca) {
                  troca = false;
			for (i = 0; i < listaDeObjetosDisponiveis.length -1;i++){
				if (listaDeObjetosDisponiveis[i].getValor() < listaDeObjetosDisponiveis[i+1].getValor()){
					aux[i] =listaDeObjetosDisponiveis[i];
					listaDeObjetosDisponiveis [i] = listaDeObjetosDisponiveis[i+1];
					listaDeObjetosDisponiveis [i+1] = aux[i];
					troca=true;
				}
			}
			
		}

		for (i = 0; i < listaDeObjetosDisponiveis.length -1; i++) {
		    	int menor = i;
		   
			for (i = menor +1; i < listaDeObjetosDisponiveis.length -1; i++) {
		    		 if (listaDeObjetosDisponiveis[i].getValor() == listaDeObjetosDisponiveis[i+1].getValor()){
					if (listaDeObjetosDisponiveis[i].getPeso() > listaDeObjetosDisponiveis [i+1].getPeso()) {
		        			listaDeObjetosDisponiveis[menor] = listaDeObjetosDisponiveis[i];
		       			}
		   	 	}
		    
				if (listaDeObjetosDisponiveis[menor].getValor()  == listaDeObjetosDisponiveis[i].getValor() ) {
					if (listaDeObjetosDisponiveis[i].getPeso() < listaDeObjetosDisponiveis [i+1].getPeso()) {
		      				aux[i] = listaDeObjetosDisponiveis[i] ;
		      				listaDeObjetosDisponiveis[i]  = listaDeObjetosDisponiveis[menor];
		      				listaDeObjetosDisponiveis[menor] = aux [i];
		    			}
		  		}
			}
		}		
		return (listaDeObjetosDisponiveis);
	}

	public static Mochila encheMochila (double pesoMaximoDaMochila, Objeto[] listaDeObjetosDisponiveis) {
		Mochila mochila = new Mochila(pesoMaximoDaMochila);

		int i;
		double pesoUsado = mochila.getPesoUsado();
		double valor = 0;
		int numObjetos = 0;
		
		for (i = 0; i<listaDeObjetosDisponiveis.length-1;i++){
				
				while ( pesoMaximoDaMochila >= pesoUsado ){
						
                  	 		pesoUsado = mochila.getPesoUsado() + listaDeObjetosDisponiveis[i].getPeso();
                    			valor = mochila.getValorDentroDaMochila() + listaDeObjetosDisponiveis[i].getValor();
					numObjetos = mochila.getNumObjetosNaMochila()+1;
					
					if( pesoUsado <= pesoMaximoDaMochila){

						mochila.setPesoUsado(pesoUsado);
						mochila.setValorDentroDaMochila(valor);
						mochila.setNumObjetosNaMochila(numObjetos);		
					}else{
					break;
					}
				}
		}
		return mochila;
	}
	
	

	
	public static Mochila utilizaMenorPeso(double pesoMaximoDaMochila, Objeto[] listaDeObjetosDisponiveis) {
		Mochila mochila = new Mochila(pesoMaximoDaMochila);
		
		
		OrdenaPeso(listaDeObjetosDisponiveis);
		
		mochila = encheMochila ( pesoMaximoDaMochila,listaDeObjetosDisponiveis);
		
		return mochila ;
	}
	
	public static Mochila utilizaMaiorValor(double pesoMaximoDaMochila,Objeto[] listaDeObjetosDisponiveis) {
		Mochila mochila = new Mochila(pesoMaximoDaMochila);
		
		OrdenaValor(listaDeObjetosDisponiveis);
		
		mochila = encheMochila ( pesoMaximoDaMochila,listaDeObjetosDisponiveis);
		
		return mochila ;
	}

	
	
	public static Mochila utilizaMaiorValorDivididoPorPeso(double pesoMaximoDaMochila, Objeto[] listaDeObjetosDisponiveis) {
		Mochila mochila = new Mochila(pesoMaximoDaMochila);
		
		int i;
		double peso =0;
		double valor = 0;
     		Objeto []pesoMenor = new Objeto [listaDeObjetosDisponiveis.length];
       		Objeto []maiorValor = new Objeto[listaDeObjetosDisponiveis.length];
		
		
	pesoMenor = OrdenaPeso(listaDeObjetosDisponiveis);
	maiorValor = OrdenaValor(listaDeObjetosDisponiveis);	
		
			
			
		// ordenar arranjo principal Valor/peso
		for (i = 0; i < listaDeObjetosDisponiveis.length -1;i++){
			if((maiorValor[i].getValor()/pesoMenor[i].getPeso())> (maiorValor[i+1].getValor()/ pesoMenor[i+1].getPeso())) {
				peso = pesoMenor[i].getPeso();
				valor = maiorValor[i].getValor();
				listaDeObjetosDisponiveis[i] = new Objeto( peso, valor);
				peso = pesoMenor[i+1].getPeso();
				valor = maiorValor[i+1].getValor();
				listaDeObjetosDisponiveis[i+1] = new Objeto( peso, valor);
				
		}
			
			
			if ((maiorValor[i].getValor()/pesoMenor[i].getPeso())==(maiorValor[i+1].getValor()/pesoMenor[i+1].getPeso())){
				if (pesoMenor[i].getPeso() > pesoMenor[i+1].getPeso()){
					peso = pesoMenor[i].getPeso();
					valor = maiorValor[i].getValor();
					listaDeObjetosDisponiveis[i] = new Objeto( peso, valor);
					peso = pesoMenor[i+1].getPeso();
					valor = maiorValor[i+1].getValor();
					listaDeObjetosDisponiveis[i+1] = new Objeto( peso, valor);
				}else {
					peso = pesoMenor[i+1].getPeso();
					valor = maiorValor[i+1].getValor();
					listaDeObjetosDisponiveis[i] = new Objeto( peso, valor);
					peso = pesoMenor[i].getPeso();
					valor = maiorValor[i].getValor();
					listaDeObjetosDisponiveis[i+1] = new Objeto( peso, valor);
				}
			}
			
			if((maiorValor[i].getValor()/pesoMenor[i].getPeso()) < (maiorValor[i+1].getValor()/ pesoMenor[i+1].getPeso())){
				peso = pesoMenor[i+1].getPeso();
				valor = maiorValor[i+1].getValor();
				listaDeObjetosDisponiveis[i] = new Objeto( peso, valor);
				peso = pesoMenor[i].getPeso();
				valor = maiorValor[i].getValor();
				listaDeObjetosDisponiveis[i+1] = new Objeto( peso, valor);
			}
                }
		mochila = encheMochila ( pesoMaximoDaMochila,listaDeObjetosDisponiveis);
		return mochila ;
	}
}
