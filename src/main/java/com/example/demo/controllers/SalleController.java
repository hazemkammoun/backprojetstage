package com.example.demo.controllers;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.DTO.SalleRequestDto;
import com.example.demo.DTO.SalleResponseDto;
import com.example.demo.DTO.UtilisateurRequestDto;
import com.example.demo.DTO.UtilisateurResponseDto;
import com.example.demo.service.SalleService;

@RestController
@RequestMapping("salles")
@CrossOrigin("origins = \"*\", allowedHeaders = \"*\"")

public class SalleController {
SalleService salleService;

public SalleController(SalleService salleService) {
	super();
	this.salleService = salleService;
}

@PostMapping()
@PreAuthorize("hasAuthority('SCOPE_ADMIN')")
public SalleResponseDto ajouterSalle(@RequestBody() SalleRequestDto salleRequestDto) {
	System.out.println("Controller contacted");
	return salleService.ajouterSalle(salleRequestDto);

}

@GetMapping()
@PreAuthorize("hasAuthority('SCOPE_USER')")
public List<SalleResponseDto> getsalle() {
	return salleService.findall();

}

@DeleteMapping("/id/{id}")
public void delete(@PathVariable() Integer id) {
	salleService.delete(id);
	System.out.println("Controler contacter");
}

@GetMapping("{id}")
public SalleResponseDto LoadSalleById(@PathVariable("id") Integer id) {
	return salleService.LoadSalleById(id);
	
}
@PutMapping("/majsalle/{id}")
public SalleResponseDto updateSalle(@PathVariable("id") Integer id, @RequestBody SalleRequestDto salleRequestDto) {
	  System.out.println("Controller contacté");

	return salleService.updateSalle(salleRequestDto ,id);
	

	
}

}
