package com.example.demo.controllers;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
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

import com.example.demo.DTO.UtilisateurRequestDto;
import com.example.demo.DTO.UtilisateurResponseDto;
import com.example.demo.entities.Utilisateur;
import com.example.demo.service.UtilisateurService;

@RestController

@RequestMapping("users")
@CrossOrigin("origins = \"*\", allowedHeaders = \"*\"")

public class UtilisateurController {
	UtilisateurService utilisateurService;

	public UtilisateurController(UtilisateurService utilisateurService) {
		super();
		this.utilisateurService = utilisateurService;
	}
	
	@GetMapping("/id/{id}")

    public UtilisateurResponseDto ChercherbyId(@PathVariable("id") Integer id) {
		return utilisateurService.ChercherbyId(id);
	}
	
	@GetMapping("/nom/{nom}")

	public UtilisateurResponseDto ChercherbyNom(@PathVariable() String nom) {
		return utilisateurService.ChercherbyNom(nom);
		
	}
	
	@DeleteMapping("/id/{id}")
	
	public void delete(@PathVariable() Integer id) {
		utilisateurService.delete(id);
		System.out.println("Controler contacter");
	}
	@PutMapping("/id/{id}")

	public UtilisateurResponseDto update(@RequestBody() UtilisateurRequestDto utilisateurRequestDto,@PathVariable() Integer id)throws NotFoundException {
		return utilisateurService.update(utilisateurRequestDto, id);
	}
	
	@GetMapping("{id}")

	public UtilisateurResponseDto LoadEmployeeById(@PathVariable("id") Integer id) {
		return utilisateurService.LoadEmployeeById(id);
		
	}
	@GetMapping()
	
	public List<UtilisateurResponseDto> getusers() {
		return utilisateurService.findall();
		
	}

	@PostMapping()

	public UtilisateurResponseDto AjouterUser(@RequestBody()UtilisateurRequestDto utilisateurRequestDto) {
	return utilisateurService.Ajouteruser(utilisateurRequestDto);
			
	}
	@PutMapping("/majuser/{id}")

	public UtilisateurResponseDto updateEmployee(@PathVariable("id") Integer id, @RequestBody UtilisateurRequestDto utilisateurRequestDto) {
		 System.out.println("Controller contacté");
		return utilisateurService.update(utilisateurRequestDto ,id);
		
	}
	
	@PostMapping("/register")
	public UtilisateurResponseDto AjouterUtilisateur(@RequestBody()UtilisateurRequestDto utilisateurRequestDto) {
	return utilisateurService.Ajouteruser(utilisateurRequestDto);
			
	}
}
