package br.com.eventus.eventus_api.repository;

import br.com.eventus.eventus_api.model.Relato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RelatoRepository extends JpaRepository<Relato, Long> {
    Page<Relato> findByTipoRelatoContainingIgnoreCase(String tipoRelato, Pageable pageable);
}
