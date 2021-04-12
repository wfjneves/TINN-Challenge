package neves.jesus.felipe.wesley.TINNChallenge.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import neves.jesus.felipe.wesley.TINNChallenge.model.VeiculoDto;
import neves.jesus.felipe.wesley.TINNChallenge.model.entity.Veiculo;

@Mapper(componentModel = "spring")
public interface VeiculoMapper {
	
	VeiculoMapper INSTANCE =  Mappers.getMapper(VeiculoMapper.class);
	

	VeiculoDto veiculoToVeiculoDto(Veiculo veiculo);
	
	Veiculo veiculoDtoToVeiculo(VeiculoDto veiculoDto);
	
	List<VeiculoDto> veiculoToVeiculoDto(List<Veiculo> veiculo);
	
}
