package neves.jesus.felipe.wesley.TINNChallenge.model.repository.veiculo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import neves.jesus.felipe.wesley.TINNChallenge.model.FiltroVeiculoDto;
import neves.jesus.felipe.wesley.TINNChallenge.model.VeiculoDto;

@Repository
public interface VeiculoRepositoryQuery {
	
	Page<VeiculoDto> findVeiculos(FiltroVeiculoDto veiculo, Pageable pageable);

}
