/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.eldatech.esalud.dao;

import mx.com.eldatech.esalud.dto.AntecedentesNoPatologicosDTO;
import mx.com.eldatech.esalud.vo.AntecedentesNoPatologicosVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ddomi
 */
@Service
public class AntecedentesNoPatologicosService {
    
    private final AntecedentesNoPatologicosRepo repository;
    
    @Autowired
    public AntecedentesNoPatologicosService(AntecedentesNoPatologicosRepo repository) {
        this.repository = repository;
    }
    
    public AntecedentesNoPatologicosDTO insertAntecedentes(AntecedentesNoPatologicosVO antecedentes) {
        return new AntecedentesNoPatologicosDTO(this.repository.save(antecedentes));
    }
}
