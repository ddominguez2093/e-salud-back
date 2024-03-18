/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.eldatech.esalud.dao;

import mx.com.eldatech.esalud.dto.InterrogatorioSistemasDTO;
import mx.com.eldatech.esalud.vo.InterrogatorioSistemasVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ddomi
 */
@Service
public class InterrogatorioSistemasService {
    
    private final InterrogatorioSistemasRepo repository;
    
    @Autowired
    public InterrogatorioSistemasService(InterrogatorioSistemasRepo repository) {
        this.repository = repository;
    }
    
    public InterrogatorioSistemasDTO insertInterrogatorio(InterrogatorioSistemasVO interrogatorioVO) {
        return new InterrogatorioSistemasDTO(this.repository.save(interrogatorioVO));
    }
}
