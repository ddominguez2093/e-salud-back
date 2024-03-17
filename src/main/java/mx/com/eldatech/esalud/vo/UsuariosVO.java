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
@Table(name = "usuarios")
@NamedQueries({
    @NamedQuery(name = "UsuariosVO.findAll", query = "SELECT u FROM UsuariosVO u")})
public class UsuariosVO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @Column(name = "contrasena")
    private String contrasena;
    @Basic(optional = false)
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @JoinColumn(name = "id_medico", referencedColumnName = "id_medico")
    @ManyToOne(optional = false)
    private MedicosVO idMedico;
    @JoinColumn(name = "id_perfil", referencedColumnName = "id_perfil")
    @ManyToOne(optional = false)
    private PerfilesVO idPerfil;

    public UsuariosVO() {
    }

    public UsuariosVO(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public UsuariosVO(Integer idUsuario, String contrasena, String nombreUsuario) {
        this.idUsuario = idUsuario;
        this.contrasena = contrasena;
        this.nombreUsuario = nombreUsuario;
    }
    
    public UsuariosVO( String contrasena, String nombreUsuario) {        
        this.contrasena = contrasena;
        this.nombreUsuario = nombreUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public MedicosVO getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(MedicosVO idMedico) {
        this.idMedico = idMedico;
    }

    public PerfilesVO getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(PerfilesVO idPerfil) {
        this.idPerfil = idPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariosVO)) {
            return false;
        }
        UsuariosVO other = (UsuariosVO) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.eldatech.esalud.vo.UsuariosVO[ idUsuario=" + idUsuario + " ]";
    }
    
}
