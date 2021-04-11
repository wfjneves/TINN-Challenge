package neves.jesus.felipe.wesley.TINNChallenge.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "TB_CARRO")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Veiculo {

	@Id
	@GeneratedValue
	@EqualsAndHashCode.Include
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
	private LocalDateTime created;
	private LocalDateTime updated;
}
