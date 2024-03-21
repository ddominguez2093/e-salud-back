/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.eldatech.esalud.dao;

import mx.com.eldatech.esalud.dto.AntecedentesGinecoobstetricosDTO;
import mx.com.eldatech.esalud.vo.AntecedentesGinecoobstetricosVO;
import org.springframework.stereotype.Service;

/**
 *
 * @author ddomi
 */
@Service
public class AntecedentesGinecoobstetricosService {
    
    private final AntecedentesGinecoobstetricosRepo repository;
    
    public AntecedentesGinecoobstetricosService(AntecedentesGinecoobstetricosRepo repository) {
        this.repository = repository;
    }
    
    public AntecedentesGinecoobstetricosDTO insertAntecedente(AntecedentesGinecoobstetricosVO antecedente) {
        return new AntecedentesGinecoobstetricosDTO(this.repository.save(antecedente));
    }
}
