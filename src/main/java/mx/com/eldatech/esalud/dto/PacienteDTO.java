/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.eldatech.esalud.dto;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mx.com.eldatech.esalud.vo.PacienteVO;

/**
 *
 * @author ddomi
 */
public class PacienteDTO {

    private Integer idPaciente;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String genero;
    private String fechaNacimiento;
    private String alergias;
    private String fotografia;
    private String observaciones;
    private String direccion;
    private String pais;
    private String estado;
    private String ciudad;
    private String codigoPostal;
    private String grupoEtnico;
    private String fechaRegistro;
    private Integer idMedico;
    private String nombreMedico;
    private String edad;

    public PacienteDTO(PacienteVO paciente) {
        this.idPaciente = paciente.getIdPaciente();
        this.nombre = paciente.getNombre();
        this.apellidoPaterno = paciente.getApellidoPaterno();
        this.apellidoMaterno = paciente.getApellidoMaterno();
        this.genero = paciente.getGenero();
        this.fechaNacimiento = paciente.getFechaNacimiento();
        this.alergias = paciente.getAlergias();
        this.fotografia = paciente.getFotografia();
        this.observaciones = paciente.getObservaciones();
        this.direccion = paciente.getDireccion();
        this.pais = paciente.getPais();
        this.estado = paciente.getEstado();
        this.ciudad = paciente.getCiudad();
        this.codigoPostal = paciente.getCodigoPostal();
        this.grupoEtnico = paciente.getGrupoEtnico();
        this.fechaRegistro = paciente.getFechaRegistroFor();
        this.idMedico = paciente.getIdMedico().getIdMedico();
        this.nombreMedico = paciente.getIdMedico().getNombre();
        this.edad = getAgeFromBirthDate(this.fechaNacimiento);
    }

    public static List<PacienteDTO> getListDTOFromVO(List<PacienteVO> patientList) {
        List<PacienteDTO> listaPacientesDTO = new ArrayList<>();
        for (PacienteVO patient : patientList) {
            listaPacientesDTO.add(new PacienteDTO(patient));
        }
        return listaPacientesDTO;
    }

    private String getAgeFromBirthDate(String fechaNacimiento) {
        LocalDate fechaNacimientoLocal = parseToLocalDate(fechaNacimiento);
        LocalDate fechaActual = LocalDate.now();
        Period periodo = calculatePeriod(fechaNacimientoLocal, fechaActual);

        if (isUnderOneYear(periodo)) {
            return formatAgeUnderOneYear(periodo);
        } else {
            return formatAgeOverOneYear(periodo);
        }
    }

    private LocalDate parseToLocalDate(String fechaNacimiento) {
        String[] partesFecha = fechaNacimiento.split("/");
        int dia = Integer.parseInt(partesFecha[0]);
        int mes = Integer.parseInt(partesFecha[1]);
        int año = Integer.parseInt(partesFecha[2]);
        return LocalDate.of(año, mes, dia);
    }

    private Period calculatePeriod(LocalDate fechaNacimiento, LocalDate fechaActual) {
        return Period.between(fechaNacimiento, fechaActual);
    }

    private boolean isUnderOneYear(Period periodo) {
        return periodo.getYears() < 1;
    }

    private String formatAgeUnderOneYear(Period periodo) {
        int meses = periodo.getMonths();
        int días = periodo.getDays();

        String edadConcatenada = "";
        if (meses > 0) {
            edadConcatenada += meses + " Mes";
            if (meses > 1) {
                edadConcatenada += "es";
            }
            if (días > 0) {
                edadConcatenada += " y ";
            }
        }
        if (días > 0) {
            edadConcatenada += días + " Día";
            if (días > 1) {
                edadConcatenada += "s";
            }
        }
        return edadConcatenada;
    }

    private String formatAgeOverOneYear(Period periodo) {
        int años = periodo.getYears();
        String edadConcatenada = años + " Año";
        if (años > 1) {
            edadConcatenada += "s";
        }
        return edadConcatenada;
    }

    public PacienteDTO() {

    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setCorreo(String alergias) {
        this.alergias = alergias;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getGrupoEtnico() {
        return grupoEtnico;
    }

    public void setGrupoEtnico(String grupoEtnico) {
        this.grupoEtnico = grupoEtnico;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
}
