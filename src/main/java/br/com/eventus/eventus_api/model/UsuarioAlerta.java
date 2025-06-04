package br.com.eventus.eventus_api.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "usuario_alerta")
public class UsuarioAlerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario_alerta")
    private Long idUsuarioAlerta;

    @Column(name = "usuario_id_usuario", nullable = false)
    private Long usuarioIdUsuario;

    @Column(name = "alertas_id", nullable = false)
    private Long alertasId;

    @Column(name = "data_recebimento")
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
