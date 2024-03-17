/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.eldatech.esalud.dto;

/**
 *
 * @author ddomi
 */
public class HistoriaClinicaDTO {

    private Integer idHistoriaClinica;
    private Integer idPaciente;
    private AntecedentesFamiliaresDTO antecedentes;

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
