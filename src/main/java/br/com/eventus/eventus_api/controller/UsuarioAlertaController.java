package br.com.eventus.eventus_api.controller;

import br.com.eventus.eventus_api.model.UsuarioAlerta;
import br.com.eventus.eventus_api.repository.UsuarioAlertaRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios-alertas")
@Tag(name = "Vínculo Usuário-Alerta", description = "Gerenciamento dos vínculos de usuários com alertas")
public class UsuarioAlertaController {

    @Autowired
    private UsuarioAlertaRepository usuarioAlertaRepository;

    @GetMapping
    public List<UsuarioAlerta> listarTodos() {
        return usuarioAlertaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioAlerta> buscarPorId(@PathVariable Long id) {
        Optional<UsuarioAlerta> usuarioAlerta = usuarioAlertaRepository.findById(id);
        return usuarioAlerta.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UsuarioAlerta> criar(@RequestBody UsuarioAlerta usuarioAlerta) {
        UsuarioAlerta salvo = usuarioAlertaRepository.save(usuarioAlerta);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioAlerta> atualizar(@PathVariable Long id, @RequestBody UsuarioAlerta usuarioAlerta) {
        if (usuarioAlertaRepository.existsById(id)) {
            usuarioAlerta.setIdUsuarioAlerta(id);
            UsuarioAlerta salvo = usuarioAlertaRepository.save(usuarioAlerta);
            return ResponseEntity.ok(salvo);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (usuarioAlertaRepository.existsById(id)) {
            usuarioAlertaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
