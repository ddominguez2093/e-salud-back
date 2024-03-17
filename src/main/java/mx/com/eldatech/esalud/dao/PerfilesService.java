/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.eldatech.esalud.dao;

import java.util.List;
import mx.com.eldatech.esalud.vo.PerfilesVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ddomi
 */
@Service
public class PerfilesService {
    private final PerfilesRepo perfilesRepo;
    
    @Autowired
    public PerfilesService(PerfilesRepo perfilesRepo) {
        this.perfilesRepo = perfilesRepo;
    }
    
    public List<PerfilesVO> getAllPerfiles() {
        return this.perfilesRepo.findAll();
    }
    
    public PerfilesVO getPerfilById(Long id) {
        return this.perfilesRepo.findById(id).orElse(null);        
    }
    
}
