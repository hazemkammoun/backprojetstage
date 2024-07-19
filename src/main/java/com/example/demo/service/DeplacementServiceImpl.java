package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DeplacementDao;
import com.example.demo.entities.Deplacement;
@Service
public class DeplacementServiceImpl implements DeplacementService{
	
public DeplacementServiceImpl(DeplacementDao deplacementD) {
		super();
		this.deplacementD = deplacementD;
	}
@Autowired
DeplacementDao deplacementD;
@Override
public List<Deplacement> listdeplacement() {
	return deplacementD.findAll();
}
@Override
public Deplacement ajouterDeplacement(Deplacement deplacement) {

	return deplacementD.save(deplacement);
}
@Override
public void deleteDeplacement(int id) {
	deplacementD.deleteById(id);
}
}
