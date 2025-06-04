package br.com.eventus.eventus_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuario_eventus")
public class UsuarioEventus implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @NotBlank
    @Size(max = 100)
    @Column(name = "nome_usuario", nullable = false)
    private String nomeUsuario;

    @NotBlank
    @Email
    @Size(max = 100)
    @Column(name = "email_usuario", nullable = false, unique = true)
    private String emailUsuario;

    @NotBlank
    @Size(min = 6, max = 255)
    @Column(name = "senha_usuario", nullable = false, length = 255)
    private String senhaUsuario;

    @NotBlank
    @Pattern(regexp = "\\d{11}", message = "O CPF deve ter 11 dígitos")
    @Column(name = "cpf_usuario", nullable = false, unique = true, length = 11)
    private String cpfUsuario;

    @NotBlank
    @Pattern(regexp = "\\d{8}", message = "O CEP deve ter 8 dígitos")
    @Column(name = "cep_usuario", nullable = false, length = 8)
    private String cepUsuario;

    @NotNull
    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private UserRole role;


    public Long getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getNomeUsuario() {
        return nomeUsuario;
    }
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
    public String getEmailUsuario() {
        return emailUsuario;
    }
    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }
    public String getSenhaUsuario() {
        return senhaUsuario;
    }
    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }
    public String getCpfUsuario() {
        return cpfUsuario;
    }
    public void setCpfUsuario(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }
    public String getCepUsuario() {
        return cepUsuario;
    }
    public void setCepUsuario(String cepUsuario) {
        this.cepUsuario = cepUsuario;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public UserRole getRole() {
        return role;
    }
    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }
    @Override
    public String getPassword() {
        return senhaUsuario;
    }
    @Override
    public String getUsername() {
        return emailUsuario;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}
