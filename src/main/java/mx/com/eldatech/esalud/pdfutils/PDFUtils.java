/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.eldatech.esalud.pdfutils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import mx.com.eldatech.esalud.utils.Utilities;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import mx.com.eldatech.esalud.vo.ConsultasVO;
import mx.com.eldatech.esalud.vo.MedicamentosRecetadosVO;
import mx.com.eldatech.esalud.vo.PacienteVO;
import mx.com.eldatech.esalud.vo.SessionData;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.font.encoding.WinAnsiEncoding;

/**
 *
 * @author ddomi
 */
public class PDFUtils {

    private static final Logger logger = LogManager.getLogger(PDFUtils.class);
    private static final String desktopPath = System.getProperty("user.home") + "\\Pacientes\\";
    private static final String desktopMacPath = System.getProperty("user.home") + "/Pacientes";

    public String fillConsenPDF(PacienteVO paciente, ConsultasVO consulta, SessionData sessionData) {
        File f = new File("CONSENTIMIENTO.pdf");
        String base64File = "";
        try {
            PDDocument documento = Loader.loadPDF(f);
            PDPage page = documento.getPage(0);
            PDPageContentStream contentStream = new PDPageContentStream(documento, page,
                    PDPageContentStream.AppendMode.APPEND, true, true);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDateTime now = LocalDateTime.now();
            String today = dtf.format(now);            
            //NOMBRE PACIENTE
            addTextBold(179, 710, paciente.getNombre() + " " + paciente.getApellidoPaterno() + " " + paciente.getApellidoMaterno(), contentStream);
            //fecha
            addTextBold(445, 710,today , contentStream);
            //edad
            addTextBold(103, 683,calculaEdad(paciente.getFechaNacimiento()).toString() , contentStream);
            //sexo
            addTextBold(444, 683,paciente.getGenero().toUpperCase(), contentStream);
            //Nombre Medico 1
            addTextBold(174, 657,sessionData.getNombreMedico().toUpperCase(), contentStream);
            //especialidad
            addTextBold(447, 657,sessionData.getEspecialidad().toUpperCase(), contentStream);
            //diagnostico
            addTextBold(135, 630, consulta.getDiagnostico(), contentStream);
            //nombre2
            addTextBold(91, 237, paciente.getNombre() + " " + paciente.getApellidoPaterno() + " " + paciente.getApellidoMaterno(), contentStream);
            //nombre med 2
            addTextBold(113, 200, sessionData.getNombreMedico().toUpperCase(), contentStream);
            String desktopFilePath = "";
            if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                desktopFilePath = desktopMacPath + "consentimiento_" +paciente.getNombre() + ".pdf";
            } else {
                desktopFilePath = desktopPath + "consentimiento_"  +paciente.getNombre() + ".pdf";
            }
            contentStream.close();
            documento.save(desktopFilePath.trim());
            documento.close();
            File edited = new File(desktopFilePath.trim());
            byte[] bytesArchivo = FileUtils.readFileToByteArray(edited);
            base64File = Base64.getEncoder().encodeToString(bytesArchivo);
        } catch (Exception e) {
            logger.error("Ocurrio un error al crear el pdf: " + e.getMessage());
            e.printStackTrace();
        }
        return base64File;
    }

    public String fillPrescriptionPDF(PacienteVO paciente, ConsultasVO consulta, List<MedicamentosRecetadosVO> listaMedicamentos, String folio, SessionData sessionData) {
        File f = new File("FORMATO_RECETA.pdf");
        String base64File = "";
        try {
            String nombreDoctor = "Dr.(a) " + sessionData.getNombreMedico();
            PDDocument documento = Loader.loadPDF(f);
            PDPage page = documento.getPage(0);
            PDPageContentStream contentStream = new PDPageContentStream(documento, page,
                    PDPageContentStream.AppendMode.APPEND, true, true);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDateTime now = LocalDateTime.now();
            String today = dtf.format(now);
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            //agregar nombre Medico
            addTextBold(250, 740, nombreDoctor, contentStream);
            addTextBold(250, 342, nombreDoctor, contentStream);
            //Especialidad                
            addTextBold(85, 330, "Especialidad: " + sessionData.getEspecialidad(), contentStream);
            addTextBold(85, 725, "Especialidad: " + sessionData.getEspecialidad(), contentStream);
            //Cedula Profesional
            addTextBold(458, 330, "Cedula Profesional: " + sessionData.getCedulaProfesional(), contentStream);
            addTextBold(458, 725, "Cedula Profesional: " + sessionData.getCedulaProfesional(), contentStream);
            //Agregar folio
            addText(535, 359, folio, contentStream);
            addText(535, 752, folio, contentStream);
            // Agregar Fecha Actual a ambas hojas
            addText(535, 344, today, contentStream);
            addText(535, 737, today, contentStream);
            //nombre del paciente
            addText(81, 303, paciente.getNombre(), contentStream);
            addText(81, 697, paciente.getNombre(), contentStream);
            //apellido paterno
            addText(273, 303, paciente.getApellidoPaterno(), contentStream);
            addText(273, 697, paciente.getApellidoPaterno(), contentStream);
            //apellido materno
            addText(498, 303, paciente.getApellidoMaterno(), contentStream);
            addText(498, 697, paciente.getApellidoMaterno(), contentStream);
            //sexo
            addText(60, 286, paciente.getGenero(), contentStream);
            addText(60, 681, paciente.getGenero(), contentStream);
            //edad
            addText(224, 286, calculaEdad(paciente.getFechaNacimiento()).toString(), contentStream);
            addText(224, 681, calculaEdad(paciente.getFechaNacimiento()).toString(), contentStream);
            //fecha nacimiento
            addText(515, 286, paciente.getFechaNacimiento(), contentStream);
            addText(515, 681, paciente.getFechaNacimiento(), contentStream);
            //peso
            addText(58, 266, consulta.getPeso() + "", contentStream);
            addText(58, 661, consulta.getPeso() + "", contentStream);
            //talla
            addText(64, 255, consulta.getTalla() + "", contentStream);
            addText(64, 650, consulta.getTalla() + "", contentStream);
            //f
            addText(48, 244, consulta.getFrecuenciaCardiaca(), contentStream);
            addText(48, 639, consulta.getFrecuenciaCardiaca(), contentStream);
            //fr
            addText(48, 233, consulta.getFrecuenciaCardiaca(), contentStream);
            addText(48, 628, consulta.getFrecuenciaCardiaca(), contentStream);
            //tem
            addText(59, 222, consulta.getTemperatura(), contentStream);
            addText(59, 616, consulta.getTemperatura(), contentStream);
            //TA
            addText(48, 211, consulta.getTensionArterial(), contentStream);
            addText(48, 605, consulta.getTensionArterial(), contentStream);
            //SAT
            addText(59, 200, consulta.getSaturacionOxigeno(), contentStream);
            addText(59, 595, consulta.getSaturacionOxigeno(), contentStream);
            //GLU
            addText(59, 190, consulta.getGlucosa(), contentStream);
            addText(59, 584, consulta.getGlucosa(), contentStream);
            //FUM
            addText(53, 178, consulta.getFum(), contentStream);
            addText(53, 573, consulta.getFum(), contentStream);
            //alergias
            addText(32, 157, consulta.getAlergias(), contentStream);
            addText(32, 552, consulta.getAlergias(), contentStream);
            //diagnostico
            addText(31, 113, consulta.getDiagnostico(), contentStream);
            addText(31, 507, consulta.getDiagnostico(), contentStream);
            //horarioMedico
            addTextBold(240,425,sessionData.getHorario(),contentStream);
            addTextBold(240,30,sessionData.getHorario(),contentStream);
            Integer posInMedX = 120;
            Integer posInMedY = 265;
            Integer posInMedX2 = 120;
            Integer posInMedY2 = 656;
            int contador = 1;
            for (MedicamentosRecetadosVO medicamento : listaMedicamentos) {
                addTextBold(posInMedX, posInMedY, contador + ".-" + medicamento.getMedicamento(), contentStream);
                addTextBold(posInMedX2, posInMedY2, contador + ".-" + medicamento.getMedicamento(), contentStream);
                addText(posInMedX, posInMedY - 11, medicamento.getIndicacion(), contentStream);
                addText(posInMedX2, posInMedY2 - 11, medicamento.getIndicacion(), contentStream);
                posInMedY = posInMedY - 21;
                posInMedY2 = posInMedY2 - 21;
                contador++;
            }
            String desktopFilePath = "";
            if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                desktopFilePath = desktopMacPath + paciente.getNombre() + ".pdf";
            } else {
                desktopFilePath = desktopPath + paciente.getNombre() + ".pdf";
            }

            contentStream.close();
            documento.save(desktopFilePath.trim());
            documento.close();

            File edited = new File(desktopFilePath.trim());
            byte[] bytesArchivo = FileUtils.readFileToByteArray(edited);
            base64File = Base64.getEncoder().encodeToString(bytesArchivo);
        } catch (Exception e) {
            logger.error("Ocurrio un error al crear el pdf: " + e.getMessage());
            e.printStackTrace();
        }
        return base64File;
    }

    private static void addTextBold(Integer x, Integer y, String text, PDPageContentStream contentStream)
            throws IOException {
        text = remove(text);
        contentStream.beginText();
        contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 8);
        contentStream.newLineAtOffset(x, y);
        contentStream.showText(text);
        contentStream.endText();
    }

    private static void addText(Integer x, Integer y, String text, PDPageContentStream contentStream)
            throws IOException {
        text = remove(text);
        contentStream.beginText();
        contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8);
        contentStream.newLineAtOffset(x, y);
        contentStream.showText(text);
        contentStream.endText();
    }

    private static String remove(String test) {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < test.length(); i++) {
            if (WinAnsiEncoding.INSTANCE.contains(test.charAt(i))) {
                b.append(test.charAt(i));
            }
        }
        return b.toString();
    }

    private static Integer calculaEdad(String fNac) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            // Parsear la cadena a un objeto Date
            Date fechaNacimiento = sdf.parse(fNac);

            // Obtener la fecha actual
            Date fechaActual = new Date();

            // Crear objetos Calendar para calcular la diferencia
            Calendar calendarNacimiento = Calendar.getInstance();
            Calendar calendarActual = Calendar.getInstance();
            calendarNacimiento.setTime(fechaNacimiento);
            calendarActual.setTime(fechaActual);

            // Calcular la diferencia de años
            int edad = calendarActual.get(Calendar.YEAR) - calendarNacimiento.get(Calendar.YEAR);

            // Comprobar si el cumpleaños ya pasó en el año actual
            if (calendarActual.get(Calendar.DAY_OF_YEAR) < calendarNacimiento.get(Calendar.DAY_OF_YEAR)) {
                edad--;
            }
            return edad;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
