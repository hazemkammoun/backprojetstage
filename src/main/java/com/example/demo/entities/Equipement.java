package com.example.demo.entities;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Equipement implements Serializable {
	@Id 
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	private Date date_acquisition;
	private String configuration;
	private String etat;
	private boolean reservable;
	@ManyToOne
	@JsonBackReference("reserv-equip")
	private Reservation reservation;
	@ManyToOne
	@JsonBackReference("user-equip")
	private  Utilisateur utilisateur;
	@Enumerated(EnumType.STRING)
	private TypeEquipement typeEquipement;
	
}
