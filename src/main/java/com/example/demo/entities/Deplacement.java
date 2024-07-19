package com.example.demo.entities;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
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
public class Deplacement implements Serializable  {
@Id
@GeneratedValue (strategy=GenerationType.IDENTITY)
private int id;
private String nom;
private String fonction;
private String service;
private String direction;
private String sous_direction;
private String instituttion;
private String mission;
private Integer type_mission;
private String description_mission;
private String activite;
private Date date_debut;
private Date heure_depart1;
private Date heure_arrive1;
private Date date_fin;
private	Date heure_depart2;
private Date heure_arrive2;
private Integer   but;
private Date date_premier_signature;
@ManyToOne
@JsonBackReference("user-deplacement")
private  Utilisateur utilisateur;
}
