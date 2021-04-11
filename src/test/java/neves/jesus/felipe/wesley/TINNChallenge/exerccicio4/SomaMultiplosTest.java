package neves.jesus.felipe.wesley.TINNChallenge.exerccicio4;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import neves.jesus.felipe.wesley.TINNChallenge.exercicio4.SomaMultiplos;

public class SomaMultiplosTest {

	@Test
	public void somaMultiplosDe3Ou5TestComResultadoIgualZero() {
		Integer resultado = SomaMultiplos.somarMultiplosDe3Ou5(2);
		assertThat(resultado, is(0));
	}
	
	@Test
	public void somaMultiplosDe3Ou5TestComResultadoDiferenteDeZero() {
		Integer resultado = SomaMultiplos.somarMultiplosDe3Ou5(9);
		assertThat(resultado, is(23));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void somaMultiplosDe3Ou5TestComException() {
		Integer resultado = SomaMultiplos.somarMultiplosDe3Ou5(-9);
		assertThat(resultado, is(-9));
	}
}
