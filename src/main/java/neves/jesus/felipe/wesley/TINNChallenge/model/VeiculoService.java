package neves.jesus.felipe.wesley.TINNChallenge.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neves.jesus.felipe.wesley.TINNChallenge.exception.MarcaException;
import neves.jesus.felipe.wesley.TINNChallenge.exception.VeiculoNotFoundException;
import neves.jesus.felipe.wesley.TINNChallenge.mapper.VeiculoMapper;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository veiculoRepository;

	@Autowired
	private VeiculoMapper veiculoMapper;

	public VeiculoDto save(VeiculoDto dto) {
		Veiculo veiculo = veiculoMapper.veiculoDtoToVeiculo(dto);
		Veiculo veiculoSalvo = saveInternal(veiculo);
		return veiculoMapper.veiculoToVeiculoDto(veiculoSalvo);
	}

	private Veiculo saveInternal(Veiculo veiculo) {
		if (MarcaEnum.getEnumPelaDescricao(veiculo.getMarca()) == null) {
			throw new MarcaException();
		}
		if (veiculo.getId() == null) {
			veiculo.setCreated(LocalDateTime.now());
		} else {
			veiculo.setUpdated(LocalDateTime.now());
			veiculo.setCreated(findByIdInternal(veiculo.getId()).getCreated());
		}
		Veiculo veiculoSalvo = veiculoRepository.save(veiculo);
		return veiculoSalvo;
	}

	public List<VeiculoDto> findAll() {
		return veiculoMapper.veiculoToVeiculoDto(veiculoRepository.findAll());
	}

	public void deleteById(Long id) {
		veiculoRepository.deleteById(id);
	}

	public VeiculoDto findById(Long id) {
		return veiculoMapper.veiculoToVeiculoDto(findByIdInternal(id));
	}

	private Veiculo findByIdInternal(Long id) {
		return veiculoRepository.findById(id).orElseThrow(() -> new VeiculoNotFoundException());
	}

	public void atualizarStatusDeVenda(StatusVendaCarroDto dto) {
		Veiculo carro = this.findByIdInternal(dto.getId());
		carro.setVendido(dto.isStatusDeVenda());
		this.saveInternal(carro);
	}

//	fazer testes unitário da api
//	fazer query sem paginação para retornar veiculos por ano, por statusvenda, marca, data criação
//	criar uma interface no angular para listar os veiculos com um botão para vender / cancelar venda, com um botão para excluir, um botão para redirecionar para tela de edição.
//	criar uma interface no angular para cadastrar e editar veiculo
//	não usar autenticação

}
