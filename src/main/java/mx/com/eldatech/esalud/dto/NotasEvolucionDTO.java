/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.eldatech.esalud.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mx.com.eldatech.esalud.vo.NotasEvolucionVO;

/**
 *
 * @author ddomi
 */
public class NotasEvolucionDTO {

    private Integer idNota;
    private String nota;
    private Integer idPaciente;
    private Integer idMedico;
    private String nombreMedico;
    private Date fechaRegistro;
    
    public NotasEvolucionDTO() {
        
    }
    
    public NotasEvolucionDTO(NotasEvolucionVO notasEvolucion) {
        this.idNota = notasEvolucion.getIdNota();
        this.nota = notasEvolucion.getNota();
        this.idPaciente = notasEvolucion.getIdPaciente().getIdPaciente();
        this.idMedico = notasEvolucion.getIdMedico().getIdMedico();
        this.nombreMedico = notasEvolucion.getIdMedico().getNombre();
        this.fechaRegistro = notasEvolucion.getFechaRegistro();
    }
    
    public static List<NotasEvolucionDTO> getDTOListFromVOList(List<NotasEvolucionVO> listaNotasVO) {
        List<NotasEvolucionDTO> listaNotasDTO = new ArrayList<>();
        for(NotasEvolucionVO notasVO: listaNotasVO) {
            listaNotasDTO.add(new NotasEvolucionDTO(notasVO));
        }
        return listaNotasDTO;
    }

    /**
     * @return the idNota
     */
    public Integer getIdNota() {
        return idNota;
    }

    /**
     * @param idNota the idNota to set
     */
    public void setIdNota(Integer idNota) {
        this.idNota = idNota;
    }

    /**
     * @return the nota
     */
    public String getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(String nota) {
        this.nota = nota;
    }

    /**
     * @return the idPaciente
     */
    public Integer getIdPaciente() {
        return idPaciente;
    }

    /**
     * @param idPaciente the idPaciente to set
     */
    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    /**
     * @return the idMedico
     */
    public Integer getIdMedico() {
        return idMedico;
    }

    /**
     * @param idMedico the idMedico to set
     */
    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    /**
     * @return the nombreMedico
     */
    public String getNombreMedico() {
        return nombreMedico;
    }

    /**
     * @param nombreMedico the nombreMedico to set
     */
    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    /**
     * @return the fechaRegistro
     */
    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * @param fechaRegistro the fechaRegistro to set
     */
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
