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
@Table(name = "antecedentes_patologicos")
@NamedQueries({
    @NamedQuery(name = "AntecedentesPatologicosVO.findAll", query = "SELECT a FROM AntecedentesPatologicosVO a")})
public class AntecedentesPatologicosVO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_antecedente")
    private Integer idAntecedente;
    @Basic(optional = false)
    @Column(name = "hospitalizaciones")
    private boolean hospitalizaciones;
    @Basic(optional = false)
    @Column(name = "cirugias")
    private boolean cirugias;
    @Basic(optional = false)
    @Column(name = "diabetes")
    private boolean diabetes;
    @Basic(optional = false)
    @Column(name = "hipertension")
    private boolean hipertension;
    @Basic(optional = false)
    @Column(name = "enfermedades_corazon")
    private boolean enfermedadesCorazon;
    @Basic(optional = false)
    @Column(name = "cancer")
    private boolean cancer;
    @Basic(optional = false)
    @Column(name = "tuberculosis")
    private boolean tuberculosis;
    @Basic(optional = false)
    @Column(name = "ets")
    private boolean ets;
    @Basic(optional = false)
    @Column(name = "patologias_resp")
    private boolean patologiasResp;
    @JoinColumn(name = "id_historia", referencedColumnName = "id_historia")
    @ManyToOne(optional = false)
    private HistoriaClinicaVO idHistoria;

    public AntecedentesPatologicosVO() {
    }

    public AntecedentesPatologicosVO(Integer idAntecedente) {
        this.idAntecedente = idAntecedente;
    }

    public AntecedentesPatologicosVO(Integer idAntecedente, boolean hospitalizaciones, boolean cirugias, boolean diabetes, boolean hipertension, boolean enfermedadesCorazon, boolean cancer, boolean tuberculosis, boolean ets, boolean patologiasResp) {
        this.idAntecedente = idAntecedente;
        this.hospitalizaciones = hospitalizaciones;
        this.cirugias = cirugias;
        this.diabetes = diabetes;
        this.hipertension = hipertension;
        this.enfermedadesCorazon = enfermedadesCorazon;
        this.cancer = cancer;
        this.tuberculosis = tuberculosis;
        this.ets = ets;
        this.patologiasResp = patologiasResp;
    }

    public Integer getIdAntecedente() {
        return idAntecedente;
    }

    public void setIdAntecedente(Integer idAntecedente) {
        this.idAntecedente = idAntecedente;
    }

    public boolean getHospitalizaciones() {
        return hospitalizaciones;
    }

    public void setHospitalizaciones(boolean hospitalizaciones) {
        this.hospitalizaciones = hospitalizaciones;
    }

    public boolean getCirugias() {
        return cirugias;
    }

    public void setCirugias(boolean cirugias) {
        this.cirugias = cirugias;
    }

    public boolean getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(boolean diabetes) {
        this.diabetes = diabetes;
    }

    public boolean getHipertension() {
        return hipertension;
    }

    public void setHipertension(boolean hipertension) {
        this.hipertension = hipertension;
    }

    public boolean getEnfermedadesCorazon() {
        return enfermedadesCorazon;
    }

    public void setEnfermedadesCorazon(boolean enfermedadesCorazon) {
        this.enfermedadesCorazon = enfermedadesCorazon;
    }

    public boolean getCancer() {
        return cancer;
    }

    public void setCancer(boolean cancer) {
        this.cancer = cancer;
    }

    public boolean getTuberculosis() {
        return tuberculosis;
    }

    public void setTuberculosis(boolean tuberculosis) {
        this.tuberculosis = tuberculosis;
    }

    public boolean getEts() {
        return ets;
    }

    public void setEts(boolean ets) {
        this.ets = ets;
    }

    public boolean getPatologiasResp() {
        return patologiasResp;
    }

    public void setPatologiasResp(boolean patologiasResp) {
        this.patologiasResp = patologiasResp;
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
        hash += (idAntecedente != null ? idAntecedente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AntecedentesPatologicosVO)) {
            return false;
        }
        AntecedentesPatologicosVO other = (AntecedentesPatologicosVO) object;
        if ((this.idAntecedente == null && other.idAntecedente != null) || (this.idAntecedente != null && !this.idAntecedente.equals(other.idAntecedente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.eldatech.esalud.vo.AntecedentesPatologicosVO[ idAntecedente=" + idAntecedente + " ]";
    }
    
}
