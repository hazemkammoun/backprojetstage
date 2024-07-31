package com.example.demo.dao;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.demo.entities.Utilisateur;

@Repository
public interface UtilisateurDao extends JpaRepository<Utilisateur, Integer> {
	Optional<Utilisateur> findByPrenom(String prenom);
	Boolean existsByPrenom(String prenom);
}
