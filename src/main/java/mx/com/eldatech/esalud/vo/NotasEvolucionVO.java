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
@Table(name = "notas_evolucion")
@NamedQueries({
    @NamedQuery(name = "NotasEvolucionVO.findAll", query = "SELECT n FROM NotasEvolucionVO n")})
public class NotasEvolucionVO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_nota")
    private Integer idNota;
    @Basic(optional = false)
    @Lob
    @Column(name = "nota")
    private String nota;
    @JoinColumn(name = "id_medico", referencedColumnName = "id_medico")
    @ManyToOne
    private MedicosVO idMedico;
    @JoinColumn(name = "id_paciente", referencedColumnName = "id_paciente")
    @ManyToOne(optional = false)
    private PacienteVO idPaciente;
    @Basic(optional = false)
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    public NotasEvolucionVO() {
    }

    public NotasEvolucionVO(Integer idNota) {
        this.idNota = idNota;
    }

    public NotasEvolucionVO(Integer idNota, String nota) {
        this.idNota = idNota;
        this.nota = nota;
    }

    public Integer getIdNota() {
        return idNota;
    }

    public void setIdNota(Integer idNota) {
        this.idNota = idNota;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public MedicosVO getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(MedicosVO idMedico) {
        this.idMedico = idMedico;
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
        hash += (idNota != null ? idNota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotasEvolucionVO)) {
            return false;
        }
        NotasEvolucionVO other = (NotasEvolucionVO) object;
        if ((this.idNota == null && other.idNota != null) || (this.idNota != null && !this.idNota.equals(other.idNota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.eldatech.esalud.vo.NotasEvolucionVO[ idNota=" + idNota + " ]";
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
}
