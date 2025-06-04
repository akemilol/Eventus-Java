package br.com.eventus.eventus_api.security;

import br.com.eventus.eventus_api.model.UsuarioEventus;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class TokenService {

    private final SecretKey secret = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String gerarToken(UsuarioEventus usuario) {
        return Jwts.builder()
                .setSubject(usuario.getEmailUsuario())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // 1 dia
                .signWith(secret)
                .compact();
    }

    public String validarToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(secret)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
}
