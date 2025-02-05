package com.vitor.estacionamento.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;


@Entity
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

    @NotNull(message = "Marca é obrigatória")
    private String marca;

    @NotNull(message = "Modelo é obrigatório")
    private String modelo;

    @NotNull(message = "Cor é obrigatória")
    private String cor;

    @NotNull(message = "Placa é obrigatória")
    private String placa;

    @NotNull(message = "Tipo de veículo é obrigatório")
    private TipoVeiculo tipo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public TipoVeiculo getTipo() {
		return tipo;
	}

	public void setTipo(TipoVeiculo tipo) {
		this.tipo = tipo;
	}

}

enum TipoVeiculo {
	CARRO, MOTO
}
