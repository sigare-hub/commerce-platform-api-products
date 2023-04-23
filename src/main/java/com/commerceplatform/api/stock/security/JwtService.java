package com.commerceplatform.api.stock.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class JwtService {
//    @Value("${security.jwt.secret}")
// TODO: add secret in variables
    private String secret = "TODO";

    private static final String ISSUER = "Commerce Platform Accounts";

    public String generateToken(Authentication authentication, Long userId){
        return JWT.create()
                .withIssuer(ISSUER)
                .withSubject(authentication.getName())
                .withClaim("id", userId)
                .withExpiresAt(
                        LocalDateTime.now()
                                .plusMinutes(10)
                                .toInstant(ZoneOffset.of("-03:00")
                                )
                )
                .sign(Algorithm.HMAC256(secret));
    }

    public LocalDateTime getExpirationDate(String token){
        var jwt = JWT.require(Algorithm.HMAC256(secret))
                .withIssuer(ISSUER)
                .build()
                .verify(token);

        return jwt.getExpiresAt().toInstant().atZone(ZoneOffset.UTC).toLocalDateTime();
    }

    public String getSubject(String token){
        return JWT.require(Algorithm.HMAC256(secret))
                .withIssuer(ISSUER)
                .build()
                .verify(token)
                .getSubject();
    }
}