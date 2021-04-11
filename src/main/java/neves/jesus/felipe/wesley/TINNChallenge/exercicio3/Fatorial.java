package neves.jesus.felipe.wesley.TINNChallenge.exercicio3;

public class Fatorial {
	
	public static Integer fatorial(Integer valor) {
		if (valor < 0 ) {
			throw new IllegalArgumentException("Apenas numeros naturais são permitidos");
		}
		
		if (valor==0 || valor == 1) {
			return 1;
		}
		return valor*fatorial(valor-1);
	}

}
