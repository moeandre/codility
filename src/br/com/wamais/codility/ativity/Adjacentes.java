package br.com.wamais.codility.ativity;

import java.util.Arrays;

public class Adjacentes {

	public int solution(final int[] A) {

		//Se o tamanho do array for igual a 1 não existem adjascentes
		//retorna -2,conforme enunciado
		if (A.length == 1) {
			return -2;
		}

		//Ordena o Array
		Arrays.sort(A);
		
		//define a distancia mácima
		int distanciaMinima = Integer.MAX_VALUE;
		
		//itera o array
		for (int i = 1; i < A.length; i++) {
			
			//calcula a distancia
			final int distanciaAtual = A[i] - A[i - 1];
			
			//se a distancia atual for menor que a distancia máxima, redefine a máxima
			if (distanciaAtual < distanciaMinima) {
				distanciaMinima = distanciaAtual;

			}
		}

		//Caso a distancia seja maior que 100M, retornamos -1
		//sen ão a distancia calculada
		return distanciaMinima > 100000000 ? -1 : (int) distanciaMinima;
		
	}

	public static void main(final String[] args) {

		final Adjacentes adjacentes = new Adjacentes();
		
		int[] a1 = {0, 3, 3, 7, 5, 3, 11, 1};
		
		int retorno1 = adjacentes.solution(a1);
		System.out.println(retorno1);
		
		int[] a2= {0, 1, 3, 4, 5, 61, 7};
		int retorno2 = adjacentes.solution(a2);
		System.out.println(retorno2);
		
		int[] a3= {2, 4, 6, 8, 10, 12, 14};
		int retorno3 = adjacentes.solution(a3);
		System.out.println(retorno3);
		
		int[] a4= {3, 6, 9, 12, 15, 18, 21};
		int retorno4 = adjacentes.solution(a4);
		System.out.println(retorno4);
		
		int[] a5= {3};
		int retorno5 = adjacentes.solution(a5);
		System.out.println(retorno5);
		

	}

}
