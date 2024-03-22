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
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
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
            addTextWithOverflow(179, 710, paciente.getNombre() + " " + paciente.getApellidoPaterno() + " " + paciente.getApellidoMaterno(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            //fecha
            addTextWithOverflow(445, 710, today, contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            //edad
            addTextWithOverflow(103, 683, calculaEdad(paciente.getFechaNacimiento()).toString(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            //sexo
            addTextWithOverflow(444, 683, paciente.getGenero().toUpperCase(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            //Nombre Medico 1
            addTextWithOverflow(174, 657, sessionData.getNombreMedico().toUpperCase(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            //especialidad
            addTextWithOverflow(447, 657, sessionData.getEspecialidad().toUpperCase(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            //diagnostico
            addTextWithOverflow(135, 630, consulta.getDiagnostico(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            //nombre2
            addTextWithOverflow(91, 237, paciente.getNombre() + " " + paciente.getApellidoPaterno() + " " + paciente.getApellidoMaterno(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            //nombre med 2
            addTextWithOverflow(113, 200, sessionData.getNombreMedico().toUpperCase(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            String desktopFilePath = "";
            if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                desktopFilePath = desktopMacPath + "consentimiento_" + paciente.getNombre() +"_"+System.currentTimeMillis() +".pdf";
            } else {
                desktopFilePath = desktopPath + "consentimiento_" + paciente.getNombre() +"_"+System.currentTimeMillis() + ".pdf";
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
            addTextWithOverflow(250, 750, nombreDoctor, contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 8, page.getMediaBox());
            addTextWithOverflow(250, 355, nombreDoctor, contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 8, page.getMediaBox());
            //alma mater
            if (sessionData.getAlmaMater().length() > 35 && sessionData.getAlmaMater().length() < 39) {
                addTextWithOverflow(235, 740, sessionData.getAlmaMater(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 8, page.getMediaBox());
                addTextWithOverflow(235, 345, sessionData.getAlmaMater(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 8, page.getMediaBox());
            } else if(sessionData.getAlmaMater().length() > 39) {
                addTextWithOverflow(230, 740, sessionData.getAlmaMater(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 8, page.getMediaBox());
                addTextWithOverflow(230, 345, sessionData.getAlmaMater(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 8, page.getMediaBox());
            } else {
                addTextWithOverflow(248, 740, sessionData.getAlmaMater(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 8, page.getMediaBox());
                addTextWithOverflow(248, 345, sessionData.getAlmaMater(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 8, page.getMediaBox());
            }
            //Especialidad                
            addTextWithOverflow(85, 330, "Especialidad: " + sessionData.getEspecialidad(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 8, page.getMediaBox());
            addTextWithOverflow(85, 725, "Especialidad: " + sessionData.getEspecialidad(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 8, page.getMediaBox());
            //Cedula Profesional
            addTextWithOverflow(458, 330, "Cedula Profesional: " + sessionData.getCedulaProfesional(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 8, page.getMediaBox());
            addTextWithOverflow(458, 725, "Cedula Profesional: " + sessionData.getCedulaProfesional(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 8, page.getMediaBox());
            //Agregar folio
            addText(533, 360, folio, contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            addText(533, 754, folio, contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            // Agregar Fecha Actual a ambas hojas
            addText(533, 347, today, contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            addText(533, 738, today, contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            //nombre del paciente
            addText(81, 303, paciente.getNombre(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            addText(81, 697, paciente.getNombre(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            //apellido paterno
            addText(273, 303, paciente.getApellidoPaterno(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            addText(273, 697, paciente.getApellidoPaterno(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            //apellido materno
            addText(498, 303, paciente.getApellidoMaterno(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            addText(498, 697, paciente.getApellidoMaterno(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            //sexo
            addText(60, 286, paciente.getGenero(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            addText(60, 681, paciente.getGenero(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            //edad
            addText(224, 286, Utilities.getAgeFromBirthDate(paciente.getFechaNacimiento()), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            addText(224, 681, Utilities.getAgeFromBirthDate(paciente.getFechaNacimiento()), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            //fecha nacimiento
            addText(515, 286, paciente.getFechaNacimiento(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            addText(515, 681, paciente.getFechaNacimiento(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            //peso
            addText(58, 266, consulta.getPeso() + "", contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            addText(58, 661, consulta.getPeso() + "", contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            //talla
            addText(64, 255, consulta.getTalla() + "", contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            addText(64, 650, consulta.getTalla() + "", contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            //f
            addText(48, 244, consulta.getFrecuenciaCardiaca(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            addText(48, 639, consulta.getFrecuenciaCardiaca(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            //fr
            addText(48, 233, consulta.getFrecuenciaRespiratoria(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            addText(48, 628, consulta.getFrecuenciaRespiratoria(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            //tem
            addText(59, 222, consulta.getTemperatura(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            addText(59, 616, consulta.getTemperatura(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            //TA
            addText(48, 211, consulta.getTensionArterial(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            addText(48, 605, consulta.getTensionArterial(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            //SAT
            addText(59, 200, consulta.getSaturacionOxigeno(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            addText(59, 595, consulta.getSaturacionOxigeno(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            //GLU
            addText(59, 190, consulta.getGlucosa(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            addText(59, 584, consulta.getGlucosa(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            //FUM
            addText(53, 178, consulta.getFum(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            addText(53, 573, consulta.getFum(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            //alergias
            addText(32, 157, consulta.getAlergias(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            addText(32, 552, consulta.getAlergias(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            //diagnostico
            addText(31, 113, consulta.getDiagnostico(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            addText(31, 507, consulta.getDiagnostico(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
            //horarioMedico
            addTextWithOverflow(240, 425, sessionData.getHorario(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 8, page.getMediaBox());
            addTextWithOverflow(240, 30, sessionData.getHorario(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 8, page.getMediaBox());
            float posInMedX = 120;
            float posInMedY = 268;
            float posInMedX2 = 120;
            float posInMedY2 = 657;
            int contador = 1;
            for (MedicamentosRecetadosVO medicamento : listaMedicamentos) {
                posInMedY = addTextWithOverflow(posInMedX, posInMedY, contador + ".-" + medicamento.getMedicamento(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 8, page.getMediaBox());
                posInMedY2 = addTextWithOverflow(posInMedX2, posInMedY2, contador + ".-" + medicamento.getMedicamento(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 8, page.getMediaBox());
                addText(posInMedX, posInMedY, medicamento.getIndicacion(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
                addText(posInMedX2, posInMedY2, medicamento.getIndicacion(), contentStream, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8, page.getMediaBox());
                posInMedY = posInMedY - 21;
                posInMedY2 = posInMedY2 - 21;
                contador++;
            }
            String desktopFilePath = "";
            if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                desktopFilePath = desktopMacPath + paciente.getNombre() + ".pdf";
            } else {
                desktopFilePath = desktopPath + paciente.getNombre() +"_"+System.currentTimeMillis() +".pdf";
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

    private float addTextWithOverflow(float x, float y, String text, PDPageContentStream contentStream, PDFont font, int fontSize, PDRectangle pageSize) throws IOException {
        float leading = 1.5f * fontSize; // Espaciado entre líneas
        float availableSpace = pageSize.getUpperRightX() - x; // Espacio disponible en el eje X

        String[] words = text.split("\\s+"); // Divide el texto en palabras
        StringBuilder line = new StringBuilder();

        for (String word : words) {
            float width = font.getStringWidth(line.toString() + " " + word) / 1000 * fontSize;
            if (width > availableSpace) {
                // Si la palabra actual excede el espacio disponible, escribe la línea actual y comienza una nueva
                contentStream.beginText();
                contentStream.setFont(font, fontSize);
                contentStream.newLineAtOffset(x, y);
                contentStream.showText(line.toString());
                contentStream.endText();

                // Restablece las variables para la nueva línea
                line = new StringBuilder(word);
                y -= leading;
                availableSpace = pageSize.getUpperRightX() - x - leading; // Recalcula el espacio disponible en X para la nueva línea
            } else {
                // Agrega la palabra al texto actual
                line.append(" ").append(word);
            }
        }

        // Escribe la última línea
        contentStream.beginText();
        contentStream.setFont(font, fontSize);
        contentStream.newLineAtOffset(x, y);
        contentStream.showText(line.toString());
        contentStream.endText();

        // Devuelve la nueva posición Y
        return y - leading;
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

    private static void addText(float x, float y, String text, PDPageContentStream contentStream, PDFont font, int fontSize, PDRectangle pageSize)
            throws IOException {
        float leading = 1.5f * fontSize; // Espaciado entre líneas
        float availableSpace = pageSize.getUpperRightX() - x; // Espacio disponible en el eje X

        String[] words = text.split("\\s+"); // Divide el texto en palabras
        StringBuilder line = new StringBuilder();

        for (String word : words) {
            float width = font.getStringWidth(line.toString() + " " + word) / 1000 * fontSize;
            if (width > availableSpace) {
                // Si la palabra actual excede el espacio disponible, escribe la línea actual y comienza una nueva
                contentStream.beginText();
                contentStream.setFont(font, fontSize);
                contentStream.newLineAtOffset(x, y);
                contentStream.showText(line.toString());
                contentStream.endText();

                // Restablece las variables para la nueva línea
                line = new StringBuilder(word);
                y -= leading;
                availableSpace = pageSize.getUpperRightX() - x - leading; // Recalcula el espacio disponible en X para la nueva línea
            } else {
                // Agrega la palabra al texto actual
                line.append(" ").append(word);
            }
        }

        // Escribe la última línea
        contentStream.beginText();
        contentStream.setFont(font, fontSize);
        contentStream.newLineAtOffset(x, y);
        contentStream.showText(line.toString());
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
