package neves.jesus.felipe.wesley.TINNChallenge.exercicio4;

public class SomaMultiplos {

	public static Integer somarMultiplosDe3Ou5(Integer numero) {
		if (numero < 0) {
			throw new IllegalArgumentException("Apenas numeros naturais são permitidos");
		}
		Integer resultado = 0;
		do {
			if (numero % 3 == 0 || numero % 5 == 0) {
				resultado += numero;
			}
			numero--;

		} while (numero >= 3);
		return resultado;
	}
}
