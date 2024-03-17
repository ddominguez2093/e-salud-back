/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.eldatech.esalud.security;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.spec.GCMParameterSpec;

/**
 *
 * @author ddomi
 */
public class CookieUtils {

    private static final Logger logger = LogManager.getLogger(CookieUtils.class);
    private static final String COOKIE_NAME = "SESSCOOKIE";
    private String cipherKey;

    public CookieUtils(String cipherKey) {
        this.cipherKey = cipherKey;
    }

    public CookieUtils() {

    }

    public Cookie getMSCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().compareTo(COOKIE_NAME) == 0) {
                return cookie;
            }
        }
        return null;
    }

    public void removeCookie(HttpServletResponse response) {
        Cookie cook = new Cookie(COOKIE_NAME, null);
        cook.setMaxAge(-1);
        cook.setPath("/");
        cook.setHttpOnly(true);
        response.addCookie(cook);
    }

    public String decryptToken(String token) {
        try {
            byte[] encodedKey = Base64.getDecoder().decode(cipherKey);
            SecretKey secretKey = new SecretKeySpec(encodedKey, "AES");

            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");

            // Extract IV from the encoded token
            byte[] encryptedTokenWithIV = Base64.getDecoder().decode(token);
            byte[] iv = Arrays.copyOfRange(encryptedTokenWithIV, 0, 12); // Assuming a 12-byte IV

            // Initialize the cipher with the IV
            GCMParameterSpec parameterSpec = new GCMParameterSpec(128, iv);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, parameterSpec);

            // Decrypt the token (excluding the IV)
            byte[] encryptedToken = Arrays.copyOfRange(encryptedTokenWithIV, 12, encryptedTokenWithIV.length);
            byte[] decryptedToken = cipher.doFinal(encryptedToken);

            return new String(decryptedToken);
        } catch (Exception e) {
            logger.error("Ocurrio un error al decifrar el token: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public String encryptToken(String token) {
        try {
            byte[] encodedKey = Base64.getDecoder().decode(cipherKey);
            SecretKey secretKey = new SecretKeySpec(encodedKey, "AES");

            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");

            // Generate a random IV (Initialization Vector)
            byte[] iv = new byte[12]; // GCM recommended IV length is 12 bytes
            SecureRandom random = new SecureRandom();
            random.nextBytes(iv);

            GCMParameterSpec parameterSpec = new GCMParameterSpec(128, iv);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, parameterSpec);

            byte[] cipherText = cipher.doFinal(token.getBytes());

            // Combine IV and ciphertext
            byte[] ivAndCipherText = new byte[iv.length + cipherText.length];
            System.arraycopy(iv, 0, ivAndCipherText, 0, iv.length);
            System.arraycopy(cipherText, 0, ivAndCipherText, iv.length, cipherText.length);

            return Base64.getEncoder().encodeToString(ivAndCipherText);
        } catch (Exception e) {
            logger.error("Ocurrio un error al cifrar el token: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public void setCookie(HttpServletResponse response, String token) {
        Cookie cook = new Cookie(COOKIE_NAME, token);
        cook.setMaxAge(-1);
        cook.setPath("/");
        cook.setHttpOnly(true);
        response.addCookie(cook);
    }
}
