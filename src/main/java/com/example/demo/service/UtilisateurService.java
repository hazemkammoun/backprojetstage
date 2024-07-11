package com.example.demo.service;

import java.util.List;



import com.example.demo.DTO.UtilisateurRequestDto;
import com.example.demo.DTO.UtilisateurResponseDto;

public interface UtilisateurService {
	
	UtilisateurResponseDto Ajouteruser(UtilisateurRequestDto utilisateurRequestDto);
	UtilisateurResponseDto ChercherbyId(Integer id);
	UtilisateurResponseDto ChercherbyNom(String nom);
	void delete(Integer id);
	UtilisateurResponseDto LoadEmployeeById(Integer id);
	UtilisateurResponseDto update(UtilisateurRequestDto utilisateurRequestDto, Integer id);
	List<UtilisateurResponseDto> findall();
	
}