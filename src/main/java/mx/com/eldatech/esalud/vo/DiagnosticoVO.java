/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.eldatech.esalud.vo;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ddomi
 */
@Entity
@Table(name = "diagnostico")
@NamedQueries({
    @NamedQuery(name = "DiagnosticoVO.findAll", query = "SELECT d FROM DiagnosticoVO d")})
public class DiagnosticoVO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_diagnostico")
    private Integer idDiagnostico;
    @Basic(optional = false)
    @Column(name = "id_historia")
    private int idHistoria;
    @Basic(optional = false)
    @Column(name = "fecha_diagnostico")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDiagnostico;
    @Basic(optional = false)
    @Column(name = "diagnostico")
    private String diagnostico;
    @Basic(optional = false)
    @Column(name = "observaciones")
    private String observaciones;
    @Basic(optional = false)
    @Column(name = "pronostico")
    private String pronostico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDiagnostico")
    private List<TratamientoVO> tratamientoVOList;

    public DiagnosticoVO() {
    }

    public DiagnosticoVO(Integer idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public DiagnosticoVO(Integer idDiagnostico, int idHistoria, Date fechaDiagnostico, String diagnostico, String observaciones, String pronostico) {
        this.idDiagnostico = idDiagnostico;
        this.idHistoria = idHistoria;
        this.fechaDiagnostico = fechaDiagnostico;
        this.diagnostico = diagnostico;
        this.observaciones = observaciones;
        this.pronostico = pronostico;
    }

    public Integer getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(Integer idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public int getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(int idHistoria) {
        this.idHistoria = idHistoria;
    }

    public Date getFechaDiagnostico() {
        return fechaDiagnostico;
    }

    public void setFechaDiagnostico(Date fechaDiagnostico) {
        this.fechaDiagnostico = fechaDiagnostico;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getPronostico() {
        return pronostico;
    }

    public void setPronostico(String pronostico) {
        this.pronostico = pronostico;
    }

    public List<TratamientoVO> getTratamientoVOList() {
        return tratamientoVOList;
    }

    public void setTratamientoVOList(List<TratamientoVO> tratamientoVOList) {
        this.tratamientoVOList = tratamientoVOList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDiagnostico != null ? idDiagnostico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiagnosticoVO)) {
            return false;
        }
        DiagnosticoVO other = (DiagnosticoVO) object;
        if ((this.idDiagnostico == null && other.idDiagnostico != null) || (this.idDiagnostico != null && !this.idDiagnostico.equals(other.idDiagnostico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.eldatech.esalud.vo.DiagnosticoVO[ idDiagnostico=" + idDiagnostico + " ]";
    }
    
}
