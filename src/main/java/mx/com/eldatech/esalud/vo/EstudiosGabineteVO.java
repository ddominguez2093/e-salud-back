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
@Table(name = "estudios_gabinete")
@NamedQueries({
    @NamedQuery(name = "EstudiosGabineteVO.findAll", query = "SELECT e FROM EstudiosGabineteVO e")})
public class EstudiosGabineteVO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estudio")
    private Integer idEstudio;
    @Column(name = "estudios")
    private String estudios;
    @JoinColumn(name = "id_historia", referencedColumnName = "id_historia")
    @ManyToOne(optional = false)
    private HistoriaClinicaVO idHistoria;

    public EstudiosGabineteVO() {
    }

    public EstudiosGabineteVO(Integer idEstudio) {
        this.idEstudio = idEstudio;
    }

    public Integer getIdEstudio() {
        return idEstudio;
    }

    public void setIdEstudio(Integer idEstudio) {
        this.idEstudio = idEstudio;
    }

    public String getEstudios() {
        return estudios;
    }

    public void setEstudios(String estudios) {
        this.estudios = estudios;
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
        hash += (idEstudio != null ? idEstudio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstudiosGabineteVO)) {
            return false;
        }
        EstudiosGabineteVO other = (EstudiosGabineteVO) object;
        if ((this.idEstudio == null && other.idEstudio != null) || (this.idEstudio != null && !this.idEstudio.equals(other.idEstudio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.eldatech.esalud.vo.EstudiosGabineteVO[ idEstudio=" + idEstudio + " ]";
    }
    
}
