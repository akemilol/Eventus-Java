
package br.com.eventus.eventus_api.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "alerta")
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alerta")
    private Long idAlerta;

    @Column(name = "tipo_alerta", nullable = false, length = 40)
    private String tipoAlerta;

    @Column(name = "descricao", nullable = false, length = 200)
    private String descricao;

    @Column(name = "cep_alerta", nullable = false, length = 8)
    private String cepAlerta;

    @Column(name = "data_hora")
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
