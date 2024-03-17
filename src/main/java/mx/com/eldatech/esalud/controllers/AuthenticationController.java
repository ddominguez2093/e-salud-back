/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package mx.com.eldatech.esalud.controllers;

import jakarta.servlet.http.HttpServletResponse;
import mx.com.eldatech.esalud.dao.UsuariosService;
import mx.com.eldatech.esalud.security.CookieUtils;
import mx.com.eldatech.esalud.security.DataHashing;
import mx.com.eldatech.esalud.security.Token;
import mx.com.eldatech.esalud.vo.SessionData;
import mx.com.eldatech.esalud.vo.UsuariosVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
@RequestMapping("/login-controller")
public class AuthenticationController {

    private UsuariosService usuarioService;    
    @Value("${application.jwk}")
    private String jwk;
    @Value("${application.cipher.key}")
    private String cipherKey;
    
    @Autowired
    public AuthenticationController(UsuariosService usuariosService) {
        this.usuarioService = usuariosService;
    }

    @PostMapping("/login")
    public ResponseEntity<SessionData> login(@RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password, HttpServletResponse response) {
        UsuariosVO userFind = this.usuarioService.getUserByName(username);
        if (userFind != null) {
            if (DataHashing.verifyPass(password, userFind.getContrasena())) {
                Token token = new Token(jwk,cipherKey);
                String tkn = token.getToken(username);
                CookieUtils cookieUtils = new CookieUtils(cipherKey);
                cookieUtils.setCookie(response, tkn);
                SessionData data = new SessionData(userFind);
                return new ResponseEntity<>(data, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
            }
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<Boolean> logout(HttpServletResponse response) {
        CookieUtils cookieUtils = new CookieUtils(cipherKey);
        cookieUtils.removeCookie(response);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
