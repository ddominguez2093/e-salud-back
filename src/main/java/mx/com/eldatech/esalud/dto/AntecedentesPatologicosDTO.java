/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.eldatech.esalud.dto;

import mx.com.eldatech.esalud.vo.AntecedentesPatologicosVO;

/**
 *
 * @author ddomi
 */
public class AntecedentesPatologicosDTO {

    private Integer idAntecedente;
    private boolean hospitalizaciones;
    private boolean cirugias;
    private boolean diabetes;
    private boolean hipertension;
    private boolean enfermedadesCorazon;
    private boolean cancer;
    private boolean tuberculosis;
    private boolean ets;
    private boolean patologiasResp;
    private Integer idHistoria;
    private String obsHospitalizaciones;
    private String obsCirugias;
    private String obsDiabetes;
    private String obsHipertension;
    private String obsEnfCorazon;
    private String obsCancer;
    private String obsTuberculosis;
    private String obsEts;
    private String obsPatResp;
    
    public AntecedentesPatologicosDTO(AntecedentesPatologicosVO antecedentesVO) {
        this.idAntecedente = antecedentesVO.getIdAntecedente();
        this.hospitalizaciones = antecedentesVO.getHospitalizaciones();
        this.cirugias = antecedentesVO.getCirugias();
        this.diabetes = antecedentesVO.getDiabetes();
        this.hipertension = antecedentesVO.getHipertension();
        this.enfermedadesCorazon = antecedentesVO.getEnfermedadesCorazon();
        this.cancer = antecedentesVO.getCancer();
        this.tuberculosis = antecedentesVO.getTuberculosis();
        this.ets = antecedentesVO.getEts();
        this.patologiasResp = antecedentesVO.getPatologiasResp();
        this.idHistoria = antecedentesVO.getIdHistoria().getIdHistoria();
        this.obsHospitalizaciones = antecedentesVO.getObsHospitalizaciones();
        this.obsCirugias = antecedentesVO.getObsCirugias();
        this.obsDiabetes = antecedentesVO.getObsDiabetes();
        this.obsHipertension = antecedentesVO.getObsHipertension();
        this.obsEnfCorazon = antecedentesVO.getObsEnfCorazon();
        this.obsCancer = antecedentesVO.getObsCancer();
        this.obsTuberculosis = antecedentesVO.getObsTuberculosis();
        this.obsEts = antecedentesVO.getObsEts();
        this.obsPatResp = antecedentesVO.getObsPatResp();
    }

    public Integer getIdAntecedente() {
        return idAntecedente;
    }

    public void setIdAntecedente(Integer idAntecedente) {
        this.idAntecedente = idAntecedente;
    }

    public boolean isHospitalizaciones() {
        return hospitalizaciones;
    }

    public void setHospitalizaciones(boolean hospitalizaciones) {
        this.hospitalizaciones = hospitalizaciones;
    }

    public boolean isCirugias() {
        return cirugias;
    }

    public void setCirugias(boolean cirugias) {
        this.cirugias = cirugias;
    }

    public boolean isDiabetes() {
        return diabetes;
    }

    public void setDiabetes(boolean diabetes) {
        this.diabetes = diabetes;
    }

    public boolean isHipertension() {
        return hipertension;
    }

    public void setHipertension(boolean hipertension) {
        this.hipertension = hipertension;
    }

    public boolean isEnfermedadesCorazon() {
        return enfermedadesCorazon;
    }

    public void setEnfermedadesCorazon(boolean enfermedadesCorazon) {
        this.enfermedadesCorazon = enfermedadesCorazon;
    }

    public boolean isCancer() {
        return cancer;
    }

    public void setCancer(boolean cancer) {
        this.cancer = cancer;
    }

    public boolean isTuberculosis() {
        return tuberculosis;
    }

    public void setTuberculosis(boolean tuberculosis) {
        this.tuberculosis = tuberculosis;
    }

    public boolean isEts() {
        return ets;
    }

    public void setEts(boolean ets) {
        this.ets = ets;
    }

    public boolean isPatologiasResp() {
        return patologiasResp;
    }

    public void setPatologiasResp(boolean patologiasResp) {
        this.patologiasResp = patologiasResp;
    }

    public Integer getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(Integer idHistoria) {
        this.idHistoria = idHistoria;
    }

    public String getObsHospitalizaciones() {
        return obsHospitalizaciones;
    }

    public void setObsHospitalizaciones(String obsHospitalizaciones) {
        this.obsHospitalizaciones = obsHospitalizaciones;
    }

    public String getObsCirugias() {
        return obsCirugias;
    }

    public void setObsCirugias(String obsCirugias) {
        this.obsCirugias = obsCirugias;
    }

    public String getObsDiabetes() {
        return obsDiabetes;
    }

    public void setObsDiabetes(String obsDiabetes) {
        this.obsDiabetes = obsDiabetes;
    }

    public String getObsHipertension() {
        return obsHipertension;
    }

    public void setObsHipertension(String obsHipertension) {
        this.obsHipertension = obsHipertension;
    }

    public String getObsEnfCorazon() {
        return obsEnfCorazon;
    }

    public void setObsEnfCorazon(String obsEnfCorazon) {
        this.obsEnfCorazon = obsEnfCorazon;
    }

    public String getObsCancer() {
        return obsCancer;
    }

    public void setObsCancer(String obsCancer) {
        this.obsCancer = obsCancer;
    }

    public String getObsTuberculosis() {
        return obsTuberculosis;
    }

    public void setObsTuberculosis(String obsTuberculosis) {
        this.obsTuberculosis = obsTuberculosis;
    }

    public String getObsEts() {
        return obsEts;
    }

    public void setObsEts(String obsEts) {
        this.obsEts = obsEts;
    }

    public String getObsPatResp() {
        return obsPatResp;
    }

    public void setObsPatResp(String obsPatResp) {
        this.obsPatResp = obsPatResp;
    }
}
