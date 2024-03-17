/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package mx.com.eldatech.esalud.dao;

import mx.com.eldatech.esalud.vo.ConsultasVO;
import mx.com.eldatech.esalud.vo.PacienteVO;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
/**
 *
 * @author ddomi
 */
public interface ConsultasRepo extends JpaRepository<ConsultasVO, Long> {
    List<ConsultasVO> findConsultasByIdPaciente(PacienteVO idPaciente);    
    void deleteByIdPaciente(PacienteVO idPaciente);
}
