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
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author ddomi
 */
@Entity
@Table(name = "recetas")
@NamedQueries({
    @NamedQuery(name = "RecetasVO.findAll", query = "SELECT r FROM RecetasVO r")})
public class RecetasVO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_receta")
    private Integer idReceta;
    @Basic(optional = false)
    @Lob
    @Column(name = "receta")
    private String receta;
    @Basic(optional = false)
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @JoinColumn(name = "id_consulta", referencedColumnName = "id_consulta")
    @ManyToOne(optional = false)
    private ConsultasVO idConsulta;
    @JoinColumn(name = "id_paciente", referencedColumnName = "id_paciente")
    @ManyToOne(optional = false)
    private PacienteVO idPaciente;

    public RecetasVO() {
    }

    public RecetasVO(Integer idReceta) {
        this.idReceta = idReceta;
    }

    public RecetasVO(Integer idReceta, String receta, Date fechaCreacion) {
        this.idReceta = idReceta;
        this.receta = receta;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(Integer idReceta) {
        this.idReceta = idReceta;
    }

    public String getReceta() {
        return receta;
    }

    public void setReceta(String receta) {
        this.receta = receta;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public ConsultasVO getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(ConsultasVO idConsulta) {
        this.idConsulta = idConsulta;
    }

    public PacienteVO getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(PacienteVO idPaciente) {
        this.idPaciente = idPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReceta != null ? idReceta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecetasVO)) {
            return false;
        }
        RecetasVO other = (RecetasVO) object;
        if ((this.idReceta == null && other.idReceta != null) || (this.idReceta != null && !this.idReceta.equals(other.idReceta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.eldatech.esalud.vo.RecetasVO[ idReceta=" + idReceta + " ]";
    }
    
}
