package com.vitor.estacionamento.entity;

import java.time.LocalDateTime;

import com.vitor.estacionamento.entity.enums.Status;

import jakarta.persistence.*;

@Entity
public class Fluxo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "estabelecimento_id", nullable = false)
	private Estabelecimento estabelecimento;

	@ManyToOne
	@JoinColumn(name = "veiculo_id", nullable = false)
	private Veiculo veiculo;

	private LocalDateTime horarioEntrada;
	private LocalDateTime horarioSaida;

	@Enumerated(EnumType.STRING)
	private Status status;

	public Fluxo() {
		this.horarioEntrada = LocalDateTime.now();
		this.status = Status.DENTRO;
	}

	public void registrarSaida() {
		this.horarioSaida = LocalDateTime.now();
		this.status = Status.SAIU;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public LocalDateTime getHorarioEntrada() {
		return horarioEntrada;
	}

	public void setHorarioEntrada(LocalDateTime horarioEntrada) {
		this.horarioEntrada = horarioEntrada;
	}

	public LocalDateTime getHorarioSaida() {
		return horarioSaida;
	}

	public void setHorarioSaida(LocalDateTime horarioSaida) {
		this.horarioSaida = horarioSaida;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
