package br.com.eventus.eventus_api.controller;

import br.com.eventus.eventus_api.model.Alerta;
import br.com.eventus.eventus_api.repository.AlertaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/alertas")
public class AlertaController {

    @Autowired
    private AlertaRepository alertaRepository;

    @GetMapping
    public Page<Alerta> listar(Pageable pageable, @RequestParam(required = false) String tipoAlerta) {
        if (tipoAlerta != null && !tipoAlerta.isEmpty()) {
            return alertaRepository.findByTipoAlertaContainingIgnoreCase(tipoAlerta, pageable);
        }
        return alertaRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alerta> buscarPorId(@PathVariable Long id) {
        Optional<Alerta> alerta = alertaRepository.findById(id);
        return alerta.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Alerta> criar(@RequestBody @Valid Alerta alerta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alertaRepository.save(alerta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alerta> atualizar(@PathVariable Long id, @RequestBody @Valid Alerta alertaAtualizado) {
        Optional<Alerta> alertaOptional = alertaRepository.findById(id);
        if (alertaOptional.isPresent()) {
            Alerta alerta = alertaOptional.get();
            alerta.setTipoAlerta(alertaAtualizado.getTipoAlerta());
            alerta.setDescricao(alertaAtualizado.getDescricao());
            alerta.setCepAlerta(alertaAtualizado.getCepAlerta());
            alerta.setDataHora(alertaAtualizado.getDataHora());
            return ResponseEntity.ok(alertaRepository.save(alerta));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (alertaRepository.existsById(id)) {
            alertaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
