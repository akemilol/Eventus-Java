package br.com.eventus.eventus_api.controller;

import br.com.eventus.eventus_api.model.Relato;
import br.com.eventus.eventus_api.repository.RelatoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/relatos")
public class RelatoController {

    @Autowired
    private RelatoRepository relatoRepository;

    @GetMapping
    public Page<Relato> listar(Pageable pageable, @RequestParam(required = false) String tipoRelato) {
        if (tipoRelato != null && !tipoRelato.isEmpty()) {
            return relatoRepository.findByTipoRelatoContainingIgnoreCase(tipoRelato, pageable);
        }
        return relatoRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Relato> buscarPorId(@PathVariable Long id) {
        Optional<Relato> relato = relatoRepository.findById(id);
        return relato.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Relato> criar(@RequestBody @Valid Relato relato) {
        return ResponseEntity.status(HttpStatus.CREATED).body(relatoRepository.save(relato));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Relato> atualizar(@PathVariable Long id, @RequestBody @Valid Relato relatoAtualizado) {
        Optional<Relato> relatoOptional = relatoRepository.findById(id);
        if (relatoOptional.isPresent()) {
            Relato relato = relatoOptional.get();
            relato.setTipoRelato(relatoAtualizado.getTipoRelato());
            relato.setDescricaoRelato(relatoAtualizado.getDescricaoRelato());
            relato.setCepRelato(relatoAtualizado.getCepRelato());
            relato.setDataHoraRelato(relatoAtualizado.getDataHoraRelato());
            relato.setUsuario(relatoAtualizado.getUsuario());
            return ResponseEntity.ok(relatoRepository.save(relato));
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
