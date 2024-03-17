/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package mx.com.eldatech.esalud.dao;

import mx.com.eldatech.esalud.vo.AntecedentesFamiliaresVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ddomi
 */
@Service
public class AntecedentesFamiliaresService {
        
    private final AntecedentesFamiliaresRepo repository;
    
    @Autowired
    public AntecedentesFamiliaresService(AntecedentesFamiliaresRepo repository) {
        this.repository = repository;
    }
    
    
}
