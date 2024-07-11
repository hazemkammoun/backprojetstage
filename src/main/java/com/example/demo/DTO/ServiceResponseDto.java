package com.example.demo.DTO;

import java.util.List;

import com.example.demo.entities.Direction;
import com.example.demo.entities.Utilisateur;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class ServiceResponseDto {
	private int id;
	private String nom;
	private String description;
    

	private Direction direction;

	private List<Utilisateur> utilisateur;
}
