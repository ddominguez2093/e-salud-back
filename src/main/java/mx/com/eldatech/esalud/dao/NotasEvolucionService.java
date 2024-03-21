/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.eldatech.esalud.dao;

import java.util.List;
import mx.com.eldatech.esalud.dto.NotasEvolucionDTO;
import mx.com.eldatech.esalud.vo.NotasEvolucionVO;
import mx.com.eldatech.esalud.vo.PacienteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ddomi
 */
@Service
public class NotasEvolucionService {
    
    private final NotasEvolucionRepo repository;
    
    @Autowired
    public NotasEvolucionService(NotasEvolucionRepo repository) {
        this.repository = repository;
    }
    
    public List<NotasEvolucionDTO> getNotesByIdPatient(Integer idPatient) {
        List<NotasEvolucionVO> notasEvolucionVO = this.repository.findNotasEvolucionByIdPaciente(new PacienteVO(idPatient));
        if(notasEvolucionVO != null) {
            return NotasEvolucionDTO.getDTOListFromVOList(notasEvolucionVO);
        } else {
            return null;
        }
    }
    
    public NotasEvolucionDTO insertNote(NotasEvolucionVO notasEvolucion) {
        return new NotasEvolucionDTO(this.repository.save(notasEvolucion));
    }
}
