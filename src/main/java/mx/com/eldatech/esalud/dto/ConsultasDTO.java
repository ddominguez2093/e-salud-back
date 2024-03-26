/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.eldatech.esalud.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mx.com.eldatech.esalud.vo.ConsultasVO;

/**
 *
 * @author ddomi
 */
public class ConsultasDTO {

    private Integer idConsulta;
    private String peso;
    private String talla;
    private String alergias;
    private String diagnostico;
    private String frecuenciaCardiaca;
    private String fum;
    private String glucosa;
    private String saturacionOxigeno;
    private String temperatura;
    private String tensionArterial;
    private String frecuenciaRespiratoria;
    private Integer idPaciente;
    private Date fechaConsulta;
    
    public ConsultasDTO(){}
    
    public ConsultasDTO(ConsultasVO consulta) {
        this.idConsulta = consulta.getIdConsulta();
        this.peso = consulta.getPeso();
        this.talla = consulta.getTalla();
        this.alergias = consulta.getAlergias();
        this.diagnostico = consulta.getDiagnostico();
        this.frecuenciaCardiaca = consulta.getFrecuenciaCardiaca();
        this.fum = consulta.getFum();
        this.glucosa = consulta.getGlucosa();
        this.saturacionOxigeno = consulta.getSaturacionOxigeno();
        this.temperatura = consulta.getTemperatura();
        this.tensionArterial = consulta.getTensionArterial();
        this.frecuenciaRespiratoria = consulta.getFrecuenciaRespiratoria();
        this.idPaciente = consulta.getIdPaciente().getIdPaciente();
        this.fechaConsulta = consulta.getFechaConsulta();
    }
    
    public static List<ConsultasDTO> getDTOListFromVOList(List<ConsultasVO> listaConsultas) {
        List<ConsultasDTO> listaConsultasDTO = new ArrayList<>();
        for(ConsultasVO consultaVO: listaConsultas) {
            listaConsultasDTO.add(new ConsultasDTO(consultaVO));
        }
        return listaConsultasDTO;
    }

    /**
     * @return the idConsulta
     */
    public Integer getIdConsulta() {
        return idConsulta;
    }

    /**
     * @param idConsulta the idConsulta to set
     */
    public void setIdConsulta(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }

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
     * @return the frecuenciaRespiratoria
     */
    public String getFrecuenciaRespiratoria() {
        return frecuenciaRespiratoria;
    }

    /**
     * @param frecuenciaRespiratoria the frecuenciaRespiratoria to set
     */
    public void setFrecuenciaRespiratoria(String frecuenciaRespiratoria) {
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
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

    /**
     * @return the fechaConsulta
     */
    public Date getFechaConsulta() {
        return fechaConsulta;
    }

    /**
     * @param fechaConsulta the fechaConsulta to set
     */
    public void setFechaConsulta(Date fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

}
