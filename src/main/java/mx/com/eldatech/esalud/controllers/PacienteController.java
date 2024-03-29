/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package mx.com.eldatech.esalud.controllers;

import java.io.File;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import mx.com.eldatech.esalud.dao.AntecedentesFamiliaresService;
import mx.com.eldatech.esalud.dao.AntecedentesGinecoobstetricosService;
import mx.com.eldatech.esalud.dao.AntecedentesNoPatologicosService;
import mx.com.eldatech.esalud.dao.AntecedentesPatologicosService;
import mx.com.eldatech.esalud.dao.ConsultasService;
import mx.com.eldatech.esalud.dao.EstudiosGabineteService;
import mx.com.eldatech.esalud.dao.HistoriaClinicaService;
import mx.com.eldatech.esalud.dao.InterrogatorioSistemasService;
import mx.com.eldatech.esalud.dao.NotasEvolucionService;
import mx.com.eldatech.esalud.dao.PacienteService;
import mx.com.eldatech.esalud.dto.AntecedentesFamiliaresDTO;
import mx.com.eldatech.esalud.dto.AntecedentesGinecoobstetricosDTO;
import mx.com.eldatech.esalud.dto.AntecedentesNoPatologicosDTO;
import mx.com.eldatech.esalud.dto.AntecedentesPatologicosDTO;
import mx.com.eldatech.esalud.dto.EstudiosGabineteDTO;
import mx.com.eldatech.esalud.dto.HistoriaClinicaDTO;
import mx.com.eldatech.esalud.dto.InterrogatorioSistemasDTO;
import mx.com.eldatech.esalud.dto.NotasEvolucionDTO;
import mx.com.eldatech.esalud.dto.PacienteDTO;
import mx.com.eldatech.esalud.vo.AntecedentesFamiliaresVO;
import mx.com.eldatech.esalud.vo.AntecedentesGinecoobstetricosVO;
import mx.com.eldatech.esalud.vo.AntecedentesNoPatologicosVO;
import mx.com.eldatech.esalud.vo.AntecedentesPatologicosVO;
import mx.com.eldatech.esalud.vo.ConsultasVO;
import mx.com.eldatech.esalud.vo.EstudiosGabineteVO;
import mx.com.eldatech.esalud.vo.HistoriaClinicaVO;
import mx.com.eldatech.esalud.vo.InterrogatorioSistemasVO;
import mx.com.eldatech.esalud.vo.NotasEvolucionVO;
import mx.com.eldatech.esalud.vo.PacienteVO;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author ddomi
 */
@RestController
@RequestMapping("/paciente-controller")
public class PacienteController {
    
    private static final Logger logger = LogManager.getLogger(PacienteController.class);
    
    @Autowired
    private PacienteService pacienteService;
    
    @Autowired
    private ConsultasService consultaService;
    
    @Autowired
    private HistoriaClinicaService historiaService;
    
    @Autowired
    private AntecedentesFamiliaresService antecedentesService;
    
    @Autowired
    private AntecedentesPatologicosService antecedentesPatService;
    
    @Autowired
    private AntecedentesNoPatologicosService antecedentesNoPatService;
    
    @Autowired
    private InterrogatorioSistemasService antecedentesSistemasService;
    
    @Autowired
    private EstudiosGabineteService estudiosGabineteService;
    
    @Autowired
    private AntecedentesGinecoobstetricosService antecedentesGinecoService;
    
    @Autowired
    private NotasEvolucionService notasService;
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError(Exception ex) {
        logger.error("Ocurrio un error en PacienteController", ex);
        logger.error(ex.getLocalizedMessage());
    }
    
    @PostMapping("/insertPatient")
    public ResponseEntity<Boolean> insertaPaciente(@RequestBody PacienteVO paciente) {
        paciente.setFechaRegistro(new Date(System.currentTimeMillis()));
        PacienteVO pacienteInsert = this.pacienteService.insertPaciente(paciente);
        if (pacienteInsert != null) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/getAllPatients")
    public ResponseEntity<List<PacienteDTO>> getAllPatients() {
        List<PacienteVO> listaPacientes = this.pacienteService.getAllPatients();
        if (listaPacientes.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(PacienteDTO.getListDTOFromVO(listaPacientes), HttpStatus.OK);
        }
    }
    
    @PostMapping("/updatePatient")
    public ResponseEntity<Boolean> updatePaciente(@RequestBody PacienteVO paciente) {
        PacienteVO pacienteUpdated = this.pacienteService.updatePaciente(paciente);
        if (pacienteUpdated != null) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/deletePatient")
    public ResponseEntity<Boolean> deletePaciente(@RequestBody PacienteVO paciente) {
        List<ConsultasVO> listaConsultas = this.consultaService.getConsultasByIdPaciente(paciente);
        if (listaConsultas != null) {
            for (ConsultasVO consulta : listaConsultas) {
                this.consultaService.deleteConsultaById(consulta.getIdConsulta().longValue());
            }
        }
        this.pacienteService.deletePaciente(paciente);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
    
    @GetMapping("/getConsentimiento")
    public ResponseEntity<String> getConsentimiento() throws Exception {
        File file = new File("CONSENTIMIENTO.pdf");
        byte[] bytesArchivo = FileUtils.readFileToByteArray(file);
        return new ResponseEntity<>(Base64.getEncoder().encodeToString(bytesArchivo), HttpStatus.OK);
    }
    
    @PostMapping("/getHistoria")
    public ResponseEntity<HistoriaClinicaDTO> getHistoria(@RequestParam(name = "idPaciente") Integer idPaciente) {
        HistoriaClinicaVO historia = this.historiaService.findByIdPaciente(idPaciente);
        if (historia != null) {
            return new ResponseEntity<>(new HistoriaClinicaDTO(historia), HttpStatus.OK);
        } else {
            HistoriaClinicaVO historiaVO = new HistoriaClinicaVO();
            historiaVO.setIdPaciente(new PacienteVO(idPaciente));
            HistoriaClinicaVO historiaInsert = this.historiaService.insertHistoria(historiaVO);
            return new ResponseEntity<>(new HistoriaClinicaDTO(historiaInsert), HttpStatus.OK);
        }
    }
    
    @PostMapping("/insertAntecedentes")
    public ResponseEntity<AntecedentesFamiliaresDTO> insertAntecedentes(@RequestBody AntecedentesFamiliaresVO antecedentes) {
        AntecedentesFamiliaresDTO antecedentesDTO = this.antecedentesService.insertAntecedentes(antecedentes);
        if(antecedentesDTO != null) {
            return new ResponseEntity<>(antecedentesDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/insertAntecedentesPatologicos")
    public ResponseEntity<AntecedentesPatologicosDTO> insertAntecedentesPatologicos(@RequestBody AntecedentesPatologicosVO antecedentes) {
        AntecedentesPatologicosDTO antecedentesDTO = this.antecedentesPatService.insertAntecedentes(antecedentes);
        if(antecedentesDTO != null) {
            return new ResponseEntity<>(antecedentesDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/insertAntecedentesNoPatologicos")
    public ResponseEntity<AntecedentesNoPatologicosDTO> insertAntecedentesPatologicos(@RequestBody AntecedentesNoPatologicosVO antecedentes) {
        AntecedentesNoPatologicosDTO antecedentesDTO = this.antecedentesNoPatService.insertAntecedentes(antecedentes);
        if(antecedentesDTO != null) {
            return new ResponseEntity<>(antecedentesDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/insertInterrogatorio")
    public ResponseEntity<InterrogatorioSistemasDTO> insertInterrogatorio(@RequestBody InterrogatorioSistemasVO interrogatorio) {
        InterrogatorioSistemasDTO antecedentesDTO = this.antecedentesSistemasService.insertInterrogatorio(interrogatorio);
        if(antecedentesDTO != null) {
            return new ResponseEntity<>(antecedentesDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/insertEstudios")
    public ResponseEntity<EstudiosGabineteDTO> insertInterrogatorio(@RequestBody EstudiosGabineteVO estudios) {
        EstudiosGabineteDTO estudiosDTO = this.estudiosGabineteService.insertEstudiosGabinete(estudios);
        if(estudiosDTO != null) {
            return new ResponseEntity<>(estudiosDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/insertAntecedentesGineco")
    public ResponseEntity<AntecedentesGinecoobstetricosDTO> insertInterrogatorio(@RequestBody AntecedentesGinecoobstetricosVO antecedentes) {
        AntecedentesGinecoobstetricosDTO estudiosDTO = this.antecedentesGinecoService.insertAntecedente(antecedentes);
        if(estudiosDTO != null) {
            return new ResponseEntity<>(estudiosDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/insertNotaEvolucion")
    public ResponseEntity<NotasEvolucionDTO> insertNotaEvolucion(@RequestBody NotasEvolucionVO notasEvolucion) {
        notasEvolucion.setFechaRegistro(new Date(System.currentTimeMillis()));
        NotasEvolucionDTO notaEvolucionDTO = this.notasService.insertNote(notasEvolucion);
        if(notaEvolucionDTO != null) {
            return new ResponseEntity<>(notaEvolucionDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/getEvolutionNotes")
    public ResponseEntity<List<NotasEvolucionDTO>> getEvolutionNotes(@RequestParam(name = "idPaciente") Integer idPaciente) {
        List<NotasEvolucionDTO> listaNotasDTO = this.notasService.getNotesByIdPatient(idPaciente);
        if(listaNotasDTO != null) {
            return new ResponseEntity<>(listaNotasDTO,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/getTodayPatients")
    public ResponseEntity<List<PacienteDTO>> getTodayPatients(@RequestParam(name = "idMedico") Integer idMedico) {
        List<PacienteDTO> listaPacientes = PacienteDTO.getListDTOFromVO(this.pacienteService.getTodayPatients(idMedico));
        if(listaPacientes != null) {
            return new ResponseEntity<>(listaPacientes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
}
