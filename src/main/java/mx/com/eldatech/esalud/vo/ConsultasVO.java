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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ddomi
 */
@Entity
@Table(name = "consultas")
@NamedQueries({
    @NamedQuery(name = "ConsultasVO.findAll", query = "SELECT c FROM ConsultasVO c")})
public class ConsultasVO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_consulta")
    private Integer idConsulta;
    @Basic(optional = false)
    @Column(name = "peso")
    private String peso;
    @Basic(optional = false)
    @Column(name = "talla")
    private String talla;
    @Basic(optional = false)
    @Column(name = "alergias")
    private String alergias;
    @Basic(optional = false)
    @Column(name = "diagnostico")
    private String diagnostico;
    @Basic(optional = false)
    @Column(name = "frecuencia_cardiaca")
    private String frecuenciaCardiaca;
    @Basic(optional = false)
    @Column(name = "fum")
    private String fum;
    @Basic(optional = false)
    @Column(name = "glucosa")
    private String glucosa;
    @Basic(optional = false)
    @Column(name = "saturacion_oxigeno")
    private String saturacionOxigeno;
    @Basic(optional = false)
    @Column(name = "temperatura")
    private String temperatura;
    @Basic(optional = false)
    @Column(name = "tension_arterial")
    private String tensionArterial;
    @Basic(optional = false)
    @Column(name = "frecuencia_respiratoria")
    private String frecuenciaRespiratoria;
    @Basic(optional = false)
    @Column(name = "fecha_consulta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaConsulta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConsulta")
    private List<RecetasVO> recetasVOList;
    @JoinColumn(name = "id_paciente", referencedColumnName = "id_paciente")
    @ManyToOne(optional = false)
    private PacienteVO idPaciente;

    public ConsultasVO() {
    }

    public ConsultasVO(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }
    
    public ConsultasVO(SignosVitalesVO signos) {
        this.peso = signos.getPeso();
        this.talla = signos.getTalla();
        this.tensionArterial = signos.getTensionArterial();
        this.frecuenciaCardiaca = signos.getFrecuenciaCardiaca();
        this.saturacionOxigeno = signos.getSaturacionOxigeno();
        this.glucosa = signos.getGlucosa();
        this.fum = signos.getFum();
        this.temperatura = signos.getTemperatura();
        this.alergias = signos.getAlergias();
        this.diagnostico = signos.getDiagnostico();   
        this.idPaciente = new PacienteVO();
        this.idPaciente.setIdPaciente(signos.getIdPaciente());
        this.frecuenciaRespiratoria = signos.getFrecuenciaRespiratoria();
    }

    public ConsultasVO(Integer idConsulta, String peso, String talla, String alergias, String diagnostico, String frecuenciaCardiaca, String fum, String glucosa, String saturacionOxigeno, String temperatura, String tensionArterial, String frecuenciaRespiratoria, Date fechaConsulta) {
        this.idConsulta = idConsulta;
        this.peso = peso;
        this.talla = talla;
        this.alergias = alergias;
        this.diagnostico = diagnostico;
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        this.fum = fum;
        this.glucosa = glucosa;
        this.saturacionOxigeno = saturacionOxigeno;
        this.temperatura = temperatura;
        this.tensionArterial = tensionArterial;
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
        this.fechaConsulta = fechaConsulta;
    }

    public Integer getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    public void setFrecuenciaCardiaca(String frecuenciaCardiaca) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
    }

    public String getFum() {
        return fum;
    }

    public void setFum(String fum) {
        this.fum = fum;
    }

    public String getGlucosa() {
        return glucosa;
    }

    public void setGlucosa(String glucosa) {
        this.glucosa = glucosa;
    }

    public String getSaturacionOxigeno() {
        return saturacionOxigeno;
    }

    public void setSaturacionOxigeno(String saturacionOxigeno) {
        this.saturacionOxigeno = saturacionOxigeno;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getTensionArterial() {
        return tensionArterial;
    }

    public void setTensionArterial(String tensionArterial) {
        this.tensionArterial = tensionArterial;
    }

    public String getFrecuenciaRespiratoria() {
        return frecuenciaRespiratoria;
    }

    public void setFrecuenciaRespiratoria(String frecuenciaRespiratoria) {
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
    }

    public Date getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(Date fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public List<RecetasVO> getRecetasVOList() {
        return recetasVOList;
    }

    public void setRecetasVOList(List<RecetasVO> recetasVOList) {
        this.recetasVOList = recetasVOList;
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
        hash += (idConsulta != null ? idConsulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsultasVO)) {
            return false;
        }
        ConsultasVO other = (ConsultasVO) object;
        if ((this.idConsulta == null && other.idConsulta != null) || (this.idConsulta != null && !this.idConsulta.equals(other.idConsulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.eldatech.esalud.vo.ConsultasVO[ idConsulta=" + idConsulta + " ]";
    }
    
}
