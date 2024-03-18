/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.eldatech.esalud.dto;

import mx.com.eldatech.esalud.vo.AntecedentesFamiliaresVO;

/**
 *
 * @author ddomi
 */
public class AntecedentesFamiliaresDTO {

    private Boolean diabetes;
    private Boolean enfermedadesCorazon;
    private Boolean hipertension;
    private Boolean cancer;
    private Boolean otros;
    private String observacionesDiabetes;
    private String observacionesCorazon;
    private String observacionesHipertencion;
    private String observacionesCancer;
    private String observacionesOtros;
    private Integer idAntecedente;
    private Integer idHistoria;
    
    public AntecedentesFamiliaresDTO(){}
    
    public AntecedentesFamiliaresDTO(AntecedentesFamiliaresVO antecedentesVO) {
        this.diabetes = antecedentesVO.getDiabetes();
        this.enfermedadesCorazon = antecedentesVO.getEnfermedadesCorazon();
        this.hipertension = antecedentesVO.getHipertension();
        this.cancer = antecedentesVO.getCancer();
        this.otros = antecedentesVO.getOtros();
        this.observacionesDiabetes = antecedentesVO.getObservacionesDiabetes();
        this.observacionesCorazon = antecedentesVO.getObservacionesCorazon();
        this.observacionesHipertencion = antecedentesVO.getObservacionesHipertencion();
        this.observacionesCancer = antecedentesVO.getObservacionesCancer();
        this.observacionesOtros = antecedentesVO.getObservacionesOtros();
        this.idAntecedente = antecedentesVO.getIdAntecedentes();
        this.idHistoria = antecedentesVO.getIdHistoria().getIdHistoria();
    }

    public Boolean getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(Boolean diabetes) {
        this.diabetes = diabetes;
    }

    public Boolean getEnfermedadesCorazon() {
        return enfermedadesCorazon;
    }

    public void setEnfermedadesCorazon(Boolean enfermedadesCorazon) {
        this.enfermedadesCorazon = enfermedadesCorazon;
    }

    public Boolean getHipertension() {
        return hipertension;
    }

    public void setHipertension(Boolean hipertension) {
        this.hipertension = hipertension;
    }

    public Boolean getCancer() {
        return cancer;
    }

    public void setCancer(Boolean cancer) {
        this.cancer = cancer;
    }

    public Boolean getOtros() {
        return otros;
    }

    public void setOtros(Boolean otros) {
        this.otros = otros;
    }

    public String getObservacionesDiabetes() {
        return observacionesDiabetes;
    }

    public void setObservacionesDiabetes(String observacionesDiabetes) {
        this.observacionesDiabetes = observacionesDiabetes;
    }

    public String getObservacionesCorazon() {
        return observacionesCorazon;
    }

    public void setObservacionesCorazon(String observacionesCorazon) {
        this.observacionesCorazon = observacionesCorazon;
    }

    public String getObservacionesHipertencion() {
        return observacionesHipertencion;
    }

    public void setObservacionesHipertencion(String observacionesHipertencion) {
        this.observacionesHipertencion = observacionesHipertencion;
    }

    public String getObservacionesCancer() {
        return observacionesCancer;
    }

    public void setObservacionesCancer(String observacionesCancer) {
        this.observacionesCancer = observacionesCancer;
    }

    public String getObservacionesOtros() {
        return observacionesOtros;
    }

    public void setObservacionesOtros(String observacionesOtros) {
        this.observacionesOtros = observacionesOtros;
    }

    public Integer getIdAntecedente() {
        return idAntecedente;
    }

    public void setIdAntecedente(Integer idAntecedente) {
        this.idAntecedente = idAntecedente;
    }

    public Integer getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(Integer idHistoria) {
        this.idHistoria = idHistoria;
    }

}
