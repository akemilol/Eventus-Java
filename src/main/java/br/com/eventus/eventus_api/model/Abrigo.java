package br.com.eventus.eventus_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "abrigo")
public class Abrigo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_abrigo")
    private Long idAbrigo;

    @Column(name = "nome_abrigo", nullable = false, length = 100)
    private String nomeAbrigo;

    @Column(name = "endereco_abrigo", nullable = false, length = 300)
    private String enderecoAbrigo;

    @Column(name = "cep_abrigo", nullable = false, length = 8)
    private String cepAbrigo;

    @Column(name = "cidade_abrigo", length = 50)
    private String cidadeAbrigo;

    @Column(name = "uf_abrigo", length = 2)
    private String ufAbrigo;

    @Column(name = "latitude_abrig")
    private Double latitudeAbrig;

    @Column(name = "longitude_abrig")
    private Double longitudeAbrig;

    public Long getIdAbrigo() {
        return idAbrigo;
    }

    public void setIdAbrigo(Long idAbrigo) {
        this.idAbrigo = idAbrigo;
    }

    public String getNomeAbrigo() {
        return nomeAbrigo;
    }

    public void setNomeAbrigo(String nomeAbrigo) {
        this.nomeAbrigo = nomeAbrigo;
    }

    public String getEnderecoAbrigo() {
        return enderecoAbrigo;
    }

    public void setEnderecoAbrigo(String enderecoAbrigo) {
        this.enderecoAbrigo = enderecoAbrigo;
    }

    public String getCepAbrigo() {
        return cepAbrigo;
    }

    public void setCepAbrigo(String cepAbrigo) {
        this.cepAbrigo = cepAbrigo;
    }

    public String getCidadeAbrigo() {
        return cidadeAbrigo;
    }

    public void setCidadeAbrigo(String cidadeAbrigo) {
        this.cidadeAbrigo = cidadeAbrigo;
    }

    public String getUfAbrigo() {
        return ufAbrigo;
    }

    public void setUfAbrigo(String ufAbrigo) {
        this.ufAbrigo = ufAbrigo;
    }

    public Double getLatitudeAbrig() {
        return latitudeAbrig;
    }

    public void setLatitudeAbrig(Double latitudeAbrig) {
        this.latitudeAbrig = latitudeAbrig;
    }

    public Double getLongitudeAbrig() {
        return longitudeAbrig;
    }

    public void setLongitudeAbrig(Double longitudeAbrig) {
        this.longitudeAbrig = longitudeAbrig;
    }
}
