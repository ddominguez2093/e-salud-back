/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package mx.com.eldatech.esalud.controllers;

import java.util.List;
import mx.com.eldatech.esalud.dao.Cie10Service;
import mx.com.eldatech.esalud.vo.CatCie10VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ddomi
 */
@RestController
@RequestMapping("/cat-cie10-controller")
public class Cie10Controller {
    
    @Autowired
    private Cie10Service cie10Service;
    
    @PostMapping("/getCie10Like")
    public ResponseEntity<List<CatCie10VO>> getCie10Like(@RequestParam(name = "nombre") String nombre) {
        List<CatCie10VO> listaCat = cie10Service.getCatCie10Like("%"+nombre+"%");
        if(listaCat != null) {
            return new ResponseEntity<>(listaCat,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/getAllCie10")
    public ResponseEntity<List<CatCie10VO>> getAllCie10() {
        List<CatCie10VO> listaCat = cie10Service.getAllCie10VOs();
        if(listaCat != null) {
            return new ResponseEntity<>(listaCat,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
