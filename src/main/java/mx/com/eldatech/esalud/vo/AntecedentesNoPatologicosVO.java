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
@Table(name = "antecedentes_no_patologicos")
@NamedQueries({
    @NamedQuery(name = "AntecedentesNoPatologicosVO.findAll", query = "SELECT a FROM AntecedentesNoPatologicosVO a")})
public class AntecedentesNoPatologicosVO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_antecedente")
    private Integer idAntecedente;
    @Basic(optional = false)
    @Column(name = "actividad_fisica")
    private boolean actividadFisica;
    @Basic(optional = false)
    @Column(name = "tabaquismo")
    private boolean tabaquismo;
    @Basic(optional = false)
    @Column(name = "alcoholismo")
    private boolean alcoholismo;
    @Basic(optional = false)
    @Column(name = "dependencia_sustancias")
    private boolean dependenciaSustancias;
    @Basic(optional = false)
    @Column(name = "otros")
    private boolean otros;
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "id_historia", referencedColumnName = "id_historia")
    @ManyToOne(optional = false)
    private HistoriaClinicaVO idHistoria;

    public AntecedentesNoPatologicosVO() {
    }

    public AntecedentesNoPatologicosVO(Integer idAntecedente) {
        this.idAntecedente = idAntecedente;
    }

    public AntecedentesNoPatologicosVO(Integer idAntecedente, boolean actividadFisica, boolean tabaquismo, boolean alcoholismo, boolean dependenciaSustancias, boolean otros) {
        this.idAntecedente = idAntecedente;
        this.actividadFisica = actividadFisica;
        this.tabaquismo = tabaquismo;
        this.alcoholismo = alcoholismo;
        this.dependenciaSustancias = dependenciaSustancias;
        this.otros = otros;
    }

    public Integer getIdAntecedente() {
        return idAntecedente;
    }

    public void setIdAntecedente(Integer idAntecedente) {
        this.idAntecedente = idAntecedente;
    }

    public boolean getActividadFisica() {
        return actividadFisica;
    }

    public void setActividadFisica(boolean actividadFisica) {
        this.actividadFisica = actividadFisica;
    }

    public boolean getTabaquismo() {
        return tabaquismo;
    }

    public void setTabaquismo(boolean tabaquismo) {
        this.tabaquismo = tabaquismo;
    }

    public boolean getAlcoholismo() {
        return alcoholismo;
    }

    public void setAlcoholismo(boolean alcoholismo) {
        this.alcoholismo = alcoholismo;
    }

    public boolean getDependenciaSustancias() {
        return dependenciaSustancias;
    }

    public void setDependenciaSustancias(boolean dependenciaSustancias) {
        this.dependenciaSustancias = dependenciaSustancias;
    }

    public boolean getOtros() {
        return otros;
    }

    public void setOtros(boolean otros) {
        this.otros = otros;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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
        if (!(object instanceof AntecedentesNoPatologicosVO)) {
            return false;
        }
        AntecedentesNoPatologicosVO other = (AntecedentesNoPatologicosVO) object;
        if ((this.idAntecedente == null && other.idAntecedente != null) || (this.idAntecedente != null && !this.idAntecedente.equals(other.idAntecedente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.eldatech.esalud.vo.AntecedentesNoPatologicosVO[ idAntecedente=" + idAntecedente + " ]";
    }
    
}
