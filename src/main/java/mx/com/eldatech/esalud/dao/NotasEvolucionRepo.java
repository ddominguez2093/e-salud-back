/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.com.eldatech.esalud.dao;

import java.util.List;
import mx.com.eldatech.esalud.vo.NotasEvolucionVO;
import mx.com.eldatech.esalud.vo.PacienteVO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ddomi
 */
public interface NotasEvolucionRepo extends JpaRepository<NotasEvolucionVO, Long> {
    List<NotasEvolucionVO> findNotasEvolucionByIdPaciente(PacienteVO paciente);
}
