package neves.jesus.felipe.wesley.TINNChallenge.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import neves.jesus.felipe.wesley.TINNChallenge.exception.MarcaException;
import neves.jesus.felipe.wesley.TINNChallenge.exception.VeiculoNotFoundException;
import neves.jesus.felipe.wesley.TINNChallenge.mapper.VeiculoMapper;
import neves.jesus.felipe.wesley.TINNChallenge.model.entity.Veiculo;
import neves.jesus.felipe.wesley.TINNChallenge.model.repository.VeiculoRepository;

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
			veiculo.setCreated(LocalDate.now());
		} else {
			veiculo.setUpdated(LocalDate.now());
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
	
	public Page<VeiculoDto> findVeiculos(FiltroVeiculoDto filtro, Pageable pageable) {
		return veiculoRepository.findVeiculos(filtro, pageable);
	}
}
