package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.UtilisateurRequestDto;
import com.example.demo.DTO.UtilisateurResponseDto;
import com.example.demo.dao.UtilisateurDao;
import com.example.demo.entities.Utilisateur;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {
	
	private UtilisateurDao utilisateurDao;
	private ModelMapper modelMapper;
	

	public UtilisateurServiceImpl(UtilisateurDao utilisateurDao, ModelMapper modelMapper) {
		super();
		this.utilisateurDao = utilisateurDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public UtilisateurResponseDto Ajouteruser(UtilisateurRequestDto utilisateurRequestDto) {
	       Utilisateur utilisateur=modelMapper.map(utilisateurRequestDto, Utilisateur.class);
	       Utilisateur usersaved=utilisateurDao.save(utilisateur);
	       return modelMapper.map(usersaved, UtilisateurResponseDto.class);
	}

	@Override
	public UtilisateurResponseDto ChercherbyId(Integer id) {
		Utilisateur utilisateur=utilisateurDao.findById(id).orElseThrow(()->new RuntimeException("Utilisateur non trouvé"));
		return modelMapper.map(utilisateur, UtilisateurResponseDto.class);
	}

	@Override
	public UtilisateurResponseDto ChercherbyNom(String nom) {
		Utilisateur utilisateur=utilisateurDao.findByNom(nom);	
	    return modelMapper.map(utilisateur, UtilisateurResponseDto.class);
		
	}

	@Override
	public void delete(Integer id) {
		System.out.println("controleur contacté");
		utilisateurDao.deleteById(id);
		
	}
	@Override
	public UtilisateurResponseDto LoadEmployeeById(Integer id) {
		Optional<Utilisateur> optionalemployee = utilisateurDao.findById(id);
		Utilisateur util= optionalemployee.get();
        return modelMapper.map(util, UtilisateurResponseDto.class);
	}
	@Override
	public UtilisateurResponseDto update(UtilisateurRequestDto utilisateurRequestDto , Integer id){
	Optional<Utilisateur>utilisateurOptional =utilisateurDao.findById(id);
		Utilisateur utilisateurmodifie=modelMapper.map(utilisateurRequestDto, Utilisateur.class);
		if (utilisateurOptional.isPresent()) {
		Utilisateur utilisateur =modelMapper.map(utilisateurRequestDto, Utilisateur.class);
		utilisateur.setId(id);
		Utilisateur update=utilisateurDao.save(utilisateur);
		return modelMapper.map(update, UtilisateurResponseDto.class);
		}	
		else { 
			
			return modelMapper.map(utilisateurmodifie, UtilisateurResponseDto.class);
		}
				

	}

	@Override
	public List<UtilisateurResponseDto> findall() {
		List<UtilisateurResponseDto> UtilisateurResponseDto = utilisateurDao.findAll().stream().map(el->modelMapper.map(el, UtilisateurResponseDto.class)).collect(Collectors.toList());
		return UtilisateurResponseDto;
		
	}
	

}
