package com.example.securingweb;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Date;

@Component
public class JWTUtil {

    private final String parol = "parol";
    public String generateToken(String username){
        Date expirationDate = Date.from(ZonedDateTime.now().plusMinutes(60).toInstant());
        return JWT.create()
                .withSubject("user details")
                .withClaim("username", username)
                .withIssuedAt(new Date())
                .withIssuer("ushnii")
                .withExpiresAt(expirationDate)
                .sign(Algorithm.HMAC256(parol));
    }

    public String validateTokenAndRetriveClaim(String token){
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(parol))
                .withSubject("user detail")
                .withIssuer("ushnii")
                .build();
        DecodedJWT jwt = verifier.verify(token);
        return jwt.getClaim("username").asString();

    }
}
