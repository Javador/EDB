package br.topOtimizacao.base;

import java.util.concurrent.ThreadLocalRandom;

public class Canivete {
	
	public static int randExclude(int min, int max, int excluded){
		
		int numero;
		
		do{
				
          numero= ThreadLocalRandom.current().nextInt(min,max);
			
		}while(numero == excluded);
		
		return numero;
	}
	
	public static double avg(double elems[]){
		
		double sum =0;
		for (int i = 0; i < elems.length; i++) {
			sum+=elems[i];
		}
		
		return sum/elems.length;
	}
	
	public static double desvPad(double elems[]){
		
		double aux=0;
		for (int i = 0; i < elems.length; i++) {
			
			double media = avg(elems);
			
			aux+= Math.pow(elems[i] - media,2);
		}
		
		aux = aux/elems.length;
		return Math.sqrt(aux);
		
	}

}
