/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.eldatech.esalud.dao;

import java.util.List;
import mx.com.eldatech.esalud.vo.MedicosVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ddomi
 */
@Service
public class MedicosService {
    private final MedicosRepo medicosRepo;
    
    @Autowired
    public MedicosService(MedicosRepo medicosRepo) {
        this.medicosRepo = medicosRepo;
    }
    
    public List<MedicosVO> getAllMeds() {
        return medicosRepo.findAll();
    }
    
    public MedicosVO getMedById(Long id) {        
        return medicosRepo.findById(id).orElse(null);
    }
          
    public MedicosVO createMed(MedicosVO usuario){       
        return medicosRepo.save(usuario);
    }
    
    public MedicosVO updateMed(MedicosVO medico, Long id) {
        MedicosVO medUpd = medicosRepo.findById(id).orElse(null);
        if(medUpd != null) {
            medUpd.setAlmaMater(medico.getAlmaMater());
            medUpd.setCedulaProfesional(medico.getCedulaProfesional());
            medUpd.setCorreo(medico.getCorreo());
            medUpd.setEspecialidad(medico.getEspecialidad());
            medUpd.setNombre(medico.getNombre());
        }
        return medicosRepo.save(medUpd);
    }
    
    public void deleteMed(Long id) {
        medicosRepo.deleteById(id);
    }
}
