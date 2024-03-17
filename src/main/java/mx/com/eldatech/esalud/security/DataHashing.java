/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.eldatech.esalud.security;

import org.mindrot.jbcrypt.BCrypt;
/**
 *Clase para el hashing de una contraseña
 * 
 * @author Daniel Dominguez
 */
public class DataHashing {
    
    /**
     * Genera una cadena aleatoria para el hasheado de la contraseña
     * 
     * @param password
     * @return la contraseña hasheada
     */
    public static String hashPassword(String password){
        String salt = BCrypt.gensalt();
        return BCrypt.hashpw(password, salt);
    }
    
    /**
     *Verifica que el password sea correcto 
     * 
     * @param password
     * @param hashedPassword
     * @return true si la contraseña es valida y false si no
     */
    public static boolean verifyPass(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }                

}
