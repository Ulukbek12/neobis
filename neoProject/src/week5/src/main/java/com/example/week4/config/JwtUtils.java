package com.example.week4.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

@Component
public class JwtUtils {
    private String jwtSigningKey = "secret";

    public Claims extractAllClaims(String token){
        return Jwts.parser().setSigningKey(jwtSigningKey).parseClaimsJwt(token).getBody();
    }
    public <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    public String extractUsername(String token){
        return extractClaim(token,Claims::getSubject);
    }
    public Date expirationDate(String token){
        return extractClaim(token,Claims::getExpiration);
    }
    public boolean hasClaim(String token,String claimName){
        final Claims claims = extractAllClaims(token);
        return claims.get(claimName) != null;
    }
    public Boolean isTokenExpired(String token){
        return expirationDate(token).before(new Date());
    }
    public String createToken(Map<String,Object> claims, UserDetails userDetails){
        return  Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .claim("authorities",userDetails.getAuthorities())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(24)))
                .signWith(SignatureAlgorithm.ES256,jwtSigningKey).compact();
    }
    public String generateToken(UserDetails userDetails){
        Map<String,Object> claims = new HashMap<>();
        return createToken(claims,userDetails);
    }
    public Boolean isTokenValid(String token,UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
    //    //Создает определенный токен с определенными клеймами на основе данных пользователя
//    private String createToken(Map<String,Object> claims,UserDetails userDetails){
//            return Jwts.builder().setClaims(claims)
//                    .setSubject(userDetails.getUsername())
//                    .claim("authorities",userDetails.getAuthorities())
//                    .setIssuedAt(new Date(System.currentTimeMillis()))
//                    .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(24)))
//                    .signWith(SignatureAlgorithm.HS256, jwtSigningKey).compact();
//    }
    //Парсит токен и извлекает все его клэймы
//    private Claims extractAllClaims(String token){
//        return Jwts.parser().setSigningKey(jwtSigningKey).parseClaimsJws(token).getBody();
//    }
//    //извлекает любой claim из токена с помощью claimResolver
//    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
//        final Claims claims = extractAllClaims(token);
//        return claimsResolver.apply(claims);
//    }
//    //извлекает имя пользователя из токена
//    public String extractUsername(String token){
//        return extractClaim(token,Claims::getSubject);
//    }
//    //извлекает дату экспирации из токена
//    public Date extractExpiration(String token){
//        return extractClaim(token,Claims::getExpiration);
//    }
//    //проверяет на наличие какогото определенного claim в токене
//    public boolean hasClaim(String token,String claimName){
//        final Claims claims = extractAllClaims(token);
//        return claims.get(claimName) != null;
//    }
//
//    //Проверяет истек ли срок годности токена
//    private Boolean isTokenExpired(String token){
//        return extractExpiration(token).before(new Date());
//    }

//    //Генерирует новый токен на основе данных пользователя userDetails
//    public String generateToken(UserDetails userDetails){
//        Map<String,Object> claims = new HashMap<>();
//        return createToken(claims,userDetails);
//    }

//    //Проверяет является ли данный токен действительным для опр пользователя
//    public Boolean isTokenValid(String token,UserDetails userDetails){
//        final String username = extractUsername(token);
//        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//    }
}

