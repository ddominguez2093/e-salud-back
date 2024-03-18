/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.eldatech.esalud.dto;

import mx.com.eldatech.esalud.vo.EstudiosGabineteVO;

/**
 *
 * @author ddomi
 */
public class EstudiosGabineteDTO {

    private Integer idEstudio;
    private String estudios;
    private Integer idHistoria;
    
    public EstudiosGabineteDTO(){}
    
    public EstudiosGabineteDTO(EstudiosGabineteVO estudiosVO) {
        this.idEstudio = estudiosVO.getIdEstudio();
        this.estudios = estudiosVO.getEstudios();
        this.idHistoria = estudiosVO.getIdHistoria().getIdHistoria();
    }

    public Integer getIdEstudio() {
        return idEstudio;
    }

    public void setIdEstudio(Integer idEstudio) {
        this.idEstudio = idEstudio;
    }

    public String getEstudios() {
        return estudios;
    }

    public void setEstudios(String estudios) {
        this.estudios = estudios;
    }

    public Integer getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(Integer idHistoria) {
        this.idHistoria = idHistoria;
    }
}
