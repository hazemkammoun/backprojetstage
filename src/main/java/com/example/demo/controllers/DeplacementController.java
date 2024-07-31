package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Deplacement;
import com.example.demo.service.DeplacementService;

@RestController
@RequestMapping("deplacement")
@CrossOrigin("origins = \"*\", allowedHeaders = \"*\"")
public class DeplacementController {
	@Autowired
DeplacementService deplacementS;

	
@GetMapping("Listdeplacement")
List<Deplacement>afficherdeplacement(){
	return deplacementS.listdeplacement();
}
@PostMapping("/adddeplacement")

Deplacement ajouterdepacement(@RequestBody Deplacement deplacement) {
	return deplacementS.ajouterDeplacement(deplacement);
}
@DeleteMapping("/deletedeplacement/{id}")
void supprimerdepartement(@PathVariable int id) {
    deplacementS.deleteDeplacement(id);
}
}
