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
@Table(name = "antecedentes_ginecoobstetricos")
@NamedQueries({
    @NamedQuery(name = "AntecedentesGinecoobstetricosVO.findAll", query = "SELECT a FROM AntecedentesGinecoobstetricosVO a")})
public class AntecedentesGinecoobstetricosVO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_antecedente")
    private Integer idAntecedente;
    @Column(name = "antecedentes")
    private String antecedentes;
    @JoinColumn(name = "id_historia", referencedColumnName = "id_historia")
    @ManyToOne(optional = false)
    private HistoriaClinicaVO idHistoria;

    public AntecedentesGinecoobstetricosVO() {
    }

    public AntecedentesGinecoobstetricosVO(Integer idAntecedente) {
        this.idAntecedente = idAntecedente;
    }

    public Integer getIdAntecedente() {
        return idAntecedente;
    }

    public void setIdAntecedente(Integer idAntecedente) {
        this.idAntecedente = idAntecedente;
    }

    public String getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(String antecedentes) {
        this.antecedentes = antecedentes;
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
        hash += (idAntecedente != null ? idAntecedente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AntecedentesGinecoobstetricosVO)) {
            return false;
        }
        AntecedentesGinecoobstetricosVO other = (AntecedentesGinecoobstetricosVO) object;
        if ((this.idAntecedente == null && other.idAntecedente != null) || (this.idAntecedente != null && !this.idAntecedente.equals(other.idAntecedente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.eldatech.esalud.vo.AntecedentesGinecoobstetricosVO[ idAntecedente=" + idAntecedente + " ]";
    }
    
}
