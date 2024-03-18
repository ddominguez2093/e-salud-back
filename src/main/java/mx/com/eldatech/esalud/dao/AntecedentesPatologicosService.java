/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.eldatech.esalud.dao;

import mx.com.eldatech.esalud.dto.AntecedentesPatologicosDTO;
import mx.com.eldatech.esalud.vo.AntecedentesPatologicosVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ddomi
 */
@Service
public class AntecedentesPatologicosService {
    
    private final AntecedentesPatologicosRepo repository;
    
    @Autowired
    public AntecedentesPatologicosService(AntecedentesPatologicosRepo repository) {
        this.repository = repository;
    }
    
    public AntecedentesPatologicosDTO insertAntecedentes(AntecedentesPatologicosVO antecedentesVO) {
        return new AntecedentesPatologicosDTO(this.repository.save(antecedentesVO));
    }
}
