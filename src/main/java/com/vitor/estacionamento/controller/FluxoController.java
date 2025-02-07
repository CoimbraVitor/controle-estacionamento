package com.vitor.estacionamento.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitor.estacionamento.entity.Fluxo;
import com.vitor.estacionamento.entity.dto.FluxoDTO;
import com.vitor.estacionamento.service.FluxoService;

@RestController
@RequestMapping("/fluxo")
public class FluxoController {

	
    private final FluxoService service;

    public FluxoController(FluxoService service) {
        this.service = service;
    }
    
    @PostMapping("/entrada")
    public ResponseEntity<Fluxo> registrarEntrada(@RequestBody FluxoDTO req) {
        Fluxo fluxo = service.registraEntrada(req.getEstabelecimentoId(), req.getVeiculoId());
        return ResponseEntity.ok(fluxo);
    }

    @PutMapping("/saida/{movimentoId}")
    public ResponseEntity<Fluxo> registrarSaida(@PathVariable Long movimentoId) {
        Fluxo fluxo = service.registrarSaida(movimentoId);
        return ResponseEntity.ok(fluxo);
    }

    @GetMapping("/{estabelecimentoId}")
    public ResponseEntity<List<Fluxo>> listarVeiculos(@PathVariable Long estabelecimentoId) {
        List<Fluxo> veiculos = service.listarVeiculosNoEstacionamento(estabelecimentoId);
        return ResponseEntity.ok(veiculos);
    }
}
