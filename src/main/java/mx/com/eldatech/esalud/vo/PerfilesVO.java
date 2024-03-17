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
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ddomi
 */
@Entity
@Table(name = "perfiles")
@NamedQueries({
    @NamedQuery(name = "PerfilesVO.findAll", query = "SELECT p FROM PerfilesVO p")})
public class PerfilesVO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_perfil")
    private Integer idPerfil;
    @Basic(optional = false)
    @Column(name = "perfil")
    private String perfil;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPerfil")
    private List<UsuariosVO> usuariosVOList;

    public PerfilesVO() {
    }

    public PerfilesVO(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public PerfilesVO(Integer idPerfil, String perfil) {
        this.idPerfil = idPerfil;
        this.perfil = perfil;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public List<UsuariosVO> getUsuariosVOList() {
        return usuariosVOList;
    }

    public void setUsuariosVOList(List<UsuariosVO> usuariosVOList) {
        this.usuariosVOList = usuariosVOList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerfil != null ? idPerfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilesVO)) {
            return false;
        }
        PerfilesVO other = (PerfilesVO) object;
        if ((this.idPerfil == null && other.idPerfil != null) || (this.idPerfil != null && !this.idPerfil.equals(other.idPerfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.eldatech.esalud.vo.PerfilesVO[ idPerfil=" + idPerfil + " ]";
    }
    
}
