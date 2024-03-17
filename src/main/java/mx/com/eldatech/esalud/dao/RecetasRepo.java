/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package mx.com.eldatech.esalud.dao;

import java.util.List;
import mx.com.eldatech.esalud.vo.PacienteVO;
import mx.com.eldatech.esalud.vo.RecetasVO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ddomi
 */
public interface RecetasRepo extends JpaRepository<RecetasVO, Long> {
    List<RecetasVO> findRecetasByIdPaciente(PacienteVO idPaciente);
}
