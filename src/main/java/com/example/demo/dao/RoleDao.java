package com.example.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Role;



public interface RoleDao extends JpaRepository<Role, Integer> {
	Optional<Role>findByNom(String nom);

}
