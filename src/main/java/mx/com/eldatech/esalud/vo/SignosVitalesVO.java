/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.eldatech.esalud.vo;

/**
 *
 * @author ddomi
 */
public class SignosVitalesVO {

    private String peso;
    private String talla;
    private String tensionArterial;
    private String frecuenciaCardiaca;
    private String saturacionOxigeno;
    private String glucosa;
    private String fum;
    private String temperatura;
    private String alergias;
    private String diagnostico;
    private Integer idPaciente;
    private String frecuenciaRespiratoria;
    private Integer idConsulta;

    /**
     * @return the peso
     */
    public String getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(String peso) {
        this.peso = peso;
    }

    /**
     * @return the talla
     */
    public String getTalla() {
        return talla;
    }

    /**
     * @param talla the talla to set
     */
    public void setTalla(String talla) {
        this.talla = talla;
    }

    /**
     * @return the tensionArterial
     */
    public String getTensionArterial() {
        return tensionArterial;
    }

    /**
     * @param tensionArterial the tensionArterial to set
     */
    public void setTensionArterial(String tensionArterial) {
        this.tensionArterial = tensionArterial;
    }

    /**
     * @return the frecuenciaCardiaca
     */
    public String getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    /**
     * @param frecuenciaCardiaca the frecuenciaCardiaca to set
     */
    public void setFrecuenciaCardiaca(String frecuenciaCardiaca) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
    }

    /**
     * @return the saturacionOxigeno
     */
    public String getSaturacionOxigeno() {
        return saturacionOxigeno;
    }

    /**
     * @param saturacionOxigeno the saturacionOxigeno to set
     */
    public void setSaturacionOxigeno(String saturacionOxigeno) {
        this.saturacionOxigeno = saturacionOxigeno;
    }

    /**
     * @return the glucosa
     */
    public String getGlucosa() {
        return glucosa;
    }

    /**
     * @param glucosa the glucosa to set
     */
    public void setGlucosa(String glucosa) {
        this.glucosa = glucosa;
    }

    /**
     * @return the fum
     */
    public String getFum() {
        return fum;
    }

    /**
     * @param fum the fum to set
     */
    public void setFum(String fum) {
        this.fum = fum;
    }

    /**
     * @return the temperatura
     */
    public String getTemperatura() {
        return temperatura;
    }

    /**
     * @param temperatura the temperatura to set
     */
    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    /**
     * @return the alergias
     */
    public String getAlergias() {
        return alergias;
    }

    /**
     * @param alergias the alergias to set
     */
    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    /**
     * @return the diagnostico
     */
    public String getDiagnostico() {
        return diagnostico;
    }

    /**
     * @param diagnostico the diagnostico to set
     */
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    /**
     * @return the idPaciente
     */
    public Integer getIdPaciente() {
        return idPaciente;
    }

    /**
     * @param idPaciente the idPaciente to set
     */
    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getFrecuenciaRespiratoria() {
        return frecuenciaRespiratoria;
    }

    public void setFrecuenciaRespiratoria(String frecuenciaRespiratoria) {
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
    }

    public Integer getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }
}
