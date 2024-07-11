package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Demande;
import com.example.demo.entities.Equipement;


public interface DemandeDao  extends JpaRepository<Demande, Integer>{
	Demande findByconfiguration(String configuration);
}
