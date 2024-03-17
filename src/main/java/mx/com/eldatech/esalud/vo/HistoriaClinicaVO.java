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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHistoria")
    private List<AntecedentesNoPatologicosVO> antecedentesNoPatologicosVOList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHistoria")
    private List<AntecedentesPatologicosVO> antecedentesPatologicosVOList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHistoria")
    private List<AntecedentesFamiliaresVO> antecedentesFamiliaresVOList;
    @JoinColumn(name = "id_paciente", referencedColumnName = "id_paciente")
    @ManyToOne(optional = false)
    private PacienteVO idPaciente;

    public HistoriaClinicaVO() {
    }

    public HistoriaClinicaVO(Integer idHistoria) {
        this.idHistoria = idHistoria;
    }

    public Integer getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(Integer idHistoria) {
        this.idHistoria = idHistoria;
    }

    public List<AntecedentesNoPatologicosVO> getAntecedentesNoPatologicosVOList() {
        return antecedentesNoPatologicosVOList;
    }

    public void setAntecedentesNoPatologicosVOList(List<AntecedentesNoPatologicosVO> antecedentesNoPatologicosVOList) {
        this.antecedentesNoPatologicosVOList = antecedentesNoPatologicosVOList;
    }

    public List<AntecedentesPatologicosVO> getAntecedentesPatologicosVOList() {
        return antecedentesPatologicosVOList;
    }

    public void setAntecedentesPatologicosVOList(List<AntecedentesPatologicosVO> antecedentesPatologicosVOList) {
        this.antecedentesPatologicosVOList = antecedentesPatologicosVOList;
    }

    public List<AntecedentesFamiliaresVO> getAntecedentesFamiliaresVOList() {
        return antecedentesFamiliaresVOList;
    }

    public void setAntecedentesFamiliaresVOList(List<AntecedentesFamiliaresVO> antecedentesFamiliaresVOList) {
        this.antecedentesFamiliaresVOList = antecedentesFamiliaresVOList;
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
