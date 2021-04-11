package neves.jesus.felipe.wesley.TINNChallenge.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@JsonInclude(value = Include.NON_NULL)
public class VeiculoDto {
	
	private Long id;
	@NonNull
	private String veiculo;
	@NonNull
	private String marca;
	@NonNull
	private Integer ano;
	@NonNull
	private String descricao;
	@NonNull
	private boolean vendido;
	private String created;
	private String updated;

}
