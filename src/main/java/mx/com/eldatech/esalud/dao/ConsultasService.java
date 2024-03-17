/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.eldatech.esalud.dao;

import java.util.List;
import mx.com.eldatech.esalud.vo.ConsultasVO;
import mx.com.eldatech.esalud.vo.PacienteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ddomi
 */
@Service
public class ConsultasService {
    
    private ConsultasRepo consultas;
    
    @Autowired
    public ConsultasService(ConsultasRepo consultas) {
        this.consultas = consultas;
    }
    
    public ConsultasVO insertConsulta(ConsultasVO consulta) {
        return this.consultas.save(consulta);
    }
    
    public List<ConsultasVO> getConsultasByIdPaciente(PacienteVO id) {
        return this.consultas.findConsultasByIdPaciente(id);
    }
    
    public ConsultasVO getConsultaById(Long id) {
        return this.consultas.findById(id).orElse(null);
    }
    
    public ConsultasVO updateConsultaById(ConsultasVO consultaUpdate) {
        ConsultasVO consultaSearch = getConsultaById(consultaUpdate.getIdConsulta().longValue());
        if(consultaSearch != null) {
            consultaSearch.setDiagnostico(consultaUpdate.getDiagnostico());
            return this.consultas.save(consultaSearch);
        } else {
            return null;
        }
    }
    
    public void deleteByIdPaciente(PacienteVO paciente) {
        this.consultas.deleteByIdPaciente(paciente);
    }
    
    public void deleteConsultaById(Long id) {
        this.consultas.deleteById(id);
    }
    
}
