package com.cybersoft.demosrpingboot.ultilities;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Base64;

@Component
public class JwtUltilites {
    @Value("${jwt.privateKey}")
    private String privateKey;

    public String generateTokens (String data){
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));
        String jwt = Jwts.builder().setSubject(data).signWith(key).compact();
        return jwt;
    }
}
