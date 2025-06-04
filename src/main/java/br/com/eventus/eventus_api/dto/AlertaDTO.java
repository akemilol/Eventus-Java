package br.com.eventus.eventus_api.dto;

import java.time.LocalDateTime;

public class AlertaDTO {
    private Long idAlerta;
    private String tipoAlerta;
    private String descricao;
    private String cepAlerta;
    private LocalDateTime dataHora;

    public Long getIdAlerta() {
        return idAlerta;
    }

    public void setIdAlerta(Long idAlerta) {
        this.idAlerta = idAlerta;
    }

    public String getTipoAlerta() {
        return tipoAlerta;
    }

    public void setTipoAlerta(String tipoAlerta) {
        this.tipoAlerta = tipoAlerta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCepAlerta() {
        return cepAlerta;
    }

    public void setCepAlerta(String cepAlerta) {
        this.cepAlerta = cepAlerta;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
