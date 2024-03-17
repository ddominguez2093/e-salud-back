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
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author ddomi
 */
@Entity
@Table(name = "historia_clinica")
@NamedQueries({
    @NamedQuery(name = "HistoriaClinicaVO.findAll", query = "SELECT h FROM HistoriaClinicaVO h")})
public class HistoriaClinicaVO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_historia")
    private Integer idHistoria;
    @Basic(optional = false)
    @Column(name = "id_antecedentes")
    private int idAntecedentes;
    @Basic(optional = false)
    @Column(name = "id_datos_identificacion")
    private int idDatosIdentificacion;
    @Basic(optional = false)
    @Column(name = "id_interrogatorio")
    private int idInterrogatorio;
    @Basic(optional = false)
    @Column(name = "clave_historia")
    private String claveHistoria;

    public HistoriaClinicaVO() {
    }

    public HistoriaClinicaVO(Integer idHistoria) {
        this.idHistoria = idHistoria;
    }

    public HistoriaClinicaVO(Integer idHistoria, int idAntecedentes, int idDatosIdentificacion, int idInterrogatorio, String claveHistoria) {
        this.idHistoria = idHistoria;
        this.idAntecedentes = idAntecedentes;
        this.idDatosIdentificacion = idDatosIdentificacion;
        this.idInterrogatorio = idInterrogatorio;
        this.claveHistoria = claveHistoria;
    }

    public Integer getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(Integer idHistoria) {
        this.idHistoria = idHistoria;
    }

    public int getIdAntecedentes() {
        return idAntecedentes;
    }

    public void setIdAntecedentes(int idAntecedentes) {
        this.idAntecedentes = idAntecedentes;
    }

    public int getIdDatosIdentificacion() {
        return idDatosIdentificacion;
    }

    public void setIdDatosIdentificacion(int idDatosIdentificacion) {
        this.idDatosIdentificacion = idDatosIdentificacion;
    }

    public int getIdInterrogatorio() {
        return idInterrogatorio;
    }

    public void setIdInterrogatorio(int idInterrogatorio) {
        this.idInterrogatorio = idInterrogatorio;
    }

    public String getClaveHistoria() {
        return claveHistoria;
    }

    public void setClaveHistoria(String claveHistoria) {
        this.claveHistoria = claveHistoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHistoria != null ? idHistoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoriaClinicaVO)) {
            return false;
        }
        HistoriaClinicaVO other = (HistoriaClinicaVO) object;
        if ((this.idHistoria == null && other.idHistoria != null) || (this.idHistoria != null && !this.idHistoria.equals(other.idHistoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.eldatech.esalud.vo.HistoriaClinicaVO[ idHistoria=" + idHistoria + " ]";
    }
    
}
