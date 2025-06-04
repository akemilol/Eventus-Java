package br.com.eventus.eventus_api.dto;

import java.time.LocalDateTime;

public class RelatoDTO {
    private Long idRelato;
    private Long usuarioIdUsuario;
    private String tipoRelato;
    private String descricaoRelato;
    private String cepRelato;
    private LocalDateTime dataHoraRelato;

    public Long getIdRelato() {
        return idRelato;
    }

    public void setIdRelato(Long idRelato) {
        this.idRelato = idRelato;
    }

    public Long getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(Long usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    public String getTipoRelato() {
        return tipoRelato;
    }

    public void setTipoRelato(String tipoRelato) {
        this.tipoRelato = tipoRelato;
    }

    public String getDescricaoRelato() {
        return descricaoRelato;
    }

    public void setDescricaoRelato(String descricaoRelato) {
        this.descricaoRelato = descricaoRelato;
    }

    public String getCepRelato() {
        return cepRelato;
    }

    public void setCepRelato(String cepRelato) {
        this.cepRelato = cepRelato;
    }

    public LocalDateTime getDataHoraRelato() {
        return dataHoraRelato;
    }

    public void setDataHoraRelato(LocalDateTime dataHoraRelato) {
        this.dataHoraRelato = dataHoraRelato;
    }
}
