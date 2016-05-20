package br.topOtimizacao.base;

import java.util.ArrayList;
import java.util.Random;

public class Individuo implements  Comparable<Individuo>{
		 
		public double fitness;
    	public int solucoes[];
	    public ArrayList<Objeto> objetos;
	    public ArrayList<Mochila> mochilas;
	    
	    public Individuo(){}
	    
	    private Individuo(ArrayList<Objeto> objetos,ArrayList<Mochila> mochilas) {
	    	
	    	this.objetos = objetos;
	    	this.mochilas = mochilas;
	    	int numObjetos = objetos.size();
	    	int numMochilas = mochilas.size();
	    	solucoes = new int[numObjetos];
	    	
	    	
	             for(int i = 0 ; i < numObjetos ; i++){
	            	  
	            		 int aux = solucoes[i];
	            		 
	            		 solucoes[i] = new Random().nextInt(2);
	            		 
	            		 if(!verifica(solucoes, objetos,mochilas))
	            			 solucoes[i] = aux;  	 
	            	 
                 }

	    }
	    
	    public static ArrayList<Individuo> geraPopulacao(int tamanho,ArrayList<Objeto> objetos,ArrayList<Mochila> mochilas){
	    	
	    	ArrayList<Individuo> pop = new ArrayList<Individuo>();
	    	for (int i = 0; i < tamanho; i++) {
				
	    		pop.add(new Individuo(objetos,mochilas));
				
			}
	    	
			return pop;
			
	    }
	    
	    
	    public double fitness(){

	    	 int i,j,h;
	    	 double sum = 0;
	    	   
	    	       for(h = 0; h < objetos.size() ; h++){

	    	           sum += this.solucoes[h] * objetos.get(h).lucro;
	    	        }
	    	      
	    	  this.fitness = sum;
	    	  
	    	  return sum;
	   }
	    
	    
	    public void printIndividuo (){

	        System.out.printf("\n -----------------------------------------------------\n");
	        int j;

	                for(j = 0 ; j < objetos.size() ; j++){
	                	System.out.printf(" %d " ,this.solucoes[j]);

	        }

	        System.out.printf("\n-----------------------------------------------------\n\n");
	}
	    
	    
	  public boolean validaSolucao(){

	        int i,j;
	        int sum = 0;
	        for(i=0 ; i < mochilas.size();i++){

	            for(j = 0; j < objetos.size() ; j++){
	                sum += this.solucoes[j]*objetos.get(j).peso[i];
	            }

	            if(sum > mochilas.get(i).capacidade)
	                return false;
	            
	            sum =0;
	        }
	        
	      return true;
	}
    
   public boolean verifica(int[] vetor, ArrayList<Objeto>objetos,ArrayList<Mochila> m){
	   
	   
	      double sum =0;
	      
	      for (int jj = 0; jj < m.size(); jj++) {
			
	    	  for (int i = 0; i < vetor.length; i++) {
	    		  sum += vetor[i]*objetos.get(i).peso[jj];
	    	  }
	      		
	    	  if(sum > m.get(jj).capacidade){
	    	 
	    		  return false;
	    	  }
	      
	      }
	      
	      return true;
   }

@Override
public int compareTo(Individuo o) {
	
	if(o.fitness() < this.fitness()){
		return 1;
	}else if(o.fitness() > this.fitness()){
		return -1;
	}
	
	return 0;
}

public Individuo getClone () {
	
	Individuo ret= new Individuo();
	
	int sol[]= new int[objetos.size()];
	
	for (int i = 0; i < sol.length; i++) {
		sol[i] = this.solucoes[i];
	}
	
	ret.solucoes = sol;
	ret.objetos = this.objetos;
	ret.mochilas = this.mochilas;
	
	return ret;
}
	   
}
