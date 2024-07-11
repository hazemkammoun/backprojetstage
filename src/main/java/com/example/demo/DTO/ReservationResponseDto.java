package com.example.demo.DTO;

import java.sql.Date;

import com.example.demo.entities.Salle;
import com.example.demo.entities.Utilisateur;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationResponseDto {
	private int id;
	private String typemeeting;
	private Date date_du_resrvation;
	private Date date_fin;
	private Salle salle;

	private  Utilisateur utilisateur;
	
	 // Champ pour stocker le message d'erreur
    private String message;
}
