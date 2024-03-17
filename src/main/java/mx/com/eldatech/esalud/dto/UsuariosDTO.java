/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.eldatech.esalud.dto;

import java.util.ArrayList;
import java.util.List;
import mx.com.eldatech.esalud.vo.UsuariosVO;

/**
 *
 * @author ddomi UsuariosVO Transformation class
 */
public class UsuariosDTO {

    private Integer idUsuario;
    private Integer idMedico;
    private Integer idPerfil;
    private String nombreUsuario;
    private String nombrePerfil;
    private String nombreMedico;
    private String especialidad;
    private String almaMater;
    private String cedulaProfesional;
    private String correo;
    private String password;

    public UsuariosDTO() {
    }

    public UsuariosDTO(UsuariosVO usuario) {
        this.idUsuario = usuario.getIdUsuario();
        this.idMedico = usuario.getIdMedico().getIdMedico();
        this.nombreUsuario = usuario.getNombreUsuario();
        this.idPerfil = usuario.getIdPerfil().getIdPerfil();
        this.nombrePerfil = usuario.getIdPerfil().getPerfil();
        this.nombreMedico = usuario.getIdMedico().getNombre();
        this.especialidad = usuario.getIdMedico().getEspecialidad();
        this.almaMater = usuario.getIdMedico().getAlmaMater();
        this.cedulaProfesional = usuario.getIdMedico().getCedulaProfesional();
        this.correo = usuario.getIdMedico().getCorreo();
    }
    
    public static List<UsuariosDTO> getDTOListFromVO(List<UsuariosVO> usuarios) {
        List<UsuariosDTO> listaUsuariosDTO = new ArrayList<>();
        for(UsuariosVO usuarioVO : usuarios) {
            listaUsuariosDTO.add(new UsuariosDTO(usuarioVO));
        }
        return listaUsuariosDTO;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombrePerfil() {
        return nombrePerfil;
    }

    public void setNombrePerfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getAlmaMater() {
        return almaMater;
    }

    public void setAlmaMater(String almaMater) {
        this.almaMater = almaMater;
    }

    public String getCedulaProfesional() {
        return cedulaProfesional;
    }

    public void setCedulaProfesional(String cedulaProfesional) {
        this.cedulaProfesional = cedulaProfesional;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
