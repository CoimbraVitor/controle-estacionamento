package com.vitor.estacionamento.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitor.estacionamento.entity.Veiculo;
import com.vitor.estacionamento.service.VeiculoService;

@RestController
@RequestMapping("veiculo")
public class VeiculoController {

	private final VeiculoService service;

	public VeiculoController(VeiculoService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<List<Veiculo>> createVeiculo(@RequestBody Veiculo req) {
		List<Veiculo> veiculo = this.service.createVeiculo(req);
		return ResponseEntity.status(HttpStatus.CREATED).body(veiculo);
	}

	@GetMapping
	public ResponseEntity<List<Veiculo>> listVeiculo() {
		List<Veiculo> veiculos = this.service.findAll();
		return ResponseEntity.ok(veiculos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Veiculo> getVeiculoById(@PathVariable int id) {

		Veiculo veiculo = service.findById(id);

		return ResponseEntity.ok(veiculo);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteVeiculo(@PathVariable int id) {
		this.service.deleteVeiculo(id);
		return ResponseEntity.ok("Veículo deletado com sucesso");
	}

	@PutMapping
	public ResponseEntity<?> updateVeiculo(@RequestBody Veiculo req) {
		try {
			List<Veiculo> atualizado = this.service.updateVeiculo(req);
			return ResponseEntity.ok(atualizado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}
