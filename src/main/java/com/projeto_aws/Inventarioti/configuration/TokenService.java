package com.projeto_aws.Inventarioti.configuration;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.projeto_aws.Inventarioti.domain.usuarioSistema.UsuarioSistema;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${security.token.secret}")
    private String secret;

    public String gerarToken(UsuarioSistema usuarioSistema){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("inventario-ti")
                    .withSubject(usuarioSistema.getEmail())
                    .withExpiresAt(expiracaoToken())
                    .sign(algorithm);
            return token;
        }  catch (JWTCreationException exception) {
            throw new JWTCreationException("Erro na criação do token", exception);
        }
    }

    public String validarToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("inventario-ti")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            return "Token Não validado!";
        }
    }
    public Instant expiracaoToken() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
