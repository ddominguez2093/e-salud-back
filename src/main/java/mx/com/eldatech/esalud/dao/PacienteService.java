/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.eldatech.esalud.dao;

import java.util.List;
import mx.com.eldatech.esalud.vo.PacienteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author ddomi
 */
@Service
public class PacienteService {
    private final PacienteRepo repository;
    
    @Autowired
    public PacienteService(PacienteRepo repository) {
        this.repository = repository;
    }
    
    public List<PacienteVO> getAllPatients() {  
        Sort sort = Sort.by(Sort.Order.desc("fechaRegistro"));
        List<PacienteVO> patientList = this.repository.findAll(sort);
        fillFormattedDate(patientList);
        return patientList;
    }
    
    private void fillFormattedDate(List<PacienteVO> patientList) {
        for(PacienteVO patient : patientList) {
            patient.setFechaRegistroFor();
        }
    }
    
    public List<PacienteVO> getTodayPatients(Integer idMedico) {
        List<PacienteVO> listaPacientes = this.repository.findAllRegistradosHoyByIdMedico(idMedico);
        fillFormattedDate(listaPacientes);
        return listaPacientes;
    }
    
    public PacienteVO insertPaciente(PacienteVO paciente) {
        return this.repository.save(paciente);
    }
    
    public PacienteVO getPacienteById(Long id) {
        return this.repository.findById(id).orElse(null);
    }
    
    public PacienteVO updatePaciente(PacienteVO pacienteUpdate) {
        return this.repository.save(pacienteUpdate);
    }
    
    public void deletePaciente(PacienteVO paciente) {
        this.repository.deleteById(paciente.getIdPaciente().longValue());
    }
}
