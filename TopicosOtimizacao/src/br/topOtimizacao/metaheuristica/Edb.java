package br.topOtimizacao.metaheuristica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import br.topOtimizacao.base.Canivete;
import br.topOtimizacao.base.Individuo;

public class Edb {

	double PM;
	double PR;
	ArrayList<Individuo> populacao;

	public Edb(double PM, double PR, ArrayList<Individuo> populacao) {

		this.populacao = populacao;
		this.PR = PR;
		this.PM = PM;

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
			for (i = 0; i < populacao.size(); i++) {

				int jRand = new Random().nextInt(populacao.get(0).mochilas.size());
				int s = Canivete.randExclude(0, populacao.size(), i);

				Individuo teste = populacao.get(i).getClone();

				int j;
				for (j = 0; j < teste.objetos.size(); j++) {

					// aplica operador de perturbacao
					if (new Random().nextDouble() < PR || jRand == j) {

						perturbacao(teste);

					}

					// aplica operador de mutação
					if (new Random().nextDouble() < PM) {

						inverteBit(teste, j);

					} else {
						 crossover(teste, i, populacao);
					}

					//teste.solucoes[j] = populacao.get(s).solucoes[j];
				}

				if (teste.fitness() > populacao.get(i).fitness()) {
					
					novaPop.remove(i);
					novaPop.add(teste);
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

	private void perturbacao(Individuo ind) {

		int i;

		i = new Random().nextInt(ind.solucoes.length);

		int aux = ind.solucoes[i];
		ind.solucoes[i] = 1;

		if (!ind.validaSolucao())
			ind.solucoes[i] = aux;

	}

	private void inverteBit(Individuo ind, int i) {

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

	private void crossover(Individuo solAtual, int i, ArrayList<Individuo> populacao) {

		int popSize = populacao.size();
		int ind = Canivete.randExclude(0, popSize, i);

		Individuo a;

		a = populacao.get(ind);

		Individuo filhoA = new Individuo();
		Individuo filhoB = new Individuo();

		int aux[] = new int[a.objetos.size()];
		int corte = Canivete.randExclude(0, a.objetos.size(), 0);

		for (int h = 0; h <= corte; h++) {
			aux[h] = solAtual.solucoes[h];
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
			aux[k] = solAtual.solucoes[k];
		}

		filhoB.solucoes = aux;
		filhoB.mochilas = a.mochilas;
		filhoB.objetos = a.objetos;

		if (!filhoB.validaSolucao())
			filhoB = solAtual.getClone();

		Collections.sort(populacao);
		populacao.remove(0);
		populacao.remove(1);
		populacao.add(filhoA);
		populacao.add(filhoB);
	}

}
