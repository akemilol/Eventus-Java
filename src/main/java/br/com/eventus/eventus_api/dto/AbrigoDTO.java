package br.com.eventus.eventus_api.dto;

public class AbrigoDTO {
    private Long idAbrigo;
    private String nomeAbrigo;
    private String enderecoAbrigo;
    private String cepAbrigo;
    private String cidadeAbrigo;
    private String ufAbrigo;
    private Double latitudeAbrig;
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
