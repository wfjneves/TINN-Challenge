package neves.jesus.felipe.wesley.TINNChallenge.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class StatusVendaCarroDto {
	
	@NonNull
	private Long id;

	@NonNull
	private boolean statusDeVenda;

}
