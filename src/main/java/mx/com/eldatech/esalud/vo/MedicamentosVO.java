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
import jakarta.persistence.Lob;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author ddomi
 */
@Entity
@Table(name = "medicamentos")
@NamedQueries({
    @NamedQuery(name = "MedicamentosVO.findAll", query = "SELECT m FROM MedicamentosVO m")})
public class MedicamentosVO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "sustancia")
    private String sustancia;
    @Basic(optional = false)
    @Lob
    @Column(name = "forma_farmaceutica")
    private String formaFarmaceutica;
    @Basic(optional = false)
    @Column(name = "presentacion")
    private String presentacion;

    public MedicamentosVO() {
    }

    public MedicamentosVO(Integer id) {
        this.id = id;
    }

    public MedicamentosVO(Integer id, String sustancia, String formaFarmaceutica, String presentacion) {
        this.id = id;
        this.sustancia = sustancia;
        this.formaFarmaceutica = formaFarmaceutica;
        this.presentacion = presentacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSustancia() {
        return sustancia;
    }

    public void setSustancia(String sustancia) {
        this.sustancia = sustancia;
    }

    public String getFormaFarmaceutica() {
        return formaFarmaceutica;
    }

    public void setFormaFarmaceutica(String formaFarmaceutica) {
        this.formaFarmaceutica = formaFarmaceutica;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedicamentosVO)) {
            return false;
        }
        MedicamentosVO other = (MedicamentosVO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.eldatech.esalud.vo.MedicamentosVO[ id=" + id + " ]";
    }
    
}
