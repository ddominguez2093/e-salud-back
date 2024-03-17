/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.eldatech.esalud.vo;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "estudios_laboratorio")
@NamedQueries({
    @NamedQuery(name = "EstudiosLaboratorioVO.findAll", query = "SELECT e FROM EstudiosLaboratorioVO e")})
public class EstudiosLaboratorioVO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_estudio")
    private Integer idEstudio;
    @Basic(optional = false)
    @Column(name = "id_historia")
    private int idHistoria;
    @Basic(optional = false)
    @Column(name = "fecha_estudio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEstudio;
    @Basic(optional = false)
    @Column(name = "estudio")
    private String estudio;

    public EstudiosLaboratorioVO() {
    }

    public EstudiosLaboratorioVO(Integer idEstudio) {
        this.idEstudio = idEstudio;
    }

    public EstudiosLaboratorioVO(Integer idEstudio, int idHistoria, Date fechaEstudio, String estudio) {
        this.idEstudio = idEstudio;
        this.idHistoria = idHistoria;
        this.fechaEstudio = fechaEstudio;
        this.estudio = estudio;
    }

    public Integer getIdEstudio() {
        return idEstudio;
    }

    public void setIdEstudio(Integer idEstudio) {
        this.idEstudio = idEstudio;
    }

    public int getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(int idHistoria) {
        this.idHistoria = idHistoria;
    }

    public Date getFechaEstudio() {
        return fechaEstudio;
    }

    public void setFechaEstudio(Date fechaEstudio) {
        this.fechaEstudio = fechaEstudio;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstudio != null ? idEstudio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstudiosLaboratorioVO)) {
            return false;
        }
        EstudiosLaboratorioVO other = (EstudiosLaboratorioVO) object;
        if ((this.idEstudio == null && other.idEstudio != null) || (this.idEstudio != null && !this.idEstudio.equals(other.idEstudio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.eldatech.esalud.vo.EstudiosLaboratorioVO[ idEstudio=" + idEstudio + " ]";
    }
    
}
