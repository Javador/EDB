package adria;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;

import br.topOtimizacao.base.Canivete;
import br.topOtimizacao.base.Individuo;
import br.topOtimizacao.base.Mochila;
import br.topOtimizacao.base.Objeto;
import br.topOtimizacao.metaheuristica.AG;
import br.topOtimizacao.metaheuristica.Edb;
import br.topOtimizacao.metaheuristica.LocalSearch;

public class Principal {

	public static void main(String[] args) {


		// WEING1
				// -------------------------------------------------------------------------
				
				  double capMochilas[] = {300,600}; int lucro[] ={ 1898, 440, 22507,
				  270, 14148, 3100, 4650, 30800, 615, 4975, 1160, 4225, 510, 11880,
				  479, 440, 490, 330, 110, 560, 24355, 2885, 11748, 4550, 750, 3720,
				  1950, 10500};
				  
				  int pesos[][] = {{ 45, 0, 85, 150, 65, 95, 30, 0, 170, 0, 40, 25, 20,
				  0 ,0, 25, 0 ,0 ,25, 0, 165, 0 ,85, 0, 0 ,0, 0 ,100},{30, 20 ,125 ,5
				  ,80, 25, 35, 73, 12, 15, 15, 40, 5, 10, 10, 12, 10, 9 ,0, 20, 60, 40,
				  50 ,36, 49, 40, 19 ,150}};
				 
				// ------------------------------------------------------------------------
		


					
		int execucoes = 100;
		double resultados[] = new double[execucoes];
		for (int i = 0; i < execucoes; i++) {
			
			ArrayList<Objeto> objetos = Objeto.criaObjetos(pesos, lucro);
			ArrayList<Mochila> mochilas = Mochila.criaMochilas(capMochilas);

			ArrayList<Individuo> populacao = Individuo.geraPopulacao(100, objetos, mochilas);

			//Edb mH = new Edb(0.1, 0.5, populacao);
			AG mH = new AG(0.8,0.1,populacao);
			Individuo e = mH.execute(300);
			
			LocalSearch lc = new LocalSearch(e);
			e = lc.execute();
			
			resultados[i] = e.fitness();
			System.out.println((i+1)+"% concluído");
		}
		System.out.println("Média.: "+Canivete.avg(resultados));
		System.out.println("Desvio Padrão.: "+Canivete.desvPad(resultados));
	}

}
