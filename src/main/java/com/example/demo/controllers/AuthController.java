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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.LoginDto;
import com.example.demo.DTO.RegisterDto;
import com.example.demo.dao.RoleDao;
import com.example.demo.dao.UtilisateurDao;
import com.example.demo.entities.Role;
import com.example.demo.entities.Utilisateur;

@RestController
@RequestMapping("/auth/login")
public class AuthController {
private AuthenticationManager authenticationManager;
private UtilisateurDao utilisateurDao;
private RoleDao roleDao;
private PasswordEncoder passwordEncoder;
@Autowired 
public AuthController(AuthenticationManager authenticationManager,UtilisateurDao utilisateurDao,RoleDao roleDao,PasswordEncoder passwordEncoder)
{
this.authenticationManager=authenticationManager;
this.utilisateurDao=utilisateurDao;
this.roleDao=roleDao;
this.passwordEncoder=passwordEncoder;
}

@PostMapping("login")
public ResponseEntity<String> login(@RequestBody LoginDto loginDto)
{org.springframework.security.core.Authentication authentication=authenticationManager.authenticate(
		new UsernamePasswordAuthenticationToken(loginDto.getPrenom(), 
				loginDto.getPassword()));
SecurityContextHolder.getContext().setAuthentication(authentication);
return new ResponseEntity<>("User signed success!",HttpStatus.OK);
			}

@PostMapping("register")
public ResponseEntity<String>register(@RequestBody RegisterDto registerDto)
{
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
