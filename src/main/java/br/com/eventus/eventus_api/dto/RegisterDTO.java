package br.com.eventus.eventus_api.dto;

import br.com.eventus.eventus_api.model.UserRole;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class RegisterDTO {

    @NotBlank
    @Size(max = 100)
    private String nomeUsuario;

    @NotBlank
    @Email
    @Size(max = 100)
    private String emailUsuario;

    @NotBlank
    @Size(min = 6, max = 40)
    private String senhaUsuario;

    @NotBlank
    @Pattern(regexp = "\\d{11}", message = "O CPF deve ter 11 dígitos")
    private String cpfUsuario;

    @NotBlank
    @Pattern(regexp = "\\d{8}", message = "O CEP deve ter 8 dígitos")
    private String cepUsuario;

    @NotNull
    private LocalDate dataNascimento;

    @NotNull
    private UserRole role;

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
}
