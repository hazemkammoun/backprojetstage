package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.SalleRequestDto;
import com.example.demo.DTO.SalleResponseDto;
import com.example.demo.DTO.UtilisateurRequestDto;
import com.example.demo.DTO.UtilisateurResponseDto;
import com.example.demo.dao.SalleDao;


import com.example.demo.entities.Salle;
import com.example.demo.entities.Utilisateur;

@Service
public class SalleServiceImpl implements SalleService{
	private SalleDao salleDao;
	private ModelMapper modelMapper;
	
	public SalleServiceImpl(SalleDao  salleDao, ModelMapper modelMapper) {
		super();
		this.salleDao = salleDao;
		this.modelMapper = modelMapper;
	}
	
	@Override
	public SalleResponseDto ajouterSalle(SalleRequestDto salleRequestDto) {
		  Salle monsalle=modelMapper.map(salleRequestDto, Salle.class);
		  Salle sallesaved=salleDao.save(monsalle);
	       return modelMapper.map(sallesaved, SalleResponseDto.class);
		
	}
	
	
	@Override
	public List<SalleResponseDto> findall() {
		List<SalleResponseDto> SalleResponseDto =salleDao.findAll().stream().map(el->modelMapper.map(el,SalleResponseDto.class)).collect(Collectors.toList());
		return SalleResponseDto;
		 
	}
	@Override
	public void delete(Integer id) {
		System.out.println("controleur contacté");
		salleDao.deleteById(id);

	}

	
	
	@Override
	public SalleResponseDto LoadSalleById(Integer id) {
		Optional<Salle> optionalsalle = salleDao.findById(id);
		Salle util= optionalsalle.get();
        return modelMapper.map(util, SalleResponseDto.class);
	}
	@Override
	public SalleResponseDto updateSalle(SalleRequestDto salleRequestDto , Integer id){
	Optional<Salle>salleOptional =salleDao.findById(id);
	Salle sallemodifie=modelMapper.map(salleRequestDto, Salle.class);
		if (salleOptional.isPresent()) {
			Salle salle =modelMapper.map(salleRequestDto, Salle.class);
		salle.setId(id);
		Salle update=salleDao.save(salle);
		return modelMapper.map(update, SalleResponseDto.class);
		}	
		else { 
			
			return modelMapper.map(sallemodifie, SalleResponseDto.class);
		}
				

	}
}
