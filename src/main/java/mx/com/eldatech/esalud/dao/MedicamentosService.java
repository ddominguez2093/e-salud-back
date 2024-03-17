package mx.com.eldatech.esalud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.com.eldatech.esalud.vo.MedicamentosVO;

/**
 *
 * @author Daniel Dominguez
 */
@Service
public class MedicamentosService {

    private final MedicamentosRepo repository;

    @Autowired
    public MedicamentosService(MedicamentosRepo repository) {
        this.repository = repository;
    }

    public List<MedicamentosVO> getMedicamentoByNombreLike(String nombre) {
        return repository.findBySustanciaLike(nombre);
    }

    public List<MedicamentosVO> getAllMedicamentos() {
        return repository.findAll();
    }

    public MedicamentosVO getMedicamentoById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public MedicamentosVO createMedicamento(MedicamentosVO medicamento) {
        return repository.save(medicamento);
    }

    public MedicamentosVO updateMedicamento(MedicamentosVO medicamento) {
        MedicamentosVO medUpdate = repository.findById(medicamento.getId().longValue()).orElse(null);
        if (medUpdate != null) {
            medUpdate.setNombre(medicamento.getNombre());
            medUpdate.setSustancia(medicamento.getSustancia());
        }
        return repository.save(medUpdate);
    }

    public void deleteMedicamento(Long id) {
        repository.deleteById(id);
    }
}
