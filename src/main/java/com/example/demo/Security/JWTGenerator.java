package com.example.demo.security;

import java.security.Security;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTGenerator {
public String generateToken(Authentication authentication)
{
String username  = authentication.getName();
String scope =	authentication.getAuthorities().stream().map(a->a.getAuthority()).collect(Collectors.joining(" "));
System.out.println(scope);
Date currentDate = new Date();
Date expireDate = new Date(currentDate.getTime()+ SecurityConstants.JWT_EXPIRATION);
String token= Jwts.builder()
.setIssuedAt(new Date())
.setExpiration(expireDate)
				.setSubject(username)

			
				.claim("scope", scope)
				.signWith(SignatureAlgorithm.HS512,SecurityConstants.JWT_SECRET)
				.compact();
return token;
}
public String getUsernameFromJWt(String token)
{
Claims claims =Jwts.parser()
.setSigningKey(SecurityConstants.JWT_SECRET)
.parseClaimsJws(token)
.getBody();
return claims.getSubject();

}

public boolean validateToken(String token)
{
try {
	Jwts.parser().setSigningKey(SecurityConstants.JWT_SECRET).parseClaimsJws(token);
	return true;
} catch (Exception e) {
	throw new AuthenticationCredentialsNotFoundException("JWT was expired or incorrect");
}

}
}