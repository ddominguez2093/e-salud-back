/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.eldatech.esalud.dto;

import mx.com.eldatech.esalud.vo.HistoriaClinicaVO;

/**
 *
 * @author ddomi
 */
public class HistoriaClinicaDTO {

    private Integer idHistoriaClinica;
    private Integer idPaciente;
    private AntecedentesFamiliaresDTO antecedentes;
    private AntecedentesPatologicosDTO antecedentesPat;
    private AntecedentesNoPatologicosDTO antecedentesNoPat;
    private InterrogatorioSistemasDTO interrogatorio;
    private EstudiosGabineteDTO estudiosGabinete;
    private AntecedentesGinecoobstetricosDTO antecedentesGinecologicos;
    public HistoriaClinicaDTO(){}
    
    public HistoriaClinicaDTO(HistoriaClinicaVO historiaVO) {
        this.idHistoriaClinica = historiaVO.getIdHistoria();
        this.idPaciente = historiaVO.getIdPaciente().getIdPaciente();   
        setAdditionalData(historiaVO);        
    }
    
    private void setAdditionalData(HistoriaClinicaVO historia) {
        if(historia.getAntecedentesFamiliaresVOList() != null && !historia.getAntecedentesFamiliaresVOList().isEmpty()) {
            this.antecedentes = new AntecedentesFamiliaresDTO(historia.getAntecedentesFamiliaresVOList().get(0));
        }
        
        if(historia.getAntecedentesPatologicosVOList() != null && !historia.getAntecedentesPatologicosVOList().isEmpty()) {
            this.antecedentesPat = new AntecedentesPatologicosDTO(historia.getAntecedentesPatologicosVOList().get(0));
        }
        
        if(historia.getAntecedentesNoPatologicosVOList() != null && !historia.getAntecedentesNoPatologicosVOList().isEmpty()) {
            this.antecedentesNoPat = new AntecedentesNoPatologicosDTO(historia.getAntecedentesNoPatologicosVOList().get(0));
        }
        
        if(historia.getInterrogatorioSistemasVOList() != null && !historia.getInterrogatorioSistemasVOList().isEmpty()) {
            this.interrogatorio = new InterrogatorioSistemasDTO(historia.getInterrogatorioSistemasVOList().get(0));
        }
        
        if(historia.getEstudiosGabineteVOList() != null && !historia.getEstudiosGabineteVOList().isEmpty()) {
            this.estudiosGabinete = new EstudiosGabineteDTO(historia.getEstudiosGabineteVOList().get(0));
        }
        
        if(historia.getAntecedentesGinecoobstetricosVOList() != null && !historia.getAntecedentesGinecoobstetricosVOList().isEmpty()) {
            this.antecedentesGinecologicos = new AntecedentesGinecoobstetricosDTO(historia.getAntecedentesGinecoobstetricosVOList().get(0));
        }
    }

    public Integer getIdHistoriaClinica() {
        return idHistoriaClinica;
    }

    public void setIdHistoriaClinica(Integer idHistoriaClinica) {
        this.idHistoriaClinica = idHistoriaClinica;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public AntecedentesFamiliaresDTO getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(AntecedentesFamiliaresDTO antecedentes) {
        this.antecedentes = antecedentes;
    }

    public AntecedentesPatologicosDTO getAntecedentesPat() {
        return antecedentesPat;
    }

    public void setAntecedentesPat(AntecedentesPatologicosDTO antecedentesPat) {
        this.antecedentesPat = antecedentesPat;
    }

    public AntecedentesNoPatologicosDTO getAntecedentesNoPat() {
        return antecedentesNoPat;
    }

    public void setAntecedentesNoPat(AntecedentesNoPatologicosDTO antecedentesNoPat) {
        this.antecedentesNoPat = antecedentesNoPat;
    }

    public InterrogatorioSistemasDTO getInterrogatorio() {
        return interrogatorio;
    }

    public void setInterrogatorio(InterrogatorioSistemasDTO interrogatorio) {
        this.interrogatorio = interrogatorio;
    }

    public EstudiosGabineteDTO getEstudiosGabinete() {
        return estudiosGabinete;
    }

    public void setEstudiosGabinete(EstudiosGabineteDTO estudiosGabinete) {
        this.estudiosGabinete = estudiosGabinete;
    }

    public AntecedentesGinecoobstetricosDTO getAntecedentesGinecologicos() {
        return antecedentesGinecologicos;
    }

    public void setAntecedentesGinecologicos(AntecedentesGinecoobstetricosDTO antecedentesGinecologicos) {
        this.antecedentesGinecologicos = antecedentesGinecologicos;
    }
}
