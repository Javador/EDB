package br.topOtimizacao.base;

import java.util.ArrayList;

public class Objeto {
	
	 	 int peso[];
	     int lucro;
	     
	     public Objeto(int[] peso, int lucro){
	    	 
	    	 this.peso = peso;
	    	 this.lucro = lucro;
	    	 
	     }
	     
	     
	     public static ArrayList<Objeto> criaObjetos( int[][] pesos, int[] lucros){
	    	 
	    	 ArrayList<Objeto> ob = new ArrayList<Objeto>();
	    	 for (int i = 0; i < lucros.length; i++) {
	    		 
	    		 int arr[] =new int[pesos.length];
	    		 
	    		 for(int j = 0; j < pesos.length;j++){
	    			 arr[j] =pesos[j][i];
	    		 }
	    		 ob.add(new Objeto(arr,lucros[i]));
			}
	    	 
	    	 return ob;
	     }
	     
	     public void printObjeto(){
	    	 
	    	 System.out.println(" | peso.: "+this.peso+" lucro.: "+this.lucro+" | ");
	     }

}
