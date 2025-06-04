package br.com.eventus.eventus_api.controller;

import br.com.eventus.eventus_api.model.UsuarioAbrigo;
import br.com.eventus.eventus_api.repository.UsuarioAbrigoRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios-abrigos")
@Tag(name = "Vínculo Usuário-Abrigo", description = "Gerenciamento dos vínculos de usuários com abrigos")
public class UsuarioAbrigoController {

    @Autowired
    private UsuarioAbrigoRepository usuarioAbrigoRepository;

    @GetMapping
    public List<UsuarioAbrigo> listarTodos() {
        return usuarioAbrigoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioAbrigo> buscarPorId(@PathVariable Long id) {
        Optional<UsuarioAbrigo> usuarioAbrigo = usuarioAbrigoRepository.findById(id);
        return usuarioAbrigo.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UsuarioAbrigo> criar(@RequestBody UsuarioAbrigo usuarioAbrigo) {
        UsuarioAbrigo salvo = usuarioAbrigoRepository.save(usuarioAbrigo);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioAbrigo> atualizar(@PathVariable Long id, @RequestBody UsuarioAbrigo usuarioAbrigo) {
        if (usuarioAbrigoRepository.existsById(id)) {
            usuarioAbrigo.setIdUsuarioAbrigos(id);
            UsuarioAbrigo salvo = usuarioAbrigoRepository.save(usuarioAbrigo);
            return ResponseEntity.ok(salvo);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (usuarioAbrigoRepository.existsById(id)) {
            usuarioAbrigoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
