/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.eldatech.esalud.dto;

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
    private String obsDiabetes;
    private String obsCorazon;
    private String obsHipertension;
    private String obsCancer;
    private String obsOtros;
    private Integer idAntecedente;
    private Integer idHistoria;

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

    public String getObsDiabetes() {
        return obsDiabetes;
    }

    public void setObsDiabetes(String obsDiabetes) {
        this.obsDiabetes = obsDiabetes;
    }

    public String getObsCorazon() {
        return obsCorazon;
    }

    public void setObsCorazon(String obsCorazon) {
        this.obsCorazon = obsCorazon;
    }

    public String getObsHipertension() {
        return obsHipertension;
    }

    public void setObsHipertension(String obsHipertension) {
        this.obsHipertension = obsHipertension;
    }

    public String getObsCancer() {
        return obsCancer;
    }

    public void setObsCancer(String obsCancer) {
        this.obsCancer = obsCancer;
    }

    public String getObsOtros() {
        return obsOtros;
    }

    public void setObsOtros(String obsOtros) {
        this.obsOtros = obsOtros;
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
