package neves.jesus.felipe.wesley.TINNChallenge.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = Include.NON_NULL)
public class VeiculoDto {

	public VeiculoDto(String veiculo, String marca, int ano, String descricao, boolean vendido) {
		this.veiculo = veiculo;
		this.marca = marca;
		this.ano = ano;
		this.descricao = descricao;
		this.vendido = vendido;
	}

	private Long id;
	private String veiculo;
	private String marca;
	private Integer ano;
	private String descricao;
	private boolean vendido;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate created;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate updated;

}
