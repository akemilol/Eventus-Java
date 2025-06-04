package br.com.eventus.eventus_api.dto;

public class UsuarioAbrigoDTO {
    private Long idUsuarioAbrigos;
    private Long usuarioIdUsuario;
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
