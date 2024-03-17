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
@Table(name = "tratamiento")
@NamedQueries({
    @NamedQuery(name = "TratamientoVO.findAll", query = "SELECT t FROM TratamientoVO t")})
public class TratamientoVO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tratamiento")
    private Integer idTratamiento;
    @Basic(optional = false)
    @Column(name = "indicacion")
    private String indicacion;
    @Basic(optional = false)
    @Column(name = "medicamento")
    private String medicamento;
    @JoinColumn(name = "id_diagnostico", referencedColumnName = "id_diagnostico")
    @ManyToOne(optional = false)
    private DiagnosticoVO idDiagnostico;

    public TratamientoVO() {
    }

    public TratamientoVO(Integer idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public TratamientoVO(Integer idTratamiento, String indicacion, String medicamento) {
        this.idTratamiento = idTratamiento;
        this.indicacion = indicacion;
        this.medicamento = medicamento;
    }

    public Integer getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(Integer idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public String getIndicacion() {
        return indicacion;
    }

    public void setIndicacion(String indicacion) {
        this.indicacion = indicacion;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public DiagnosticoVO getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(DiagnosticoVO idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTratamiento != null ? idTratamiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TratamientoVO)) {
            return false;
        }
        TratamientoVO other = (TratamientoVO) object;
        if ((this.idTratamiento == null && other.idTratamiento != null) || (this.idTratamiento != null && !this.idTratamiento.equals(other.idTratamiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.eldatech.esalud.vo.TratamientoVO[ idTratamiento=" + idTratamiento + " ]";
    }
    
}
