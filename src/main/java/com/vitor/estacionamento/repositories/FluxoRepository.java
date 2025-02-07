package com.vitor.estacionamento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitor.estacionamento.entity.Fluxo;
import com.vitor.estacionamento.entity.enums.Status;
@Repository
public interface FluxoRepository extends JpaRepository<Fluxo, Long> {
	List<Fluxo> findByEstabelecimentoIdAndStatus(Long estabelecimentoId, Status status);

}
