package com.cybersoft.demosrpingboot.common.configure.jwt;

import com.cybersoft.demosrpingboot.entity.Users;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUltilites {
    private final SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode("2ihSuZxNGUXkfCCApyLK7pqc0JARuHEQjWB6beDPok5Ks0jfAoSQZx3q4HmtsCozjqQjC9/CCluk0wu+xltqQA=="));

    @Value("${jwt.expiration}")
    private Long jwtExpiration;

    public String generateTokens(Map<String, Object> extraClaims, @NotNull Users users) {
        return Jwts.builder().setClaims(extraClaims)
                .setSubject(users.getEmail())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(Date.from(Instant.now().plus(jwtExpiration, ChronoUnit.MILLIS)))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String getTokenFromHeader(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (StringUtils.hasText(token) && token.startsWith("Bearer")) {
            return token.substring(7);
        }
        return null;
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        return claimsResolver.apply(extractAllClaims(token));
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }

    public Boolean validateToken(String token) {
        return isTokenExpired(token) && extractAllClaims(token) != null;
    }

    public String extractEmail(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).after(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
}
