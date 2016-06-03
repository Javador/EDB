package br.topOtimizacao.metaheuristica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import br.topOtimizacao.base.Canivete;
import br.topOtimizacao.base.Individuo;

public class AG {

	double CR;
	double MT;
	ArrayList<Individuo> populacao;

	public AG(double CR, double MT, ArrayList<Individuo> populacao) {

		this.populacao = populacao;
		this.CR = CR;
		this.MT = MT;

	}

	public ArrayList<Individuo> duplicaPop() {
		
		ArrayList<Individuo> novaPop = new ArrayList<Individuo>();
		for (int i = 0; i < populacao.size(); i++) {
			novaPop.add(populacao.get(i).getClone());
		}
		return novaPop;
	}

	public Individuo execute(int iteracoes) {

		int ite = 0;
		Individuo max = null;
		ArrayList<Individuo> novaPop;

		while (ite < iteracoes) {

			novaPop = duplicaPop();

			int i;
			for (i = 0; i < populacao.size() / 2; i++) {
				
				if (new Random().nextDouble() < CR ) {
					crossover(populacao,novaPop);
				}

			}

			max = lucroMaximo(populacao);

			populacao = novaPop;
			ite++;
		}

		return max;

	}

	public Individuo lucroMaximo(ArrayList<Individuo> populacao) {

		Individuo max = populacao.get(0);

		for (Individuo individuo : populacao) {

			if (individuo.fitness() > max.fitness()) {
				max = individuo;
			}
		}

		return max;
	}

	
	private void mutacao(Individuo ind, int i) {

		int aux;

		aux = ind.solucoes[i];

		if (ind.solucoes[i] == 0)
			ind.solucoes[i] = 1;
		else
			ind.solucoes[i] = 0;

		if (!ind.validaSolucao()) {
			ind.solucoes[i] = aux;
		}
	}

	private void crossover(ArrayList<Individuo> populacao,ArrayList<Individuo> novaPopulacao) {

		int popSize = populacao.size();
		int indA = new Random().nextInt(popSize);
		int indB = Canivete.randExclude(0, popSize, indA);

		Individuo a,b;

		a = populacao.get(indA);
		b = populacao.get(indB);

		Individuo filhoA = new Individuo();
		Individuo filhoB = new Individuo();

		int aux[] = new int[a.objetos.size()];
		int corte = Canivete.randExclude(0, a.objetos.size(), 0);

		for (int h = 0; h <= corte; h++) {
			aux[h] = b.solucoes[h];
		}

		for (int k = corte; k < a.objetos.size(); k++) {
			aux[k] = a.solucoes[k];
		}

		filhoA.solucoes = aux;
		filhoA.mochilas = a.mochilas;
		filhoA.objetos = a.objetos;

		if (!filhoA.validaSolucao())
			filhoA = a.getClone();

		aux = new int[a.objetos.size()];

		for (int h = 0; h <= corte; h++) {
			aux[h] = a.solucoes[h];
		}

		for (int k = corte; k < a.solucoes.length; k++) {
			aux[k] = b.solucoes[k];
		}

		filhoB.solucoes = aux;
		filhoB.mochilas = a.mochilas;
		filhoB.objetos = a.objetos;

		if (!filhoB.validaSolucao())
			filhoB = b.getClone();

		Collections.sort(novaPopulacao);
		populacao.remove(0);
		populacao.remove(1);
		
		if (new Random().nextDouble() < MT ) {

			int gene = new Random().nextInt(filhoA.objetos.size());
			mutacao(filhoA,gene);
			mutacao(filhoB,gene);
		}
		
		populacao.add(filhoA);
		populacao.add(filhoB);
	}

}
