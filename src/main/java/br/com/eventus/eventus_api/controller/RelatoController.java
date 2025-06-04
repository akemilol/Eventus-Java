package br.com.eventus.eventus_api.controller;

import br.com.eventus.eventus_api.model.Relato;
import br.com.eventus.eventus_api.repository.RelatoRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/relatos")
@Tag(name = "Relatos", description = "Gerenciamento dos relatos de eventos extremos")
public class RelatoController {

    @Autowired
    private RelatoRepository relatoRepository;

    @GetMapping
    public List<Relato> listarTodos() {
        return relatoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Relato> buscarPorId(@PathVariable Long id) {
        Optional<Relato> relato = relatoRepository.findById(id);
        return relato.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Relato> criar(@RequestBody Relato relato) {
        Relato salvo = relatoRepository.save(relato);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Relato> atualizar(@PathVariable Long id, @RequestBody Relato relato) {
        if (relatoRepository.existsById(id)) {
            relato.setIdRelato(id);
            Relato salvo = relatoRepository.save(relato);
            return ResponseEntity.ok(salvo);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (relatoRepository.existsById(id)) {
            relatoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
