/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.eldatech.esalud.dao;

import mx.com.eldatech.esalud.vo.HistoriaClinicaVO;
import mx.com.eldatech.esalud.vo.PacienteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ddomi
 */
@Service
public class HistoriaClinicaService {
    
    private final HistoriaClinicaRepo repo;
    
    @Autowired
    public HistoriaClinicaService(HistoriaClinicaRepo repo) {
        this.repo = repo;
    }
    
    public HistoriaClinicaVO findByIdPaciente(Integer idPaciente) {
        return this.repo.findHistoriaClinicaByIdPaciente(new PacienteVO(idPaciente));
    }
    
    public HistoriaClinicaVO insertHistoria(HistoriaClinicaVO historiaClinica) {
        return this.repo.save(historiaClinica);
    }
}
