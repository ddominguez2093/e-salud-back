/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.eldatech.esalud.vo;

/**
 *
 * @author ddomi
 */
public class SessionData {

    private String nombreMedico;
    private String especialidad;
    private String cedulaProfesional;
    private String almaMater;
    private String correo;
    private Integer idPerfil;
    private String genero;
    private Integer idUsuario;
    private Integer idMedico;
    private String horario;

    public SessionData() {

    }

    public SessionData(UsuariosVO usuario) {
        this.nombreMedico = usuario.getIdMedico().getNombre();
        this.especialidad = usuario.getIdMedico().getEspecialidad();
        this.cedulaProfesional = usuario.getIdMedico().getCedulaProfesional();
        this.almaMater = usuario.getIdMedico().getAlmaMater();
        this.correo = usuario.getIdMedico().getCorreo();
        this.idPerfil = usuario.getIdPerfil().getIdPerfil();
        this.horario = usuario.getIdMedico().getHorario();
        this.idUsuario = usuario.getIdUsuario();
        this.idMedico = usuario.getIdMedico().getIdMedico();        
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

    public String getCedulaProfesional() {
        return cedulaProfesional;
    }

    public void setCedulaProfesional(String cedulaProfesional) {
        this.cedulaProfesional = cedulaProfesional;
    }

    public String getAlmaMater() {
        return almaMater;
    }

    public void setAlmaMater(String almaMater) {
        this.almaMater = almaMater;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
