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
@Table(name = "interrogatorio_sistemas")
@NamedQueries({
    @NamedQuery(name = "InterrogatorioSistemasVO.findAll", query = "SELECT i FROM InterrogatorioSistemasVO i")})
public class InterrogatorioSistemasVO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_interrogatorio")
    private Integer idInterrogatorio;
    @Column(name = "aparato_resp")
    private String aparatoResp;
    @Column(name = "aparato_dig")
    private String aparatoDig;
    @Column(name = "aparato_cardio")
    private String aparatoCardio;
    @Column(name = "aparato_renal")
    private String aparatoRenal;
    @Column(name = "aparato_genital")
    private String aparatoGenital;
    @Column(name = "sistema_endocrino")
    private String sistemaEndocrino;
    @Column(name = "sistema_hemato_linfatico")
    private String sistemaHematoLinfatico;
    @Column(name = "piel_anexos")
    private String pielAnexos;
    @Column(name = "musculo_esqueletico")
    private String musculoEsqueletico;
    @Column(name = "sistema_nervioso")
    private String sistemaNervioso;
    @JoinColumn(name = "id_historia", referencedColumnName = "id_historia")
    @ManyToOne(optional = false)
    private HistoriaClinicaVO idHistoria;

    public InterrogatorioSistemasVO() {
    }

    public InterrogatorioSistemasVO(Integer idInterrogatorio) {
        this.idInterrogatorio = idInterrogatorio;
    }

    public Integer getIdInterrogatorio() {
        return idInterrogatorio;
    }

    public void setIdInterrogatorio(Integer idInterrogatorio) {
        this.idInterrogatorio = idInterrogatorio;
    }

    public String getAparatoResp() {
        return aparatoResp;
    }

    public void setAparatoResp(String aparatoResp) {
        this.aparatoResp = aparatoResp;
    }

    public String getAparatoDig() {
        return aparatoDig;
    }

    public void setAparatoDig(String aparatoDig) {
        this.aparatoDig = aparatoDig;
    }

    public String getAparatoCardio() {
        return aparatoCardio;
    }

    public void setAparatoCardio(String aparatoCardio) {
        this.aparatoCardio = aparatoCardio;
    }

    public String getAparatoRenal() {
        return aparatoRenal;
    }

    public void setAparatoRenal(String aparatoRenal) {
        this.aparatoRenal = aparatoRenal;
    }

    public String getAparatoGenital() {
        return aparatoGenital;
    }

    public void setAparatoGenital(String aparatoGenital) {
        this.aparatoGenital = aparatoGenital;
    }

    public String getSistemaEndocrino() {
        return sistemaEndocrino;
    }

    public void setSistemaEndocrino(String sistemaEndocrino) {
        this.sistemaEndocrino = sistemaEndocrino;
    }

    public String getSistemaHematoLinfatico() {
        return sistemaHematoLinfatico;
    }

    public void setSistemaHematoLinfatico(String sistemaHematoLinfatico) {
        this.sistemaHematoLinfatico = sistemaHematoLinfatico;
    }

    public String getPielAnexos() {
        return pielAnexos;
    }

    public void setPielAnexos(String pielAnexos) {
        this.pielAnexos = pielAnexos;
    }

    public String getMusculoEsqueletico() {
        return musculoEsqueletico;
    }

    public void setMusculoEsqueletico(String musculoEsqueletico) {
        this.musculoEsqueletico = musculoEsqueletico;
    }

    public String getSistemaNervioso() {
        return sistemaNervioso;
    }

    public void setSistemaNervioso(String sistemaNervioso) {
        this.sistemaNervioso = sistemaNervioso;
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
        hash += (idInterrogatorio != null ? idInterrogatorio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InterrogatorioSistemasVO)) {
            return false;
        }
        InterrogatorioSistemasVO other = (InterrogatorioSistemasVO) object;
        if ((this.idInterrogatorio == null && other.idInterrogatorio != null) || (this.idInterrogatorio != null && !this.idInterrogatorio.equals(other.idInterrogatorio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.eldatech.esalud.vo.InterrogatorioSistemasVO[ idInterrogatorio=" + idInterrogatorio + " ]";
    }
    
}
