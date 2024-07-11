package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Direction;

@Repository
public interface DirectionDao extends JpaRepository<Direction, Integer> {
 Direction findByNom(String nom);
}
