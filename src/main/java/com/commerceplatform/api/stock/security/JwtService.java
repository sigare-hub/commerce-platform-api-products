package com.commerceplatform.api.stock.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Map;

@Service
public class JwtService {
//    @Value("${security.jwt.secret}")
// TODO: add secret in variables
    private String secret = "$2a$12$yK6MT6MH.ALvfRt/t1/Qd.0f6GpWUQvNlfrh06ruzOIMIPm1D4qoe";

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

    public Claim getClaim(String token) {
        return JWT.decode(token)
            .getClaim("claims");
    }

    public Map<String, Claim> getClaimsFromToken(String token) {
        DecodedJWT decodedJWT = JWT.decode(token);
        return decodedJWT.getClaims();
    }
}