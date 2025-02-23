package com.vitor.estacionamento.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vitor.estacionamento.entity.Fluxo;
import com.vitor.estacionamento.entity.enums.Status;
@Repository
public interface FluxoRepository extends JpaRepository<Fluxo, Long> {
	
	List<Fluxo> findByEstabelecimentoIdAndStatus(Long estabelecimentoId, Status status);
	
	@Query("SELECT f FROM Fluxo f WHERE f.veiculo.id = :id AND f.estabelecimento.id = :estabelecimentoId AND f.status <> 'SAIU'")
	Optional<Fluxo> findFluxoAtivoByVeiculoEEstabelecimento(@Param("id") Integer id, @Param("estabelecimentoId") Integer estabelecimentoId);


}
