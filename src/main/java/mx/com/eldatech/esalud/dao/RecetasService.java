/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.eldatech.esalud.dao;

import java.util.List;
import mx.com.eldatech.esalud.vo.PacienteVO;
import mx.com.eldatech.esalud.vo.RecetasVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ddomi
 */
@Service
public class RecetasService {
    private final RecetasRepo repository;
    
    @Autowired RecetasService(RecetasRepo repository){this.repository = repository;}
    
    public List<RecetasVO> getAll() {
        return repository.findAll();
    }
    
    public RecetasVO addReceipt(RecetasVO receipt) {
        return repository.save(receipt);
    }
    
    public List<RecetasVO> findByIdPatient(PacienteVO idPaciente) {
        return repository.findRecetasByIdPaciente(idPaciente);
    }

    public RecetasVO getLast() {
        return repository.findTopByOrderByFechaCreacionDesc();
    }
    
    
}
