package neves.jesus.felipe.wesley.TINNChallenge.model.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_CARRO")
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Veiculo {

	public Veiculo(String veiculo, String marca, int ano, String descricao, boolean vendido, LocalDate created) {
		this.veiculo = veiculo;
		this.marca = marca;
		this.ano = ano;
		this.descricao = descricao;
		this.vendido = vendido;
		this.created = created;
	}
	
	@Id
	@GeneratedValue
	@EqualsAndHashCode.Include
	private Long id;
	private String veiculo;
	private String marca;
	private Integer ano;
	private String descricao;
	private boolean vendido;
	private LocalDate created;
	private LocalDate updated;
}
