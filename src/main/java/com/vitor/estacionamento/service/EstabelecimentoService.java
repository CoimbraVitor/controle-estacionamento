package com.vitor.estacionamento.service;


import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.vitor.estacionamento.entity.Estabelecimento;
import com.vitor.estacionamento.repositories.EstabelecimentoRepository;

@Service
public class EstabelecimentoService {

	private final EstabelecimentoRepository repository;

	public EstabelecimentoService(EstabelecimentoRepository repository) {
		this.repository = repository;
	}

	public Estabelecimento createEstabelecimento(Estabelecimento estabelecimento) {
		return repository.save(estabelecimento);
	}

	public List<Estabelecimento> findAll() {
		return repository.findAll();
	}

	public Estabelecimento findById(int id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Estabelecimento não encontrado"));
	}

	public List<Estabelecimento> updateEstabelecimento(Estabelecimento req) throws BadRequestException {
    	
		if(req.getId() == null) {
			throw new BadRequestException("id não pode ser nulo");
		}
		
		Estabelecimento existente = this.repository.findById(req.getId())
		        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Estabelecimento não encontrado"));


		this.repository.save(req);

		return this.findAll();
    }

	public void deleteEstabelecimento(int id) {
		Estabelecimento estabelecimento = findById(id);
		repository.delete(estabelecimento);
	}
}
