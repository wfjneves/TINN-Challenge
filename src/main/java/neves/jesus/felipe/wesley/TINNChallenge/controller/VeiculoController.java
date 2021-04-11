package neves.jesus.felipe.wesley.TINNChallenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import neves.jesus.felipe.wesley.TINNChallenge.model.StatusVendaCarroDto;
import neves.jesus.felipe.wesley.TINNChallenge.model.VeiculoDto;
import neves.jesus.felipe.wesley.TINNChallenge.model.VeiculoService;

@RestController
@RequestMapping(path = "/veiculos")
public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;

	@GetMapping
	public ResponseEntity<List<VeiculoDto>> findAll() {
		return ResponseEntity.ok(veiculoService.findAll());
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<VeiculoDto> findById(@PathVariable Long id) {
		return ResponseEntity.ok(veiculoService.findById(id));
	}

	@PostMapping
	public ResponseEntity<VeiculoDto> incluir(@RequestBody VeiculoDto carro) {
		return ResponseEntity.status(HttpStatus.CREATED).body(veiculoService.save(carro));
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<VeiculoDto> atualizar(@RequestBody VeiculoDto carro, @PathVariable Long id) {
		carro.setId(id);
		return ResponseEntity.ok(veiculoService.save(carro));
	}

	@PatchMapping(path = "/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void atualizarStatusDeVenda(@RequestBody StatusVendaCarroDto dto, @PathVariable Long id) {
		veiculoService.atualizarStatusDeVenda(dto);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable Long id) {
		veiculoService.deleteById(id);
	}
}
