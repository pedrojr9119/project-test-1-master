package br.com.neppo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MathUtil {

    /**
     * Dado um conjunto de números inteiros "ints" e um número arbitrário "sum",
     * retorne true caso exista pelo menos um subconjunto de "ints" cuja soma soma dos seus elementos
     * seja igual a "sum"
     *
     * @param ints Conjunto de inteiros
     * @param sum Soma para o subconjunto
     * @return
     * @throws IllegalArgumentException caso o argumento "ints" seja null
     */
	public static boolean subsetSumChecker(int ints[], int sum){

		if (ints == null) {
			throw new IllegalArgumentException("Não foi passado nenhum número");
		}
		
		// Converter para list
		List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
		
		if (list.stream().filter(item -> item < 0).count() > 0) {
			list = list.stream().sorted().collect(Collectors.toList());
		} else {
			list = list.stream().filter(item -> item < sum).sorted().collect(Collectors.toList());
		}

		
		int posicaoElemento = 0;
		int tamanhoSubList = 1;

		while (posicaoElemento != list.size()) {
			int valorSoma = 0;
			valorSoma = somaLista(list.subList(posicaoElemento, tamanhoSubList));
			
			if (valorSoma == sum) {
				System.out.println("Conjunto de Números");
				System.out.println(list.subList(posicaoElemento, tamanhoSubList));
				return true;
			} else {
				tamanhoSubList++;
			}

			// Próximo elemento
			if (tamanhoSubList - 1 == list.size()) {
				posicaoElemento++;
				tamanhoSubList = 1;
			}
			
			// Trata exceção de montar a subList
			if (tamanhoSubList < posicaoElemento) {
				tamanhoSubList = posicaoElemento;
			}
		}

		return false;
	}

	private static int somaLista(List<Integer> list) {
		return list.stream().mapToInt(Integer::intValue).sum();
	}
}
