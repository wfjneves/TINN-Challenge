package neves.jesus.felipe.wesley.TINNChallenge.exerccicio2;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import neves.jesus.felipe.wesley.TINNChallenge.exercicio2.BubbleSort;

public class BubbleSortTest {

	@Test
	public void testeOrdenacao() {
		Integer[] ordenado = BubbleSort.sort(new Integer[] { 5, 3, 2, 4, 7, 1, 0, 6 });
		assertThat(ordenado, is(equalTo(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7 })));
	}

}
