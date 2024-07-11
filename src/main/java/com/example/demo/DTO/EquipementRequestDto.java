package com.example.demo.DTO;

import java.sql.Date;

import com.example.demo.entities.Equipement;
import com.example.demo.entities.Reservation;
import com.example.demo.entities.TypeEquipement;
import com.example.demo.entities.Utilisateur;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipementRequestDto {

	private Date date_acquisition;
	private String configuration;
	private String etat;
	private boolean reservable;

	private Reservation reservation;

	private  Utilisateur utilisateur;

	private TypeEquipement typeEquipement;
}
