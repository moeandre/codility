package br.com.wamais.codility.ativity;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MaryCandies {

	public int solution(final int[] T) {

		// Quantidade de Doces da Mary
		final int quantidadeDoces = T.length;

		// Doces para dividir
		int docesParaDividir = Math.round(quantidadeDoces / 2);

		Map<Integer, Integer> estoqueInicial = new HashMap<Integer, Integer>();
		for (final int doce : T) {
			final int count = estoqueInicial.containsKey(doce) ? estoqueInicial.get(doce) : 0;
			estoqueInicial.put(doce, count + 1);
		}

		// Ordena por estoque decrescente para proporcinar a melhor distribuição
		// dos doces
		estoqueInicial = estoqueInicial.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		// Distribui e armazena em um novo componente
		final Map<Integer, Integer> estoqueFinal = new LinkedHashMap<Integer, Integer>();
		for (final Map.Entry<Integer, Integer> entry : estoqueInicial.entrySet()) {
			final int doce = entry.getKey();
			int docesEmEstoque = entry.getValue();

			if (docesEmEstoque > docesParaDividir && docesParaDividir > 0) {
				// Se o estoque for maior do que o a dividir, extrai tudo;
				// subtrai o estoque dos doces a dividir
				docesEmEstoque = docesEmEstoque - docesParaDividir;

				// Zera os doces que precisamos dividir
				docesParaDividir = 0;
			} else if (Math.round(docesEmEstoque / 2) >= 1) {
				// Caso seja divisivel por dois, calcula a metade
				final int dividir = Math.round(docesEmEstoque / 2);

				// Subtrai do estoque
				docesEmEstoque = docesEmEstoque - dividir;

				// subtrai dos divisores
				docesParaDividir = docesParaDividir - dividir;
			} else if (docesEmEstoque == 1 && docesParaDividir > 0) {

				// Se só houver 1 no estoque, mas ainda precisar retirar, aqui
				// faremos isso
				// Subtrai o estoque dos doces a dividir
				docesParaDividir = docesParaDividir - docesEmEstoque;

				// e zera o estoque
				docesEmEstoque = 0;
			}

			// Se houver estoque disponível alimenta a estrutura
			if (docesEmEstoque > 0) {
				estoqueFinal.put(doce, docesEmEstoque);
			}

		}

		return estoqueFinal.entrySet().size(); // retorna a quantidade de doces;

	}

	public static void main(final String[] args) {

		final MaryCandies maryCandies = new MaryCandies();

		final int[] a1 = { 3, 4, 7, 7, 6, 6 };
		final int resultado1 = maryCandies.solution(a1);
		System.out.println(resultado1);

		final int[] a2 = { 80, 80, 1000000000, 80, 80, 80, 80, 80, 80, 123456789 };
		final int resultado2 = maryCandies.solution(a2);
		System.out.println(resultado2);

	}

}
