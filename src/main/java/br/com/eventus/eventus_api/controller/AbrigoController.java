package br.com.eventus.eventus_api.controller;

import br.com.eventus.eventus_api.model.Abrigo;
import br.com.eventus.eventus_api.repository.AbrigoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/abrigos")
public class AbrigoController {

    @Autowired
    private AbrigoRepository abrigoRepository;

    @GetMapping
    public Page<Abrigo> listar(Pageable pageable, @RequestParam(required = false) String nomeAbrigo) {
        if (nomeAbrigo != null && !nomeAbrigo.isEmpty()) {
            return abrigoRepository.findByNomeAbrigoContainingIgnoreCase(nomeAbrigo, pageable);
        }
        return abrigoRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Abrigo> buscarPorId(@PathVariable Long id) {
        Optional<Abrigo> abrigo = abrigoRepository.findById(id);
        return abrigo.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Abrigo> criar(@RequestBody @Valid Abrigo abrigo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(abrigoRepository.save(abrigo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Abrigo> atualizar(@PathVariable Long id, @RequestBody @Valid Abrigo abrigoAtualizado) {
        Optional<Abrigo> abrigoOptional = abrigoRepository.findById(id);
        if (abrigoOptional.isPresent()) {
            Abrigo abrigo = abrigoOptional.get();
            abrigo.setNomeAbrigo(abrigoAtualizado.getNomeAbrigo());
            abrigo.setEnderecoAbrigo(abrigoAtualizado.getEnderecoAbrigo());
            abrigo.setCepAbrigo(abrigoAtualizado.getCepAbrigo());
            abrigo.setCidadeAbrigo(abrigoAtualizado.getCidadeAbrigo());
            abrigo.setUfAbrigo(abrigoAtualizado.getUfAbrigo());
            abrigo.setLatitudeAbrig(abrigoAtualizado.getLatitudeAbrig());
            abrigo.setLongitudeAbrig(abrigoAtualizado.getLongitudeAbrig());
            return ResponseEntity.ok(abrigoRepository.save(abrigo));
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
