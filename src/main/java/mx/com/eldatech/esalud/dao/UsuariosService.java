/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.eldatech.esalud.dao;

import java.util.List;
import mx.com.eldatech.esalud.security.DataHashing;
import mx.com.eldatech.esalud.utils.Utilities;
import mx.com.eldatech.esalud.vo.UsuariosVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ddomi
 */
@Service
public class UsuariosService {
    
    private final UsuariosRepo usuariosRepo;
    
    @Autowired
    public UsuariosService(UsuariosRepo repo) {
        usuariosRepo = repo;
    }
    
    public List<UsuariosVO> getAllUsers() {
        return usuariosRepo.findAll();
    }
    
    public UsuariosVO getUserByName(String name) {
        return usuariosRepo.findByNombreUsuario(name);
    }
    
    public UsuariosVO getUserById(Long id) {
        return usuariosRepo.findById(id).orElse(null);
    }
    
    public UsuariosVO createUser(UsuariosVO usuarios) {
        String pass = usuarios.getContrasena();
        pass = DataHashing.hashPassword(pass);
        usuarios.setContrasena(pass);
        return usuariosRepo.save(usuarios);
    }
    
    public UsuariosVO resetPassword(Long idUsuario, String contrasena) {
        UsuariosVO userSearch = this.usuariosRepo.findById(idUsuario).orElse(null);
        if (userSearch != null) {
            String hashedPassword = DataHashing.hashPassword(contrasena);
            userSearch.setContrasena(hashedPassword);
            this.usuariosRepo.save(userSearch);
            return userSearch;
        } else {
            return null;
        }
    }
    
    public void deleteUser(Long id) {
        usuariosRepo.deleteById(id);
    }
    
}
