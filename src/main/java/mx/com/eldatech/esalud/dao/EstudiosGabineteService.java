/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.eldatech.esalud.dao;

import mx.com.eldatech.esalud.dto.EstudiosGabineteDTO;
import mx.com.eldatech.esalud.vo.EstudiosGabineteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ddomi
 */
@Service
public class EstudiosGabineteService {
    
    private final EstudiosGabineteRepo repository;
    
    @Autowired
    public EstudiosGabineteService(EstudiosGabineteRepo repository) {
        this.repository = repository;
    }
    
    public EstudiosGabineteDTO insertEstudiosGabinete(EstudiosGabineteVO estudiosGabinete) {
        return new EstudiosGabineteDTO(this.repository.save(estudiosGabinete));
    }
}
