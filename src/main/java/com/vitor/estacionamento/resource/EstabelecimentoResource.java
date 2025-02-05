package com.vitor.estacionamento.resource;

import java.util.List;

import org.apache.coyote.BadRequestException;
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

import com.vitor.estacionamento.entity.Estabelecimento;
import com.vitor.estacionamento.service.EstabelecimentoService;

@RestController
@RequestMapping("estabelecimento")
public class EstabelecimentoResource {

	private final EstabelecimentoService service;

	public EstabelecimentoResource(EstabelecimentoService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<Estabelecimento> createEstabelecimento(@RequestBody Estabelecimento estabelecimento) {
		Estabelecimento novo = service.createEstabelecimento(estabelecimento);
		return ResponseEntity.status(HttpStatus.CREATED).body(novo);
	}

	@GetMapping
	public ResponseEntity<List<Estabelecimento>> listEstabelecimentos() {
		List<Estabelecimento> estabelecimentos = service.findAll();
		return ResponseEntity.ok(estabelecimentos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Estabelecimento> getEstabelecimentoById(@PathVariable int id) {
		
		Estabelecimento estabelecimento = service.findById(id);
		
		return ResponseEntity.ok(estabelecimento);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateEstabelecimento(@PathVariable int id, @RequestBody Estabelecimento estabelecimento) {

		try {
			
			List<Estabelecimento> atualizado = service.updateEstabelecimento(estabelecimento);
			
			return ResponseEntity.ok(atualizado);

		} catch (BadRequestException e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
			
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEstabelecimento(@PathVariable int id) {
		service.deleteEstabelecimento(id);
		return ResponseEntity.ok("Estabelecimento deletado com sucesso");
	}
}
