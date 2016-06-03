package br.topOtimizacao.metaheuristica;

import java.util.ArrayList;
import java.util.Random;

import br.topOtimizacao.base.Individuo;
import br.topOtimizacao.base.Mochila;
import br.topOtimizacao.base.Objeto;

public class LocalSearch {
	
	
	private Individuo solucaoInicial;
	private int stopNumbers[];
	
	public LocalSearch(Individuo solInicial){
		
		this.solucaoInicial = solInicial;
	}
	
	public Individuo execute(){
		
		Individuo s0 = this.solucaoInicial.getClone();
		Individuo s = this.solucaoInicial.getClone();
		
		Individuo aux = s0.getClone();
		
		for(int i = 0; i < aux.solucoes.length;i++){
			
			replaceOneByOne(aux,i);
			inserePerturbacao(aux);
			if(aux.fitness() > s.fitness()){
				s = aux;
			}else
				aux = s0.getClone();
		}
		
		return s;
	}
	
private boolean inserePerturbacao(Individuo ind){
	ArrayList<Objeto> objetos = ind.objetos;
	ArrayList<Mochila> mochilas = ind.mochilas;
	
	boolean ok = true;
	int perturbacao = new Random().nextInt(objetos.size());
	int aux = ind.solucoes[perturbacao];
	
	ind.solucoes[perturbacao] = 1;
	
	if(!ind.validaSolucao()){
		ind.solucoes[perturbacao] = aux;
		ok = false;
		return ok;
	}
	return ok;
}	
private boolean replaceOneByOne(Individuo ind,int pos){
		
		boolean ok = true;
		
		int aux = ind.solucoes[pos];
		
		if(ind.solucoes[pos] == 0){
			ind.solucoes[pos] = 1;
		}else
			ind.solucoes[pos] = 0;
		
		if(!ind.validaSolucao()){
			
			ind.solucoes[pos] = aux;
			ok = false;
			return ok;
		}
		return ok;
	}


}
