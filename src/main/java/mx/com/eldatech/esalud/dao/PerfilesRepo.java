/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.com.eldatech.esalud.dao;

import mx.com.eldatech.esalud.vo.PerfilesVO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ddomi
 */
public interface PerfilesRepo extends JpaRepository<PerfilesVO, Long>{
    
}
