package com.example.quoraproject.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Key;
import java.util.Date;

public class JwtUtil {

        @Value("${jwt.secret}")
        private String SECRET_KEY;
        private  Key key;

    @Value("${jwt.access_validity}")
    private long ACCESS_TOKEN_VALIDITY;
    @Value("${jwt.refresh_validity}")
    private long REFRESH_TOKEN_VALIDITY;

    @PostConstruct
    public void init(){
        this.key=Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public String generateAccessToken(UserDetails userDetails,Long userId){
        return createToken(userId,ACCESS_TOKEN_VALIDITY);
    }

    public String generateRefreshToken(UserDetails userDetails,Long userId){
        return createToken(userId,REFRESH_TOKEN_VALIDITY);
    }

    private String createToken(Long userId, long validity){
        return Jwts.builder()
                .setSubject(String.valueOf(userId))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+validity))
                .signWith(key,SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token ,UserDetails userDetails,Long userId){
        return extractUserId(token).equals(userId) && !isTokenExpired(token);
    }

//    public String extractUsername(String token) {
//        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject();
//    }

    public Long extractUserId(String token){
            Claims claims=Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            return Long.parseLong(claims.getSubject());


    }

    private boolean isTokenExpired(String token){
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration()
                .before(new Date());
    }



}
