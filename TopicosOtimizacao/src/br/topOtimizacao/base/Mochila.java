package br.topOtimizacao.base;

import java.util.ArrayList;

public class Mochila {
	
	double capacidade;
	
	
	public Mochila(double capacidade) {
		
		this.capacidade = capacidade;
	}
	
	public static ArrayList<Mochila> criaMochilas(double capacidades[]){
		
		ArrayList<Mochila> mo = new ArrayList<Mochila>();
		for (int i = 0; i < capacidades.length; i++) {
			mo.add(new Mochila(capacidades[i]));
		}
		
		return mo;
	}
	
	public void printMochila(){
	    
	    System.out.print("| capacidade.:"+this.capacidade+" |");
	}
	
	

}
