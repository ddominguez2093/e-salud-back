/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.com.eldatech.esalud.dao;

import java.util.List;
import mx.com.eldatech.esalud.vo.CatCie10VO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ddomi
 */
public interface Cie10Repo extends JpaRepository<CatCie10VO, Long> {
    List<CatCie10VO> findByNombreLike(String nombre);
}
