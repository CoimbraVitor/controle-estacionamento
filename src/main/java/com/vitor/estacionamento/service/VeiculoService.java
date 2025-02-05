package com.vitor.estacionamento.service;

import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.vitor.estacionamento.entity.Estabelecimento;
import com.vitor.estacionamento.entity.Veiculo;
import com.vitor.estacionamento.repositories.VeiculoRepository;

@Service
public class VeiculoService {

	private final VeiculoRepository repository; 

	public VeiculoService(VeiculoRepository repository) {
		this.repository = repository;
	}

	public List<Veiculo> createVeiculo(Veiculo req) {

		this.repository.save(req);

		return this.findAll();

	}

	public List<Veiculo> updateVeiculo(Veiculo req) throws BadRequestException {
		
		if(req.getId() == null) {
			throw new BadRequestException("id não pode ser nulo");
		}
		
		Veiculo existente = this.repository.findById(req.getId())
		        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Estabelecimento não encontrado"));


		this.repository.save(req);

		return this.findAll();

	}

	public List<Veiculo> deleteVeiculo(int id) {

		this.repository.deleteById(id);

		return this.findAll();

	}

	public List<Veiculo> findAll() {

		return this.repository.findAll();

	}

	public Veiculo findById(int id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Veículo não encontrado"));
	}
}
