/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package mx.com.eldatech.esalud.dao;

import mx.com.eldatech.esalud.vo.AntecedentesFamiliaresVO;
import mx.com.eldatech.esalud.vo.HistoriaClinicaVO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ddomi
 */
public interface AntecedentesFamiliaresRepo extends JpaRepository<AntecedentesFamiliaresVO, Long> {
    AntecedentesFamiliaresVO findAntecedentesFamiliaresByIdHistoria(HistoriaClinicaVO historia);
}
