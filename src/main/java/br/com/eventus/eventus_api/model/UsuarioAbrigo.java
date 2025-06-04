package br.com.eventus.eventus_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario_abrigo")
public class UsuarioAbrigo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario_abrigos")
    private Long idUsuarioAbrigos;

    @Column(name = "usuario_id_usuario", nullable = false)
    private Long usuarioIdUsuario;

    @Column(name = "abrigos_id", nullable = false)
    private Long abrigosId;

    public Long getIdUsuarioAbrigos() {
        return idUsuarioAbrigos;
    }

    public void setIdUsuarioAbrigos(Long idUsuarioAbrigos) {
        this.idUsuarioAbrigos = idUsuarioAbrigos;
    }

    public Long getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(Long usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    public Long getAbrigosId() {
        return abrigosId;
    }

    public void setAbrigosId(Long abrigosId) {
        this.abrigosId = abrigosId;
    }
}

