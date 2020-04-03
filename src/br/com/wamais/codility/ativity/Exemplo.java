package br.com.wamais.codility.ativity;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Exemplo {

	private int solutionVal = 1;

	public int solution(final int[] A) {

		Arrays.sort(A);
		IntStream.range(0, A.length - 1).forEach(i -> {
			this.doSomething(A[i], A[i + 1]);
		});

		return (this.solutionVal > 0) ? this.solutionVal : A[A.length - 1]+1;
	}

	public int doSomething(final Integer current, final Integer next) {

		int returnVal = 0;
		if (this.solutionVal > 1 || current < 0) {
			return 0;
		}
		if ((next == 0 || next == null) || (next - current) >= 2) {
			returnVal = current + 1;
		}
		this.solutionVal = returnVal;
		
		return returnVal;

	}

	public static void main(final String[] args) {

		final int[] unordered = { 1, 3, 6, 4, 1, 2 };
		final Exemplo s = new Exemplo();
		final int solucao = s.solution(unordered);
		System.out.println(solucao);
		
		final int[] unordered2 = { -1, -3 };
		
		final int solucao2 = s.solution(unordered2);
		System.out.println(solucao2);
		
		final int[] unordered3 = { 1, 2, 3 };
		
		final int solucao3 = s.solution(unordered3);
		System.out.println(solucao3);
		
		
		

	}
}
