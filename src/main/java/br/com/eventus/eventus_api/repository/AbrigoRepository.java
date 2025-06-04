package br.com.eventus.eventus_api.repository;

import br.com.eventus.eventus_api.model.Abrigo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AbrigoRepository extends JpaRepository<Abrigo, Long> {
    Page<Abrigo> findByNomeAbrigoContainingIgnoreCase(String nomeAbrigo, Pageable pageable);
}
