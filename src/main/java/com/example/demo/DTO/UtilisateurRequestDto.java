package com.example.demo.DTO;



import java.util.List;

import com.example.demo.entities.Demande;
import com.example.demo.entities.Equipement;
import com.example.demo.entities.Leservice;
import com.example.demo.entities.Reservation;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UtilisateurRequestDto {
	
	
	private int id;
	private String nom;
	private String prenom;
	private Integer cin;
	private int matricule;
	private String poste;
	private String email;
	private String adresse;
	private long telephone;
	
	private Leservice leservice;

	private List<Reservation> reservation;
	
	private List<Equipement> equipement;


}
