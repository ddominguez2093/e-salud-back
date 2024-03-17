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
@Table(name = "medicos")
@NamedQueries({
    @NamedQuery(name = "MedicosVO.findAll", query = "SELECT m FROM MedicosVO m")})
public class MedicosVO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_medico")
    private Integer idMedico;
    @Basic(optional = false)
    @Column(name = "alma_mater")
    private String almaMater;
    @Basic(optional = false)
    @Column(name = "cedula_profesional")
    private String cedulaProfesional;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @Column(name = "especialidad")
    private String especialidad;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "horario")
    private String horario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMedico")
    private List<PacienteVO> pacienteVOList;

    public MedicosVO() {
    }

    public MedicosVO(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public MedicosVO(Integer idMedico, String almaMater, String cedulaProfesional, String correo, String especialidad, String nombre, String horario) {
        this.idMedico = idMedico;
        this.almaMater = almaMater;
        this.cedulaProfesional = cedulaProfesional;
        this.correo = correo;
        this.especialidad = especialidad;
        this.nombre = nombre;
        this.horario = horario;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public String getAlmaMater() {
        return almaMater;
    }

    public void setAlmaMater(String almaMater) {
        this.almaMater = almaMater;
    }

    public String getCedulaProfesional() {
        return cedulaProfesional;
    }

    public void setCedulaProfesional(String cedulaProfesional) {
        this.cedulaProfesional = cedulaProfesional;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public List<PacienteVO> getPacienteVOList() {
        return pacienteVOList;
    }

    public void setPacienteVOList(List<PacienteVO> pacienteVOList) {
        this.pacienteVOList = pacienteVOList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedico != null ? idMedico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedicosVO)) {
            return false;
        }
        MedicosVO other = (MedicosVO) object;
        if ((this.idMedico == null && other.idMedico != null) || (this.idMedico != null && !this.idMedico.equals(other.idMedico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.eldatech.esalud.vo.MedicosVO[ idMedico=" + idMedico + " ]";
    }
    
}
