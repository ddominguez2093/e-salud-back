/**
 * 
 */
package mx.com.eldatech.esalud.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.eldatech.esalud.vo.MedicamentosVO;

/**
 * @author Daniel Dominguez
 * 
 */
public interface MedicamentosRepo extends JpaRepository<MedicamentosVO, Long> {
    List<MedicamentosVO> findBySustanciaLike(String sustancia);
}
