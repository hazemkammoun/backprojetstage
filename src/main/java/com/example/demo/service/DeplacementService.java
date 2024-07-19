package com.example.demo.service;

import java.util.List;


import com.example.demo.entities.Deplacement;

public interface DeplacementService {
	List<Deplacement> listdeplacement();
	Deplacement ajouterDeplacement(Deplacement deplacement);
	void deleteDeplacement(int id);
}
