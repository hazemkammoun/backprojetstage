package com.example.demo.DTO;

import java.util.List;

import com.example.demo.entities.Direction;
import com.example.demo.entities.Utilisateur;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceRequestDto {
	
	private String nom;
	private String description;
	
	private Direction direction;

	private List<Utilisateur> utilisateur;
}
