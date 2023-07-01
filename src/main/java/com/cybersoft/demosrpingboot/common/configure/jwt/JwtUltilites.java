package com.cybersoft.demosrpingboot.common.configure.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtUltilites {
    @Value("${jwt.privateKey}")
    private String privateKey;

    @Value("${jwt.expiration}")
    private Long jwtExpiration;

    public String generateTokens (String data){
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));
        String jwt = Jwts.builder().setSubject(data).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(Date.from(Instant.now().plus(jwtExpiration, ChronoUnit.MILLIS)))
                .signWith(key).compact();
        return jwt;
    }
    public String getEmailFromToken (String token){
        return Jwts.parserBuilder().setSigningKey(privateKey).build().parseClaimsJws(token).getBody().getSubject();
    }
    public String getTokenFromHeader(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (StringUtils.hasText(token) && token.startsWith("Bearer")) {
            return token.substring(7,token.length());
        }
        return null;
    }

    public Boolean validateToken(String token){
        try {
            Jwts.parserBuilder().setSigningKey(privateKey).build().parseClaimsJws(token);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
