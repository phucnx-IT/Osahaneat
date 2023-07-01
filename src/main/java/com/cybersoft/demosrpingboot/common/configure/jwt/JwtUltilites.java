package com.cybersoft.demosrpingboot.common.configure.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
public class JwtUltilites {
    private SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode("2ihSuZxNGUXkfCCApyLK7pqc0JARuHEQjWB6beDPok5Ks0jfAoSQZx3q4HmtsCozjqQjC9/CCluk0wu+xltqQA=="));

    @Value("${jwt.expiration}")
    private Long jwtExpiration;

    public String generateTokens (String data){

        return Jwts.builder().setSubject(data).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(Date.from(Instant.now().plus(jwtExpiration, ChronoUnit.MILLIS)))
                .signWith(key).compact();
    }
    public String getEmailFromToken (String token){
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject();
    }
    public String getTokenFromHeader(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (StringUtils.hasText(token) && token.startsWith("Bearer")) {
            return token.substring(7);
        }
        return null;
    }

    public Boolean validateToken(String token){
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
