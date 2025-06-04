package br.com.eventus.eventus_api.controller;

import br.com.eventus.eventus_api.model.Abrigo;
import br.com.eventus.eventus_api.repository.AbrigoRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/abrigos")
@Tag(name = "Abrigos", description = "Gerenciamento dos abrigos do sistema Eventus")
public class AbrigoController {

    @Autowired
    private AbrigoRepository abrigoRepository;

    @GetMapping
    public List<Abrigo> listarTodos() {
        return abrigoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Abrigo> buscarPorId(@PathVariable Long id) {
        Optional<Abrigo> abrigo = abrigoRepository.findById(id);
        return abrigo.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Abrigo> criar(@RequestBody Abrigo abrigo) {
        Abrigo salvo = abrigoRepository.save(abrigo);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Abrigo> atualizar(@PathVariable Long id, @RequestBody Abrigo abrigo) {
        if (abrigoRepository.existsById(id)) {
            abrigo.setIdAbrigo(id);
            Abrigo salvo = abrigoRepository.save(abrigo);
            return ResponseEntity.ok(salvo);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (abrigoRepository.existsById(id)) {
            abrigoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
