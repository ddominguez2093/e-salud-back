/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.eldatech.esalud.dto;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import mx.com.eldatech.esalud.vo.AntecedentesNoPatologicosVO;
import mx.com.eldatech.esalud.vo.HistoriaClinicaVO;

/**
 *
 * @author ddomi
 */
public class AntecedentesNoPatologicosDTO {

    private Integer idAntecedente;
    private boolean actividadFisica;
    private boolean tabaquismo;
    private boolean alcoholismo;
    private boolean dependenciaSustancias;
    private boolean otros;
    private String observacionesActividadFisica;
    private String observacionesTabaquismo;
    private String observacionesAlcoholismo;
    private String observacionesDependencia;
    private String observacionesOtros;
    private Integer idHistoria;
    
    public AntecedentesNoPatologicosDTO(AntecedentesNoPatologicosVO antecedentes) {
        this.idAntecedente = antecedentes.getIdAntecedente();
        this.actividadFisica = antecedentes.getActividadFisica();
        this.tabaquismo = antecedentes.getTabaquismo();
        this.alcoholismo = antecedentes.getAlcoholismo();
        this.dependenciaSustancias = antecedentes.getDependenciaSustancias();
        this.otros = antecedentes.getOtros();
        this.observacionesActividadFisica = antecedentes.getObservacionesActividadFisica();
        this.observacionesTabaquismo = antecedentes.getObservacionesTabaquismo();
        this.observacionesAlcoholismo = antecedentes.getObservacionesAlcoholismo();
        this.observacionesDependencia = antecedentes.getObservacionesDependencia();
        this.observacionesOtros = antecedentes.getObservacionesOtros();
        this.idHistoria = antecedentes.getIdHistoria().getIdHistoria();
    }

    public Integer getIdAntecedente() {
        return idAntecedente;
    }

    public void setIdAntecedente(Integer idAntecedente) {
        this.idAntecedente = idAntecedente;
    }

    public boolean isActividadFisica() {
        return actividadFisica;
    }

    public void setActividadFisica(boolean actividadFisica) {
        this.actividadFisica = actividadFisica;
    }

    public boolean isTabaquismo() {
        return tabaquismo;
    }

    public void setTabaquismo(boolean tabaquismo) {
        this.tabaquismo = tabaquismo;
    }

    public boolean isAlcoholismo() {
        return alcoholismo;
    }

    public void setAlcoholismo(boolean alcoholismo) {
        this.alcoholismo = alcoholismo;
    }

    public boolean isDependenciaSustancias() {
        return dependenciaSustancias;
    }

    public void setDependenciaSustancias(boolean dependenciaSustancias) {
        this.dependenciaSustancias = dependenciaSustancias;
    }

    public boolean isOtros() {
        return otros;
    }

    public void setOtros(boolean otros) {
        this.otros = otros;
    }

    public String getObservacionesActividadFisica() {
        return observacionesActividadFisica;
    }

    public void setObservacionesActividadFisica(String observacionesActividadFisica) {
        this.observacionesActividadFisica = observacionesActividadFisica;
    }

    public String getObservacionesTabaquismo() {
        return observacionesTabaquismo;
    }

    public void setObservacionesTabaquismo(String observacionesTabaquismo) {
        this.observacionesTabaquismo = observacionesTabaquismo;
    }

    public String getObservacionesAlcoholismo() {
        return observacionesAlcoholismo;
    }

    public void setObservacionesAlcoholismo(String observacionesAlcoholismo) {
        this.observacionesAlcoholismo = observacionesAlcoholismo;
    }

    public String getObservacionesDependencia() {
        return observacionesDependencia;
    }

    public void setObservacionesDependencia(String observacionesDependencia) {
        this.observacionesDependencia = observacionesDependencia;
    }

    public String getObservacionesOtros() {
        return observacionesOtros;
    }

    public void setObservacionesOtros(String observacionesOtros) {
        this.observacionesOtros = observacionesOtros;
    }

    public Integer getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(Integer idHistoria) {
        this.idHistoria = idHistoria;
    }

}
