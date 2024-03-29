/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.eldatech.esalud.utils;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import java.security.SecureRandom;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import mx.com.eldatech.esalud.security.CookieUtils;

/**
 *
 * @author ddomi
 */
public class Utilities {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$&*";
    private static final int PASSWORD_LENGTH = 8;

    private Utilities() {
    }

    public static String getUserFromEmail(String email) {
        String username = email.substring(0, email.indexOf('@'));
        if (username != null) {
            return username;
        } else {
            return null;
        }
    }

    public static String generatePassword() {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            password.append(CHARACTERS.charAt(randomIndex));
        }

        return password.toString();
    }

    public static <T> T getLastElementOfList(List<T> lista, String nombreMetodoFecha) {
        if (lista == null || lista.isEmpty()) {
            return null;
        }
        long fechaMasReciente = 0;
        T elementoMasReciente = null;
        try {
            for (T elemento : lista) {
                java.lang.reflect.Method metodoFecha = elemento.getClass().getMethod(nombreMetodoFecha);
                Timestamp fechaElemento = (Timestamp) metodoFecha.invoke(elemento);
                long timestamp = fechaElemento.getTime(); // Obtener la fecha en milisegundos
                if (timestamp > fechaMasReciente) {
                    fechaMasReciente = timestamp;
                    elementoMasReciente = elemento;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return elementoMasReciente;
    }

    public static String generateFolio(int pk) {
        // Convertir el entero a una cadena
        String llaveString = String.valueOf(pk);
        // Calcular cuántos ceros necesitamos agregar
        int longitudTotal = 5; // Longitud total deseada
        int longitudActual = llaveString.length();
        int cerosNecesarios = longitudTotal - longitudActual;
        // Construir la cadena con los ceros agregados
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < cerosNecesarios; i++) {
            stringBuilder.append('0');
        }
        stringBuilder.append(llaveString); // Agregar la llave primaria
        return stringBuilder.toString();
    }

    public static String getMedPrefix(String genero) {
        switch (genero) {
            case "Masculino":
                return "Dr.";
            case "Femenino":
                return "Dra.";
            default:
                return "Dr.";
        }
    }

    public static String getAgeFromBirthDate(String fechaNacimiento) {
        LocalDate fechaNacimientoLocal = parseToLocalDate(fechaNacimiento);
        LocalDate fechaActual = LocalDate.now();
        Period periodo = calculatePeriod(fechaNacimientoLocal, fechaActual);

        if (isUnderOneYear(periodo)) {
            return formatAgeUnderOneYear(periodo);
        } else {
            return formatAgeOverOneYear(periodo);
        }
    }

    private static LocalDate parseToLocalDate(String fechaNacimiento) {
        String[] partesFecha = fechaNacimiento.split("/");
        int dia = Integer.parseInt(partesFecha[0]);
        int mes = Integer.parseInt(partesFecha[1]);
        int año = Integer.parseInt(partesFecha[2]);
        return LocalDate.of(año, mes, dia);
    }

    private static Period calculatePeriod(LocalDate fechaNacimiento, LocalDate fechaActual) {
        return Period.between(fechaNacimiento, fechaActual);
    }

    private static boolean isUnderOneYear(Period periodo) {
        return periodo.getYears() < 1;
    }

    private static String formatAgeUnderOneYear(Period periodo) {
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

    private static String formatAgeOverOneYear(Period periodo) {
        int años = periodo.getYears();
        String edadConcatenada = años + " Año";
        if (años > 1) {
            edadConcatenada += "s";
        }
        return edadConcatenada;
    }
}
