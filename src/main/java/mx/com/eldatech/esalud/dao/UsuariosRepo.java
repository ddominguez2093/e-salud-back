/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.com.eldatech.esalud.dao;

import mx.com.eldatech.esalud.vo.UsuariosVO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ddomi
 */
public interface UsuariosRepo extends JpaRepository<UsuariosVO, Long> {
    UsuariosVO findByNombreUsuario(String nombreUsuario);
}
