package com.school.osacademy.security.jwt;

import com.school.osacademy.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.function.Function;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtTokenUtils {

    private final String secretKey;
    private final long validityInMilliseconds;

    public JwtTokenUtils(@Value("${jwt.secret-key}") String secretKey,
                         @Value("${jwt.token.expiration}") long validityInMilliseconds) {
        this.secretKey = secretKey;
        this.validityInMilliseconds = validityInMilliseconds;
    }

    public String generateToken(User user) {
        return Jwts.builder()
            .setSubject(user.getEmail())
            .claim("role", user.getRole().name())
            .claim("name", user.getName())
            .setIssuedAt(new Date())
            .setExpiration(new Date(new Date().getTime() + validityInMilliseconds))
            .signWith(new SecretKeySpec(secretKey.getBytes(), SignatureAlgorithm.HS512.getJcaName()),
                SignatureAlgorithm.HS512)
            .compact();
    }

    public String getUserEmailFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parserBuilder()
            .setSigningKey(secretKey.getBytes())
            .build()
            .parseClaimsJws(token)
            .getBody();
    }

    public boolean validateToken(String token, String userEmail) {
        String emailFromToken = this.getAllClaimsFromToken(token).getSubject();
        return emailFromToken.equals(userEmail);
    }

}