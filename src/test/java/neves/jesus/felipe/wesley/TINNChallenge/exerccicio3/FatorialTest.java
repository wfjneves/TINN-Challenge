package neves.jesus.felipe.wesley.TINNChallenge.exerccicio3;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

import neves.jesus.felipe.wesley.TINNChallenge.exercicio3.Fatorial;

public class FatorialTest {
	
	@Test
	public void testeFatorial() {
 		assertThat(Fatorial.fatorial(6), is(720)); 
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testeFatorialException() {
		assertThat(Fatorial.fatorial(-6), is(-720)); 
	}

}
