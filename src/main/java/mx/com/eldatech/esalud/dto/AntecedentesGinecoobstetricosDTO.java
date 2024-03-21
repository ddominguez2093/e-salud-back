/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.eldatech.esalud.dto;

import mx.com.eldatech.esalud.vo.AntecedentesGinecoobstetricosVO;

/**
 *
 * @author ddomi
 */
public class AntecedentesGinecoobstetricosDTO {

    private Integer idAntecedente;
    private String antecedentes;
    private Integer idHistoria;
    
    public AntecedentesGinecoobstetricosDTO(){}
    
    public AntecedentesGinecoobstetricosDTO(AntecedentesGinecoobstetricosVO antecedentes) {
        this.idAntecedente = antecedentes.getIdAntecedente();
        this.antecedentes = antecedentes.getAntecedentes();
        this.idHistoria = antecedentes.getIdHistoria().getIdHistoria();
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

    public Integer getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(Integer idHistoria) {
        this.idHistoria = idHistoria;
    }
}
