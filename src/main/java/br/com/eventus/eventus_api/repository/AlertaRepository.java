package br.com.eventus.eventus_api.repository;

import br.com.eventus.eventus_api.model.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AlertaRepository extends JpaRepository<Alerta, Long> {
    Page<Alerta> findByTipoAlertaContainingIgnoreCase(String tipoAlerta, Pageable pageable);
}
