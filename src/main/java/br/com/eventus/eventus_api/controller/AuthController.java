package br.com.eventus.eventus_api.controller;

import br.com.eventus.eventus_api.dto.AuthDTO;
import br.com.eventus.eventus_api.dto.LoginResponseDTO;
import br.com.eventus.eventus_api.dto.RegisterDTO;
import br.com.eventus.eventus_api.model.UsuarioEventus;
import br.com.eventus.eventus_api.repository.UsuarioRepository;
import br.com.eventus.eventus_api.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody @Valid AuthDTO body) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(body.getEmail(), body.getSenha());
        var auth = authManager.authenticate(usernamePassword);
        var token = tokenService.gerarToken((UsuarioEventus) auth.getPrincipal());
        return new LoginResponseDTO(token);
    }

    @PostMapping("/register")
    public void register(@RequestBody @Valid RegisterDTO body) {
        if (usuarioRepository.existsByEmailUsuario(body.getEmailUsuario())) return;
        var user = new UsuarioEventus();
        user.setNomeUsuario(body.getNomeUsuario());
        user.setEmailUsuario(body.getEmailUsuario());
        user.setSenhaUsuario(new BCryptPasswordEncoder().encode(body.getSenhaUsuario()));
        user.setCpfUsuario(body.getCpfUsuario());
        user.setCepUsuario(body.getCepUsuario());
        user.setDataNascimento(body.getDataNascimento());
        user.setRole(body.getRole());
        usuarioRepository.save(user);
    }
}
