package br.com.eventus.eventus_api.dto;

import java.time.LocalDate;

public class UsuarioAlertaDTO {
    private Long idUsuarioAlerta;
    private Long usuarioIdUsuario;
    private Long alertasId;
    private LocalDate dataRecebimento;

    public Long getIdUsuarioAlerta() {
        return idUsuarioAlerta;
    }

    public void setIdUsuarioAlerta(Long idUsuarioAlerta) {
        this.idUsuarioAlerta = idUsuarioAlerta;
    }

    public Long getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(Long usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    public Long getAlertasId() {
        return alertasId;
    }

    public void setAlertasId(Long alertasId) {
        this.alertasId = alertasId;
    }

    public LocalDate getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(LocalDate dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }
}
