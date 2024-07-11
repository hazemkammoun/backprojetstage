package com.example.demo.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Leservice implements Serializable {
	

	@Id  @GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id; 
	private String nom;
	private String description;
	@ManyToOne
    @JoinColumn(name = "direction_id")
    @JsonBackReference("service-direction")
	private Direction direction;
	@OneToMany(mappedBy = "leservice", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Utilisateur> utilisateur;

}
