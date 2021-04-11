package neves.jesus.felipe.wesley.TINNChallenge.exercicio1;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CalculadoraEleitoral {
	private Long totalEleitores;
	private Long votosValidos;
	private Long votosBrancos;
	private Long votosNulos;

	public BigDecimal getPercentualVotosValidos() {
		return BigDecimal.valueOf(votosValidos).divide(BigDecimal.valueOf(totalEleitores));
	}

	public BigDecimal getPercentualVotosBrancos() {
		return BigDecimal.valueOf(votosBrancos).divide(BigDecimal.valueOf(totalEleitores));
	}

	public BigDecimal getPercentualVotosNulos() {
		return BigDecimal.valueOf(votosNulos).divide(BigDecimal.valueOf(totalEleitores));
	}

}
