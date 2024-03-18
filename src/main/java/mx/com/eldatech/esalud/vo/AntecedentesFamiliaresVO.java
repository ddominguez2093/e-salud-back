/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.eldatech.esalud.vo;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author ddomi
 */
@Entity
@Table(name = "antecedentes_familiares")
@NamedQueries({
    @NamedQuery(name = "AntecedentesFamiliaresVO.findAll", query = "SELECT a FROM AntecedentesFamiliaresVO a")})
public class AntecedentesFamiliaresVO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_antecedentes")
    private Integer idAntecedentes;
    @Basic(optional = false)
    @Column(name = "diabetes")
    private boolean diabetes;
    @Basic(optional = false)
    @Column(name = "enfermedades_corazon")
    private boolean enfermedadesCorazon;
    @Basic(optional = false)
    @Column(name = "hipertension")
    private boolean hipertension;
    @Basic(optional = false)
    @Column(name = "cancer")
    private boolean cancer;
    @Basic(optional = false)
    @Column(name = "otros")
    private boolean otros;
    @JoinColumn(name = "id_historia", referencedColumnName = "id_historia")
    @ManyToOne(optional = false)
    private HistoriaClinicaVO idHistoria;
    @Column(name = "observaciones_diabetes")
    private String observacionesDiabetes;
    @Column(name = "observaciones_corazon")
    private String observacionesCorazon;
    @Column(name = "observaciones_hipertencion")
    private String observacionesHipertencion;
    @Column(name = "observaciones_cancer")
    private String observacionesCancer;
    @Column(name = "observaciones_otros")
    private String observacionesOtros;

    public AntecedentesFamiliaresVO() {
    }

    public AntecedentesFamiliaresVO(Integer idAntecedentes) {
        this.idAntecedentes = idAntecedentes;
    }

    public AntecedentesFamiliaresVO(Integer idAntecedentes, boolean diabetes, boolean enfermedadesCorazon, boolean hipertension, boolean cancer, boolean otros) {
        this.idAntecedentes = idAntecedentes;
        this.diabetes = diabetes;
        this.enfermedadesCorazon = enfermedadesCorazon;
        this.hipertension = hipertension;
        this.cancer = cancer;
        this.otros = otros;
    }

    public Integer getIdAntecedentes() {
        return idAntecedentes;
    }

    public void setIdAntecedentes(Integer idAntecedentes) {
        this.idAntecedentes = idAntecedentes;
    }

    public boolean getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(boolean diabetes) {
        this.diabetes = diabetes;
    }

    public boolean getEnfermedadesCorazon() {
        return enfermedadesCorazon;
    }

    public void setEnfermedadesCorazon(boolean enfermedadesCorazon) {
        this.enfermedadesCorazon = enfermedadesCorazon;
    }

    public boolean getHipertension() {
        return hipertension;
    }

    public void setHipertension(boolean hipertension) {
        this.hipertension = hipertension;
    }

    public boolean getCancer() {
        return cancer;
    }

    public void setCancer(boolean cancer) {
        this.cancer = cancer;
    }

    public boolean getOtros() {
        return otros;
    }

    public void setOtros(boolean otros) {
        this.otros = otros;
    }

    public HistoriaClinicaVO getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(HistoriaClinicaVO idHistoria) {
        this.idHistoria = idHistoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAntecedentes != null ? idAntecedentes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AntecedentesFamiliaresVO)) {
            return false;
        }
        AntecedentesFamiliaresVO other = (AntecedentesFamiliaresVO) object;
        if ((this.idAntecedentes == null && other.idAntecedentes != null) || (this.idAntecedentes != null && !this.idAntecedentes.equals(other.idAntecedentes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.eldatech.esalud.vo.AntecedentesFamiliaresVO[ idAntecedentes=" + idAntecedentes + " ]";
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
    
}
