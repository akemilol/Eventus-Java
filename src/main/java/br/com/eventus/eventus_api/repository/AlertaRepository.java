package br.com.eventus.eventus_api.repository;

import br.com.eventus.eventus_api.model.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertaRepository extends JpaRepository<Alerta, Long> {
}
