package neves.jesus.felipe.wesley.TINNChallenge.exerccicio1;

import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import neves.jesus.felipe.wesley.TINNChallenge.exercicio1.CalculadoraEleitoral;

import static org.hamcrest.CoreMatchers.*;

public class CalculadoraEleitoralTest {
	
	private CalculadoraEleitoral calculadora;
	
	@Before
	public void init() {
		calculadora =  CalculadoraEleitoral.builder()
						.totalEleitores(1000L)
						.votosValidos(800L)
						.votosBrancos(150L)
						.votosNulos(50L)
						.build();
	}
	
	@Test
	public void getPercentualVotosValidosTest() {
		assertThat(calculadora.getPercentualVotosValidos(), is(BigDecimal.valueOf(0.8)));
	}
	
	
	@Test
	public void getPercentualVotosBrancosTest() {
		assertThat(calculadora.getPercentualVotosBrancos(), is(BigDecimal.valueOf(0.15)));
	}
	
	
	@Test
	public void getPercentualVotosNulosTest() {
		assertThat(calculadora.getPercentualVotosNulos(), is(BigDecimal.valueOf(0.05)));
	}
	
//	Essa exceção será lançada para todos os percentuais 
//	caso o valor total eleitores for igual a zero.
	@Test(expected = ArithmeticException.class)
	public void getPercentualVotosValidosComTotalEleitoresZeroTest() {
		calculadora.setTotalEleitores(0L);
		assertThat(calculadora.getPercentualVotosValidos(), is(BigDecimal.ZERO));
	}
	
	
	
}
