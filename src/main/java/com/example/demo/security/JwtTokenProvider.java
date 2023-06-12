//package com.example.demo.security;
//
//import com.example.demo.model.User;
//import io.jsonwebtoken.*;
//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Component
//public class JwtTokenProvider {
//    private final String secretKey = "yourSecretKey";
//    private final long validityInMilliseconds = 3600000; // 1 hour
//
//    public String generateToken(Authentication authentication) {
//        User user = (User) authentication.getPrincipal();
//        Date now = new Date();
//        Date expiryDate = new Date(now.getTime() + validityInMilliseconds);
//
//        return Jwts.builder()
//                .setSubject(user.getUsername())
//                .setIssuedAt(new Date())
//                .setExpiration(expiryDate)
//                .signWith(SignatureAlgorithm.HS512, secretKey)
//                .compact();
//    }
//
//    public boolean validateToken(String token) {
//        try {
//            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
//            return true;
//        } catch (SignatureException ex) {
//            System.out.println("Invalid JWT signature");
//        } catch (MalformedJwtException ex) {
//            System.out.println("Invalid JWT token");
//        } catch (ExpiredJwtException ex) {
//            System.out.println("Expired JWT token");
//        } catch (UnsupportedJwtException ex) {
//            System.out.println("Unsupported JWT token");
//        } catch (IllegalArgumentException ex) {
//            System.out.println("JWT claims string is empty");
//        }
//        return false;
//    }
//}
//
