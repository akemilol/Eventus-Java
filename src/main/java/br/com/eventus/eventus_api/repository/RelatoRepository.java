package br.com.eventus.eventus_api.repository;

import br.com.eventus.eventus_api.model.Relato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelatoRepository extends JpaRepository<Relato, Long> {
}
