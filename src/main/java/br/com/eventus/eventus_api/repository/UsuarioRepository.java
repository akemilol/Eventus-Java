package br.com.eventus.eventus_api.repository;

import br.com.eventus.eventus_api.model.UsuarioEventus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEventus, Long> {
    Page<UsuarioEventus> findByNomeUsuarioContainingIgnoreCase(String nomeUsuario, Pageable pageable);
    boolean existsByEmailUsuario(String emailUsuario);
    Optional<UsuarioEventus> findByEmailUsuario(String emailUsuario);
}
