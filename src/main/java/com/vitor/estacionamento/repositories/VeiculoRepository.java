package com.vitor.estacionamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitor.estacionamento.entity.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer>{

}
