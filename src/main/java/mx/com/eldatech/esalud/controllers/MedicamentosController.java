package mx.com.eldatech.esalud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.eldatech.esalud.dao.ConsultasService;
import mx.com.eldatech.esalud.dao.MedicamentosService;
import mx.com.eldatech.esalud.vo.MedicamentosVO;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Daniel Dominguez
 */
@RestController
@RequestMapping("/medicamentos-controller")
public class MedicamentosController {

    @Autowired
    private MedicamentosService medicamentosService;
    
    @Autowired
    private ConsultasService consultas;
    
    
    @PostMapping("/getMedByNameLike")
    public ResponseEntity<List<MedicamentosVO>> getMedByNameLike(@RequestParam(name="nombre") String nombre) {
        List<MedicamentosVO> listaMedicamentos = this.medicamentosService.getMedicamentoByNombreLike("%"+nombre+"%");
        if(!listaMedicamentos.isEmpty()) {
            return new ResponseEntity<>(listaMedicamentos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllMeds")
    public ResponseEntity<List<MedicamentosVO>> getAllMeds() {
        List<MedicamentosVO> listaMedicamentos = this.medicamentosService.getAllMedicamentos();
        if (!listaMedicamentos.isEmpty()) {
            return new ResponseEntity<>(listaMedicamentos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/insertMed")
    public ResponseEntity<MedicamentosVO> insertMed(@RequestBody MedicamentosVO medicamento) {
        MedicamentosVO medInserted = medicamentosService.createMedicamento(medicamento);
        if (medInserted != null) {
            return new ResponseEntity<>(medInserted, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/updateMed")
    public ResponseEntity<MedicamentosVO> updateMed(@RequestBody MedicamentosVO medicamento) {
        MedicamentosVO medUpdated = medicamentosService.updateMedicamento(medicamento);
        if (medUpdated != null) {
            return new ResponseEntity<>(medUpdated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/deleteMed")
    public ResponseEntity<Boolean> deleteMed(@RequestBody MedicamentosVO medicamento) {
        medicamentosService.deleteMedicamento(medicamento.getId().longValue());
        return new ResponseEntity<>(true,HttpStatus.OK);
    }

   

}
