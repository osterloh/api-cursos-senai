package br.com.senai.domain.repository;

import br.com.senai.domain.model.VagaSolicitada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VagaSolicitadaRepository extends JpaRepository<VagaSolicitada, Long> {
}
