/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package mx.com.eldatech.esalud.controllers;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import mx.com.eldatech.esalud.dao.ConsultasService;
import mx.com.eldatech.esalud.dao.RecetasService;
import mx.com.eldatech.esalud.dto.ConsultasDTO;
import mx.com.eldatech.esalud.dto.RecetasDTO;
import mx.com.eldatech.esalud.pdfutils.PDFUtils;
import mx.com.eldatech.esalud.utils.Utilities;
import mx.com.eldatech.esalud.vo.ConsultasVO;
import mx.com.eldatech.esalud.vo.MedicamentosRecetadosReq;
import mx.com.eldatech.esalud.vo.PDFResponse;
import mx.com.eldatech.esalud.vo.PacienteVO;
import mx.com.eldatech.esalud.vo.RecetasVO;
import mx.com.eldatech.esalud.vo.SignosVitalesVO;
import mx.com.eldatech.esalud.vo.UpdateConsultaReq;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
@RequestMapping("/consultas-controller")
public class ConsultaController {
    
    private static final Logger logger = LogManager.getLogger(ConsultaController.class);

    @Autowired
    private ConsultasService consultasService;
    @Autowired
    private RecetasService recetasService;
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError(Exception ex) {
        logger.error("Ocurrio un error en UsuariosController", ex);
        logger.error(ex.getLocalizedMessage());
    }

    @PostMapping("/insertConsulta")
    public ResponseEntity<ConsultasVO> insertConsulta(@RequestBody SignosVitalesVO consultaInsert) {
        ConsultasVO consultaVoIN = new ConsultasVO(consultaInsert);
        consultaVoIN.setFechaConsulta(new Date(System.currentTimeMillis()));
        ConsultasVO consulta = consultasService.insertConsulta(consultaVoIN);
        if (consulta != null) {
            return new ResponseEntity<>(consulta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/getConsultas")
    public ResponseEntity<List<RecetasDTO>> getConsultas(@RequestParam(name = "idPaciente") Integer idPaciente) {
        List<RecetasVO> listaConsultas = recetasService.findByIdPatient(new PacienteVO(idPaciente));
        if(listaConsultas.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(RecetasDTO.getDTOListFromVOList(listaConsultas), HttpStatus.OK);
        }
    }

    @PostMapping("/updateConsulta")
    public ResponseEntity<Integer> updateConsulta(@RequestBody UpdateConsultaReq consultaReq) {
        ConsultasVO consultas = new ConsultasVO();
        consultas.setIdConsulta(consultaReq.getIdConsulta());
        consultas.setDiagnostico(consultaReq.getDiagnostico());
        ConsultasVO consultaUpdate = consultasService.updateConsultaById(consultas);
        if (consultaUpdate != null) {
            return new ResponseEntity<>((int) consultaUpdate.getIdConsulta(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/generaReceta")
    public ResponseEntity<PDFResponse> generarReceta(@RequestBody MedicamentosRecetadosReq request) {
        PDFResponse responsePDF = new PDFResponse();
        ConsultasVO consulta = consultasService.getConsultaById(request.getId_consulta().longValue());
        if (consulta != null) {
            List<RecetasVO> listaRecetas = recetasService.getAll();
            Integer pk = 1;
            String folio = "";
            if (listaRecetas.isEmpty()) {
                folio = Utilities.generateFolio(pk);
            } else {
                RecetasVO receta = Utilities.getLastElementOfList(listaRecetas, "getFechaCreacion");
                if (receta != null) {
                    folio = Utilities.generateFolio(receta.getIdReceta());
                } else {
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
            RecetasVO receta = new RecetasVO();
            receta.setIdConsulta(consulta);
            receta.setIdPaciente(consulta.getIdPaciente());
            receta.setReceta(folio);
            receta.setFechaCreacion(new Date(System.currentTimeMillis()));
            PDFUtils pdf = new PDFUtils();
            String base64File = pdf.fillPrescriptionPDF(consulta.getIdPaciente(), consulta, request.getMedicamentos(), folio,request.getSessionData());
            receta.setReceta(base64File);            
            if (base64File != null && !base64File.isEmpty()) {
                recetasService.addReceipt(receta);
                responsePDF.setReceta(base64File);
                responsePDF.setConcentimiento(pdf.fillConsenPDF(consulta.getIdPaciente(), consulta, request.getSessionData()));
                return new ResponseEntity<>(responsePDF, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
