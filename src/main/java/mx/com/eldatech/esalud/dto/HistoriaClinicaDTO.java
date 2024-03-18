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
}
