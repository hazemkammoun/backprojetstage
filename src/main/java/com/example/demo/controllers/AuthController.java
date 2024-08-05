package com.example.demo.controllers;

import java.util.Collections;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.AuthResponseDTO;
import com.example.demo.DTO.LoginDto;
import com.example.demo.DTO.RegisterDto;
import com.example.demo.dao.RoleDao;
import com.example.demo.dao.UtilisateurDao;
import com.example.demo.entities.Role;
import com.example.demo.entities.Utilisateur;
import com.example.demo.security.JWTGenerator;

@RestController
@RequestMapping("auth")
@CrossOrigin("origins = \"*\", allowedHeaders = \"*\"")
public class AuthController {
private AuthenticationManager authenticationManager;
private UtilisateurDao utilisateurDao;
private RoleDao roleDao;
private PasswordEncoder passwordEncoder;
private JWTGenerator jwtGenerator;
@Autowired 
public AuthController(AuthenticationManager authenticationManager,UtilisateurDao utilisateurDao,RoleDao roleDao,PasswordEncoder passwordEncoder,JWTGenerator jwtGenerator)
{
this.authenticationManager=authenticationManager;
this.utilisateurDao=utilisateurDao;
this.roleDao=roleDao;
this.passwordEncoder=passwordEncoder;
this.jwtGenerator=jwtGenerator;
}

@PostMapping(path="/login",consumes = "application/x-www-form-urlencoded")
public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDto loginDto)
{System.out.println(loginDto.getPassword());
	org.springframework.security.core.Authentication authentication=authenticationManager.authenticate(
		new UsernamePasswordAuthenticationToken(loginDto.getPrenom(), 
				loginDto.getPassword()));
SecurityContextHolder.getContext().setAuthentication(authentication);
String token=jwtGenerator.generateToken(authentication);
System.out.println(token);
return new ResponseEntity<>(new AuthResponseDTO(token),HttpStatus.OK);
			}

@PostMapping("/register")
public ResponseEntity<String>register(@RequestBody RegisterDto registerDto)
{
	System.out.println("Controller auth contacted"+ registerDto);
if(utilisateurDao.existsByPrenom(registerDto.getPrenom())) {
	return new ResponseEntity<>("Username  "+registerDto.getPrenom()+" taken!",HttpStatus.BAD_REQUEST);
}	
Utilisateur user=new Utilisateur();
user.setPrenom(registerDto.getPrenom());
user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
Role roles =roleDao.findByNom("USER").get();
user.setRoles(Collections.singletonList(roles));
utilisateurDao.save(user);
return new ResponseEntity<>("User registered success!",HttpStatus.OK);
}

}