package br.com.eventus.eventus_api.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "relato")
public class Relato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_relato")
    private Long idRelato;

    @ManyToOne
    @JoinColumn(name = "usuario_id_usuario", nullable = false)
    private UsuarioEventus usuario;

    @Column(name = "tipo_relato", nullable = false, length = 30)
    private String tipoRelato;

    @Column(name = "descricao_relato", nullable = false, length = 200)
    private String descricaoRelato;

    @Column(name = "cep_relato", nullable = false, length = 8)
    private String cepRelato;

    @Column(name = "data_hora_relato")
    private LocalDateTime dataHoraRelato;

    public Long getIdRelato() {
        return idRelato;
    }

    public void setIdRelato(Long idRelato) {
        this.idRelato = idRelato;
    }

    public UsuarioEventus getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEventus usuario) {
        this.usuario = usuario;
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
