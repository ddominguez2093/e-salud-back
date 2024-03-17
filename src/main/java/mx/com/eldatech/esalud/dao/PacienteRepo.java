/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package mx.com.eldatech.esalud.dao;

import java.util.List;
import mx.com.eldatech.esalud.vo.PacienteVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Sort;
/**
 *
 * @author ddomi
 */
public interface PacienteRepo extends JpaRepository<PacienteVO, Long> {
    List<PacienteVO> findAll(Sort sort);
}