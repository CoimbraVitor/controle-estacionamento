package com.vitor.estacionamento.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vitor.estacionamento.entity.Estabelecimento;
import com.vitor.estacionamento.entity.Fluxo;
import com.vitor.estacionamento.entity.Veiculo;
import com.vitor.estacionamento.entity.enums.Status;
import com.vitor.estacionamento.repositories.EstabelecimentoRepository;
import com.vitor.estacionamento.repositories.FluxoRepository;
import com.vitor.estacionamento.repositories.VeiculoRepository;

@Service
public class FluxoService {
	private final FluxoRepository fluxoRepository;
	private final EstabelecimentoRepository estabelecimentoRepository;
	private final VeiculoRepository veiculoRepository;

	public FluxoService(FluxoRepository fluxoRepository, EstabelecimentoRepository estabelecimentoRepository,
			VeiculoRepository veiculoRepository) {
		this.fluxoRepository = fluxoRepository;
		this.estabelecimentoRepository = estabelecimentoRepository;
		this.veiculoRepository = veiculoRepository;
	}

	public Fluxo registraEntrada(Integer estabelecimentoId, Integer veiculoId) {
		Estabelecimento estabelecimento = estabelecimentoRepository.findById(estabelecimentoId)
				.orElseThrow(() -> new RuntimeException("Estabelecimento não encontrado"));

		Veiculo veiculo = veiculoRepository.findById(veiculoId)
				.orElseThrow(() -> new RuntimeException("Veículo não encontrado"));

		Fluxo fluxo = new Fluxo();
		fluxo.setEstabelecimento(estabelecimento);
		fluxo.setVeiculo(veiculo);

		this.fluxoRepository.save(fluxo);

		return fluxo;

	}
	
    public Fluxo registrarSaida(Long movimentoId) {
    	Fluxo movimento = fluxoRepository.findById(movimentoId)
            .orElseThrow(() -> new RuntimeException("Movimento não encontrado"));

        if (movimento.getStatus() == Status.SAIU) {
            throw new RuntimeException("Este veículo já saiu do estacionamento!");
        }

        movimento.registrarSaida();
        return fluxoRepository.save(movimento);
    }

    public List<Fluxo> listarVeiculosNoEstacionamento(Long estabelecimentoId) {
        return fluxoRepository.findByEstabelecimentoIdAndStatus(estabelecimentoId, Status.DENTRO);
    }
}
