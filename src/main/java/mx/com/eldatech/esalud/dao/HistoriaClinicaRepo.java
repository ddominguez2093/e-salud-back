/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.com.eldatech.esalud.dao;

import mx.com.eldatech.esalud.vo.HistoriaClinicaVO;
import mx.com.eldatech.esalud.vo.PacienteVO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ddomi
 */
public interface HistoriaClinicaRepo extends JpaRepository<HistoriaClinicaVO, Long> {
    HistoriaClinicaVO findHistoriaClinicaByIdPaciente(PacienteVO paciente);
}
