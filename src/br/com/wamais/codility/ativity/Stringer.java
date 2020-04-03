package br.com.wamais.codility.ativity;


public class Stringer {

	public String solution(String S) {
        
		//Limpa Diferente de Numericos
		String stringHigienizada = S.replaceAll("[^\\d.]", "");
        //Converte em Array de Caracteres para incluir o hofem
		char[] charArray = stringHigienizada.toCharArray();
        StringBuilder valorDeRetorno = new StringBuilder();

        int contagemHifen = 3;
        
        //Verifica se é um multiplo de 3
        boolean multiplodeTres = charArray.length % 3 == 1;

        //Determina a quantidade de hifens pelo tamanho da string
        int quantidadeHifen = Math.round(charArray.length / 3) - 1;

        for (int i = 0; i < charArray.length; i++) {
        	//Adiciona o caractere ao retorno
            valorDeRetorno.append(charArray[i]);
            //decrementa os caracteres restantes para hifens
            contagemHifen--;
            //verifica se é o momento de incluir um hifem
            if (contagemHifen == 0 && i != charArray.length - 1) {
                valorDeRetorno.append("-");
                quantidadeHifen--;
                //redimensiona a quantidade de hifens de acordo com o tamanho da string
                contagemHifen = (multiplodeTres && quantidadeHifen == 0) ? 2 : 3;
            }
        }
        return valorDeRetorno.toString();

        
	}
	
	public static void main (String[] args) {
		
		Stringer ss = new Stringer();
		
		String[] s5 = {"00", "000", "0000", "00000", "000000", "0000000"};
		for (String string : s5) {
			System.out.println(ss.solution(string));
		}
        
        
		String s = "00-44  48 5555 8361";
        System.out.println(ss.solution(s));

        String s1 = "0 - 22 1985--324";
        System.out.println(ss.solution(s1));

        String s2 = "555372654";
        System.out.println(ss.solution(s2));

        String s3 = "55537265465469876";
        System.out.println(ss.solution(s3));
	}

}
