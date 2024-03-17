/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.eldatech.esalud.dao;

import java.util.List;
import mx.com.eldatech.esalud.vo.CatCie10VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ddomi
 */
@Service
public class Cie10Service {
    
    private final Cie10Repo repository;
    
    @Autowired
    public Cie10Service(Cie10Repo repository) {
        this.repository = repository;
    }
    
    public List<CatCie10VO> getAllCie10VOs() {
        return repository.findAll();
    }
    
    public List<CatCie10VO> getCatCie10Like(String nombre) {
        return repository.findByNombreLike(nombre);
    }
    
    
}
