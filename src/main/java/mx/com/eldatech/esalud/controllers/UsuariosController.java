/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package mx.com.eldatech.esalud.controllers;

import java.util.ArrayList;
import java.util.List;
import mx.com.eldatech.esalud.dao.MedicosService;
import mx.com.eldatech.esalud.dao.UsuariosService;
import mx.com.eldatech.esalud.dto.UsuariosDTO;
import mx.com.eldatech.esalud.security.DataHashing;
import mx.com.eldatech.esalud.utils.Utilities;
import mx.com.eldatech.esalud.vo.AddUserRequest;
import mx.com.eldatech.esalud.vo.MedicosVO;
import mx.com.eldatech.esalud.vo.PerfilesVO;
import mx.com.eldatech.esalud.vo.UsuariosVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author ddomi
 */
@RestController
@RequestMapping("/usuarios-controller")
public class UsuariosController {

    private static final Logger logger = LogManager.getLogger(UsuariosController.class);

    @Autowired
    private UsuariosService usuariosService;
    @Autowired
    private MedicosService medicosService;

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError(Exception ex) {
        logger.error("Ocurrio un error en UsuariosController", ex);
        logger.error(ex.getLocalizedMessage());
    }

    @GetMapping("/getUsers")
    public ResponseEntity<List<UsuariosDTO>> getUsers() {
        List<UsuariosVO> listaUsuarios = this.usuariosService.getAllUsers();
        List<UsuariosDTO> listaUsuariosDTO;
        if (!listaUsuarios.isEmpty()) {
            listaUsuariosDTO = UsuariosDTO.getDTOListFromVO(listaUsuarios);
            return new ResponseEntity(listaUsuariosDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/inserUser")
    public ResponseEntity<UsuariosDTO> insertUser(@RequestBody AddUserRequest request) {
        MedicosVO medico = new MedicosVO(0, request.getAlmaMater(), request.getCedulaProfesional(), request.getCorreo(), request.getEspecialidad(), request.getNombreMedico(), request.getHorario());
        MedicosVO medicoInsert = medicosService.createMed(medico);
        if (medicoInsert != null) {
            String password = Utilities.generatePassword();
            PerfilesVO perfiles = new PerfilesVO(request.getPerfil());
            UsuariosVO user = new UsuariosVO(password, Utilities.getUserFromEmail(request.getCorreo()));
            user.setIdPerfil(perfiles);
            user.setIdMedico(medicoInsert);
            UsuariosVO userInsert = usuariosService.createUser(user);
            if (userInsert != null) {
                UsuariosDTO usuarioDTO = new UsuariosDTO(user);
                usuarioDTO.setPassword(password);
                return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/resetPassword")
    public ResponseEntity<UsuariosDTO> resetPassword(@RequestParam(name = "idUsuario") Integer idUsuario, @RequestParam(name = "contrasena") String contrasena) {
        UsuariosVO userUpdate = usuariosService.resetPassword(idUsuario.longValue(),contrasena);
        if (userUpdate != null) {       
            UsuariosDTO userDTO = new UsuariosDTO(userUpdate);
            userDTO.setPassword(userUpdate.getContrasena());
            return new ResponseEntity<>(userDTO,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/deleteUser")
    public ResponseEntity<Boolean> deleteUser(@RequestParam(name = "idUsuario") Integer idUsuario, @RequestParam(name = "idMedico") Integer idMedico) {
        usuariosService.deleteUser(idUsuario.longValue());
        medicosService.deleteMed(idMedico.longValue());
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
