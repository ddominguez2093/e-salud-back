/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.eldatech.esalud.security;

import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import io.jsonwebtoken.Jwts;
import java.util.stream.Collectors;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import java.security.Key;
import java.time.ZonedDateTime;
import java.util.Date;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author apioconsulting
 */
public class Token {
    
    private String jwk;
    private String cipherKey;
    public Token(){}
    
    public Token(String jwk, String cipherKey) {
       this.jwk = jwk;
       this.cipherKey = cipherKey;
    }    

    public String getToken(String username) {
        CookieUtils utils = new CookieUtils(cipherKey);
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
        String token = Jwts.builder().setId("GlitchTracker").setSubject(username).claim("authorities", grantedAuthorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(Date.from(ZonedDateTime.now().plusMonths(5).toInstant()))
                .signWith(getKeyFromString(jwk), SignatureAlgorithm.HS512).compact();
        String tkn = "Bearer" + token;
        return utils.encryptToken(tkn);
    }

    public Claims validateToken(HttpServletRequest request) {
        CookieUtils utils = new CookieUtils(cipherKey);
        Cookie jwtCookie = utils.getMSCookie(request);
        String tk = jwtCookie.getValue();
        String decryptedToken = utils.decryptToken(tk);
        decryptedToken = decryptedToken.replace("Bearer", "");
        return Jwts.parserBuilder().setSigningKey(jwk.getBytes()).build().parseClaimsJws(decryptedToken).getBody();
    }

    public String refreshTokenIfNeeded(Claims claims) {               
        Date expiration = claims.getExpiration();
        Date now = new Date(System.currentTimeMillis());
        // Renueva el token si está a punto de expirar (por ejemplo, en los últimos 10 minutos)
        if (now.after(new Date(expiration.getTime() - TimeUnit.MINUTES.toMillis(10)))) {
            // Genera un nuevo token con el mismo usuario (puedes personalizar según tus necesidades)
            return getToken(claims.getSubject());
        }
        // No es necesario renovar el token
        return null;
    }

    private Key getKeyFromString(String secretKey) {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }

}
