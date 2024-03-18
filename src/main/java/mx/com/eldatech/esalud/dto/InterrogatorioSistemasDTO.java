/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.eldatech.esalud.dto;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import mx.com.eldatech.esalud.vo.HistoriaClinicaVO;
import mx.com.eldatech.esalud.vo.InterrogatorioSistemasVO;

/**
 *
 * @author ddomi
 */
public class InterrogatorioSistemasDTO {

    private Integer idInterrogatorio;
    private String aparatoResp;
    private String aparatoDig;
    private String aparatoCardio;
    private String aparatoRenal;
    private String aparatoGenital;
    private String sistemaEndocrino;
    private String sistemaHematoLinfatico;
    private String pielAnexos;
    private String musculoEsqueletico;
    private String sistemaNervioso;
    private Integer idHistoria;
    
    public InterrogatorioSistemasDTO(){}
    
    public InterrogatorioSistemasDTO(InterrogatorioSistemasVO interrogatorio) {
        this.idInterrogatorio = interrogatorio.getIdInterrogatorio();
        this.aparatoResp = interrogatorio.getAparatoResp();
        this.aparatoDig = interrogatorio.getAparatoDig();
        this.aparatoCardio = interrogatorio.getAparatoCardio();
        this.aparatoRenal = interrogatorio.getAparatoRenal();
        this.aparatoGenital = interrogatorio.getAparatoGenital();
        this.sistemaEndocrino = interrogatorio.getSistemaEndocrino();
        this.sistemaHematoLinfatico = interrogatorio.getSistemaHematoLinfatico();
        this.pielAnexos = interrogatorio.getPielAnexos();
        this.musculoEsqueletico = interrogatorio.getMusculoEsqueletico();
        this.sistemaNervioso = interrogatorio.getSistemaNervioso();
        this.idHistoria = interrogatorio.getIdHistoria().getIdHistoria();
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

    public Integer getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(Integer idHistoria) {
        this.idHistoria = idHistoria;
    }
}
