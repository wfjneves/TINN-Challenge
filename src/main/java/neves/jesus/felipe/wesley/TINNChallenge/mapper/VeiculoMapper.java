package neves.jesus.felipe.wesley.TINNChallenge.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import neves.jesus.felipe.wesley.TINNChallenge.model.Veiculo;
import neves.jesus.felipe.wesley.TINNChallenge.model.VeiculoDto;

@Mapper(componentModel = "spring")
public interface VeiculoMapper {
	
	VeiculoMapper INSTANCE =  Mappers.getMapper(VeiculoMapper.class);
	

	@Mapping(source = "created", target = "created", dateFormat = "dd/MM/YYYY" )
	@Mapping(source = "updated", target = "updated", dateFormat = "dd/MM/YYYY" )
	VeiculoDto veiculoToVeiculoDto(Veiculo veiculo);
	
	@Mapping(source = "created", target = "created", dateFormat = "dd/MM/YYYY" )
	@Mapping(source = "updated", target = "updated", dateFormat = "dd/MM/YYYY" )
	Veiculo veiculoDtoToVeiculo(VeiculoDto veiculoDto);
	
	List<VeiculoDto> veiculoToVeiculoDto(List<Veiculo> veiculo);

}
