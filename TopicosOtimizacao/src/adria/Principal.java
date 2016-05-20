package adria;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;

import br.topOtimizacao.base.Canivete;
import br.topOtimizacao.base.Individuo;
import br.topOtimizacao.base.Mochila;
import br.topOtimizacao.base.Objeto;
import br.topOtimizacao.metaheuristica.Edb;

public class Principal {

	public static void main(String[] args) {

		// PB6
				// ------------------------------------------------------------------------------------------------------------------
				double capMochilas[] = { 3317, 1880, 2740, 4310, 2681, 3375, 4704, 3031, 3115, 2878, 2609, 3321, 4142, 4670,
						2130, 3323, 4766, 2590, 3573, 2888, 3578, 3478, 4189, 1748, 2039, 2660, 4645, 3578, 4418, 2211 };

				int lucro[] = { 82, 77, 110, 67, 61, 3, 6, 85, 2, 22, 238, 33, 56, 63, 69, 47, 63, 75, 6, 83, 47, 47, 7, 6, 53,
						76, 200, 29, 91, 6, 27, 52, 6, 51, 55, 72, 13, 6, 65, 95 };

				int pesos[][] = {
						{ 524, 774, 818, 56, 26, 22, 42, 20, 47, 37, 662, 21, 42, 57, 97, 75, 53, 49, 76, 96, 834, 785, 42, 39,
								979, 46, 608, 25, 23, 41, 667, 123, 805, 116, 19, 26, 760, 81, 699, 27 },
						{ 16, 67, 792, 99, 21, 794, 53, 81, 73, 87, 837, 234, 64, 65, 908, 18, 758, 22, 27, 91, 13, 435, 86, 29,
								377, 73, 504, 5, 86, 61, 67, 255, 118, 332, 97, 370, 32, 23, 165, 75 },
						{ 33, 42, 644, 96, 23, 49, 57, 931, 36, 5, 596, 978, 82, 59, 37, 22, 71, 788, 56, 96, 55, 283, 348, 66,
								873, 97, 33, 94, 42, 864, 464, 931, 33, 350, 15, 22, 9, 82, 358, 6 },
						{ 51, 114, 716, 668, 23, 43, 55, 973, 47, 3, 350, 56, 77, 97, 28, 75, 61, 95, 26, 33, 430, 950, 590, 32,
								297, 140, 714, 828, 97, 27, 571, 449, 602, 789, 15, 85, 27, 11, 778, 19 },
						{ 638, 720, 809, 31, 12, 82, 688, 868, 61, 17, 775, 82, 81, 860, 85, 49, 72, 72, 7, 13, 740, 830, 72,
								30, 221, 2, 9, 36, 150, 18, 586, 996, 519, 719, 320, 13, 654, 408, 70, 66 },
						{ 978, 53, 983, 3, 93, 37, 704, 581, 698, 97, 712, 42, 45, 91, 56, 32, 41, 664, 290, 86, 22, 234, 57,
								784, 503, 2, 59, 37, 75, 36, 105, 47, 760, 15, 190, 3, 17, 328, 210, 294 },
						{ 504, 37, 619, 93, 218, 23, 47, 303, 71, 56, 593, 744, 214, 67, 53, 22, 96, 16, 978, 53, 884, 796, 36,
								3, 724, 31, 468, 3, 81, 5, 509, 845, 293, 700, 75, 59, 9, 58, 67, 734 },
						{ 16, 27, 206, 57, 7, 87, 21, 624, 33, 92, 770, 15, 32, 13, 1, 2, 644, 4, 13, 100, 604, 854, 96, 910,
								372, 39, 12, 990, 140, 39, 876, 813, 559, 952, 640, 59, 290, 644, 232, 76 },
						{ 53, 36, 650, 210, 218, 520, 33, 12, 16, 86, 324, 100, 894, 818, 39, 7, 27, 318, 538, 43, 46, 206, 92,
								65, 944, 16, 7, 57, 174, 65, 320, 143, 382, 566, 878, 678, 284, 39, 755, 90 },
						{ 16, 51, 310, 21, 7, 43, 25, 860, 45, 82, 354, 42, 72, 76, 73, 37, 99, 79, 59, 85, 52, 798, 45, 26,
								560, 36, 45, 12, 62, 62, 790, 920, 390, 44, 62, 83, 27, 43, 574, 86 },
						{ 75, 51, 23, 26, 99, 426, 92, 99, 11, 51, 77, 66, 85, 554, 19, 604, 96, 77, 97, 55, 7, 85, 760, 104,
								580, 95, 927, 62, 51, 476, 716, 17, 37, 868, 267, 91, 2, 234, 444, 45 },
						{ 95, 89, 5, 81, 270, 491, 6, 72, 410, 12, 644, 79, 910, 595, 85, 167, 430, 21, 414, 89, 6, 948, 904,
								67, 994, 13, 295, 65, 408, 211, 11, 49, 844, 11, 417, 570, 43, 39, 16, 430 },
						{ 7, 63, 3, 63, 338, 402, 664, 21, 553, 128, 88, 458, 508, 222, 804, 720, 75, 45, 35, 55, 750, 1, 96,
								31, 846, 37, 496, 29, 210, 930, 653, 51, 35, 43, 393, 2, 834, 1, 418, 36 },
						{ 59, 6, 218, 36, 92, 321, 22, 138, 423, 53, 828, 16, 93, 622, 13, 189, 36, 75, 58, 968, 66, 89, 440,
								91, 62, 67, 628, 23, 83, 943, 129, 950, 170, 67, 613, 608, 27, 554, 730, 710 },
						{ 748, 654, 46, 69, 3, 769, 82, 624, 967, 948, 684, 15, 22, 586, 700, 343, 83, 57, 46, 65, 21, 66, 51,
								19, 882, 13, 254, 788, 760, 542, 339, 34, 13, 230, 327, 65, 87, 72, 71, 23 },
						{ 964, 900, 99, 51, 628, 150, 22, 79, 132, 628, 52, 154, 21, 663, 968, 846, 620, 840, 72, 73, 6, 110,
								22, 20, 497, 2, 201, 2, 924, 866, 501, 57, 3, 2, 279, 5, 148, 86, 91, 93 },
						{ 89, 26, 96, 37, 39, 89, 6, 53, 869, 2, 394, 82, 46, 541, 26, 268, 82, 72, 710, 16, 5, 934, 88, 93, 56,
								95, 194, 37, 66, 855, 71, 95, 7, 408, 464, 41, 56, 564, 488, 508 },
						{ 83, 2, 630, 61, 62, 638, 61, 73, 494, 71, 75, 62, 198, 958, 70, 232, 174, 25, 25, 600, 268, 15, 95,
								898, 515, 464, 571, 42, 21, 47, 462, 51, 96, 338, 228, 93, 690, 56, 89, 99 },
						{ 62, 290, 72, 844, 6, 570, 13, 16, 267, 32, 69, 65, 27, 236, 83, 482, 97, 274, 31, 55, 554, 97, 47, 7,
								480, 504, 616, 14, 824, 641, 374, 2, 478, 36, 496, 754, 848, 75, 330, 76 },
						{ 89, 7, 22, 45, 63, 148, 91, 33, 624, 47, 96, 69, 42, 224, 56, 970, 65, 67, 96, 27, 2, 75, 83, 69, 832,
								72, 688, 92, 93, 8, 214, 77, 66, 2, 384, 59, 26, 75, 15, 81 },
						{ 14, 62, 464, 292, 29, 340, 278, 83, 33, 374, 389, 818, 888, 37, 3, 60, 42, 40, 928, 42, 35, 76, 69,
								95, 46, 32, 864, 55, 198, 598, 73, 15, 95, 36, 814, 45, 770, 644, 634, 334 },
						{ 56, 780, 56, 588, 93, 86, 23, 94, 19, 86, 570, 518, 108, 218, 86, 718, 63, 81, 400, 938, 96, 43, 6,
								69, 50, 76, 674, 42, 5, 810, 9, 49, 274, 25, 298, 9, 42, 363, 47, 158 },
						{ 86, 75, 99, 554, 704, 800, 6, 670, 47, 49, 199, 85, 69, 3, 77, 63, 674, 924, 55, 22, 214, 864, 718,
								56, 67, 53, 19, 554, 1, 49, 56, 418, 13, 948, 56, 19, 65, 154, 99, 363 },
						{ 359, 12, 130, 481, 92, 26, 624, 714, 53, 21, 743, 13, 3, 718, 33, 930, 13, 1, 79, 88, 41, 91, 36, 30,
								16, 974, 950, 9, 759, 5, 29, 63, 55, 45, 93, 56, 580, 6, 93, 452 },
						{ 2, 19, 864, 535, 800, 3, 27, 36, 9, 974, 876, 21, 73, 11, 2, 130, 694, 16, 7, 334, 248, 25, 86, 944,
								79, 441, 92, 6, 800, 7, 93, 9, 254, 22, 930, 744, 7, 475, 498, 252 },
						{ 640, 36, 35, 843, 718, 22, 76, 8, 17, 33, 972, 39, 96, 76, 42, 378, 89, 96, 77, 65, 344, 87, 17, 17,
								62, 86, 594, 790, 56, 2, 43, 83, 520, 864, 92, 31, 71, 845, 174, 780 },
						{ 644, 59, 33, 671, 89, 364, 854, 21, 65, 2, 584, 570, 95, 26, 924, 87, 804, 17, 2, 168, 42, 42, 918, 6,
								96, 178, 724, 610, 818, 46, 964, 194, 97, 59, 634, 21, 630, 969, 47, 75 },
						{ 91, 13, 224, 120, 85, 7, 92, 72, 468, 920, 949, 93, 7, 57, 13, 538, 920, 65, 9, 37, 200, 57, 12, 31,
								79, 310, 92, 888, 77, 444, 734, 59, 27, 898, 59, 33, 418, 935, 73, 272 },
						{ 674, 93, 63, 490, 1, 63, 870, 49, 23, 984, 131, 52, 39, 99, 338, 6, 114, 69, 87, 47, 86, 12, 52, 110,
								61, 81, 984, 284, 384, 52, 804, 750, 83, 87, 174, 99, 23, 482, 7, 232 },
						{ 53, 55, 9, 264, 73, 35, 92, 31, 35, 61, 670, 65, 66, 37, 96, 21, 86, 83, 21, 19, 79, 7, 2, 46, 15, 59,
								76, 83, 47, 7, 35, 52, 71, 7, 32, 87, 27, 680, 52, 990 }

				};
				// -------------------------------------------------------------------------------------------------------------------
				
	
		int execucoes = 100;
		double resultados[] = new double[execucoes];
		for (int i = 0; i < execucoes; i++) {
			
			ArrayList<Objeto> objetos = Objeto.criaObjetos(pesos, lucro);
			ArrayList<Mochila> mochilas = Mochila.criaMochilas(capMochilas);

			ArrayList<Individuo> populacao = Individuo.geraPopulacao(100, objetos, mochilas);

			Edb edb = new Edb(0.1, 0.5, populacao);

			Individuo e = edb.execute(300);

			resultados[i] = e.fitness();
			
			System.out.println((i+1)+"% conclu�do");
		}
		System.out.println("M�dia.: "+Canivete.avg(resultados));
		System.out.println("Desvio Padr�o.: "+Canivete.desvPad(resultados));

	}

}