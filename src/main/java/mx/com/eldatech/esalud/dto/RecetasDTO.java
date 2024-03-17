/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.eldatech.esalud.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mx.com.eldatech.esalud.vo.RecetasVO;

/**
 *
 * @author ddomi
 */
public class RecetasDTO {
    private Integer idReceta;
    private String receta;
    private Integer idConsulta;
    private Integer idPaciente;
    private Date fechaCreacion;
    
    public RecetasDTO(){}
    
    public RecetasDTO(RecetasVO recetaVO) {
        this.idReceta = recetaVO.getIdReceta();
        this.receta = recetaVO.getReceta();
        this.idConsulta = recetaVO.getIdConsulta().getIdConsulta();
        this.idPaciente = recetaVO.getIdPaciente().getIdPaciente();
        this.fechaCreacion = recetaVO.getFechaCreacion();
    }
    
    public static List<RecetasDTO> getDTOListFromVOList(List<RecetasVO> listaRecetasVO) {
        List<RecetasDTO> listaRecetasDTO = new ArrayList<>();
        for(RecetasVO recetaVO: listaRecetasVO) {
            listaRecetasDTO.add(new RecetasDTO(recetaVO));
        }
        return listaRecetasDTO;
    }

    public Integer getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(Integer idReceta) {
        this.idReceta = idReceta;
    }

    public String getReceta() {
        return receta;
    }

    public void setReceta(String receta) {
        this.receta = receta;
    }

    public Integer getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    
}
