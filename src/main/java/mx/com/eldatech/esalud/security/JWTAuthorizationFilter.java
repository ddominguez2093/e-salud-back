/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.eldatech.esalud.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.core.context.SecurityContextHolder;
import java.util.List;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import java.util.stream.Collectors;

/**
 *
 * @author apioconsulting
 */
public class JWTAuthorizationFilter extends OncePerRequestFilter {

    private static final String PREFIX = "Bearer";
    private String jwk;
    private String cipherKey;
    public JWTAuthorizationFilter(String jwk,String cipherKey) {
        this.jwk = jwk;
        this.cipherKey = cipherKey;
    }

    public JWTAuthorizationFilter() {
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        Token tkn = new Token(jwk,cipherKey);
        try {
            if (jwtTokenExists(request)) {
                Claims claims = tkn.validateToken(request);
                if (claims.get("authorities") != null) {
                    setUpSpringAuthentication(claims);
                    String refreshedToken = tkn.refreshTokenIfNeeded(claims);
                    if (refreshedToken != null) {
                        // Agrega el nuevo token a la respuesta (por ejemplo, en una cookie)
                        CookieUtils utils = new CookieUtils(cipherKey);
                        utils.setCookie(response, refreshedToken);
                    }
                } else {
                    SecurityContextHolder.clearContext();
                }
            } else {
                SecurityContextHolder.clearContext();
            }
            chain.doFilter(request, response);
        } catch (ExpiredJwtException e) {                       
            CookieUtils cookieUtils = new CookieUtils(cipherKey);
            cookieUtils.removeCookie(response);
            response.sendRedirect("/login");
            return;
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
        }
    }

    /**
     * Metodo para autenticarnos dentro del flujo de Spring
     *
     * @param claims
     */
    private void setUpSpringAuthentication(Claims claims) {
        @SuppressWarnings("unchecked")
        List<String> authorities = (List) claims.get("authorities");
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(claims.getSubject(), null,
                authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
        SecurityContextHolder.getContext().setAuthentication(auth);

    }

    private boolean jwtTokenExists(HttpServletRequest request) {
        CookieUtils utils = new CookieUtils(cipherKey);
        if (request.getCookies() != null) {
            Cookie jwtCookie = utils.getMSCookie(request);
            if (jwtCookie != null) {
                if (jwtCookie.getValue().isEmpty()) {
                    return false;
                } else {
                    String encryptedTkn = jwtCookie.getValue();
                    String token = utils.decryptToken(encryptedTkn);
                    if (token.startsWith(PREFIX)) {
                        return true;
                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
