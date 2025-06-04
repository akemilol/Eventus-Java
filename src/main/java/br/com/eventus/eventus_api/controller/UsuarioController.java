package br.com.eventus.eventus_api.controller;

import br.com.eventus.eventus_api.dto.UsuarioCreateDTO;
import br.com.eventus.eventus_api.dto.UsuarioResponseDTO;
import br.com.eventus.eventus_api.model.UsuarioEventus;
import br.com.eventus.eventus_api.repository.UsuarioRepository;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@Tag(name = "Usuários", description = "Gerenciamento de usuários do Eventus")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<UsuarioResponseDTO> listarTodos() {
        return usuarioRepository.findAll().stream()
                .map(this::toResponseDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscarPorId(@PathVariable Long id) {
        Optional<UsuarioEventus> usuario = usuarioRepository.findById(id);
        return usuario.map(user -> ResponseEntity.ok(toResponseDTO(user)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> criar(@RequestBody @Valid UsuarioCreateDTO dto) {
        UsuarioEventus usuario = new UsuarioEventus();
        usuario.setNomeUsuario(dto.getNomeUsuario());
        usuario.setEmailUsuario(dto.getEmailUsuario());
        usuario.setSenhaUsuario(new BCryptPasswordEncoder().encode(dto.getSenhaUsuario()));
        usuario.setCpfUsuario(dto.getCpfUsuario());
        usuario.setCepUsuario(dto.getCepUsuario());
        usuario.setDataNascimento(dto.getDataNascimento());
        usuario.setRole(dto.getRole());
        UsuarioEventus salvo = usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponseDTO(salvo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid UsuarioCreateDTO dto) {
        Optional<UsuarioEventus> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            UsuarioEventus usuario = usuarioOptional.get();
            usuario.setNomeUsuario(dto.getNomeUsuario());
            usuario.setEmailUsuario(dto.getEmailUsuario());
            usuario.setSenhaUsuario(new BCryptPasswordEncoder().encode(dto.getSenhaUsuario()));
            usuario.setCpfUsuario(dto.getCpfUsuario());
            usuario.setCepUsuario(dto.getCepUsuario());
            usuario.setDataNascimento(dto.getDataNascimento());
            usuario.setRole(dto.getRole());
            UsuarioEventus salvo = usuarioRepository.save(usuario);
            return ResponseEntity.ok(toResponseDTO(salvo));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    private UsuarioResponseDTO toResponseDTO(UsuarioEventus entity) {
        UsuarioResponseDTO dto = new UsuarioResponseDTO();
        dto.setIdUsuario(entity.getIdUsuario());
        dto.setNomeUsuario(entity.getNomeUsuario());
        dto.setEmailUsuario(entity.getEmailUsuario());
        dto.setCpfUsuario(entity.getCpfUsuario());
        dto.setCepUsuario(entity.getCepUsuario());
        dto.setDataNascimento(entity.getDataNascimento().toString());
        dto.setRole(entity.getRole().toString());
        return dto;
    }
}
