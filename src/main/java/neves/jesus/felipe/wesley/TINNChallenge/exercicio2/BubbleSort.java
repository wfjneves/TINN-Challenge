package neves.jesus.felipe.wesley.TINNChallenge.exercicio2;

public class BubbleSort {

	public static Integer[] sort(Integer[] vetor) {
		Integer temporario = null;
		int quantidadeDeInteracoesParaOrdenar = vetor.length - 1;
		for (int interacao = 0; interacao < quantidadeDeInteracoesParaOrdenar; interacao++) {
			int quantidadeDeItensPendenteDeAvaliacaoDeOrdenacao = vetor.length - interacao; /*Para bloquear os itens já ordenado*/
			for (int posicao = 0; posicao < quantidadeDeItensPendenteDeAvaliacaoDeOrdenacao; posicao++) {
				int ultimaPosicaoElegivel = quantidadeDeItensPendenteDeAvaliacaoDeOrdenacao - 1;
				int proximaPosicao = posicao+1;
				if (proximaPosicao <= ultimaPosicaoElegivel && vetor[posicao] > vetor[proximaPosicao]) {
					temporario = vetor[posicao];
					vetor[posicao]=vetor[proximaPosicao];
					vetor[proximaPosicao]=temporario;
					temporario=null;
				}
			}
		}
		return vetor;
	}
}
