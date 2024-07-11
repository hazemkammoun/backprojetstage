package com.example.demo.DTO;

import java.sql.Date;

import com.example.demo.entities.Equipement;
import com.example.demo.entities.Salle;
import com.example.demo.entities.Utilisateur;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemandeResponseDto {
	private int id;
	private Date date_demande;
	private String objet_demande;
	private String configuration;
	private String etat_demande;

	private  Utilisateur utilisateur;
}
