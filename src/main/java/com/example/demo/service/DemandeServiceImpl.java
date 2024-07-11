package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.DemandeRequestDto;
import com.example.demo.DTO.DemandeResponseDto;
import com.example.demo.DTO.DirectionResponseDto;
import com.example.demo.DTO.EquipementResponseDto;
import com.example.demo.dao.DemandeDao;

import com.example.demo.entities.Demande;
import com.example.demo.entities.Direction;



@Service
public class DemandeServiceImpl  implements DemandeService{
	private DemandeDao demandeDao;
	private ModelMapper modelMapper;

	public DemandeServiceImpl(DemandeDao demandeDao, ModelMapper modelMapper) {
		super();
		this.demandeDao = demandeDao;
		this.modelMapper = modelMapper;
		
	}
	
	@Override
	public DemandeResponseDto ajouterDemande(DemandeRequestDto demandeRequestDto) {
		Demande demande=modelMapper.map(demandeRequestDto, Demande.class);
		Demande demandesaved=demandeDao.save(demande);
		return modelMapper.map(demandesaved, DemandeResponseDto.class);
	}

	@Override
	public List<DemandeResponseDto> findall() {
		List<DemandeResponseDto> DemandeResponseDto =demandeDao.findAll().stream().map(el->modelMapper.map(el,DemandeResponseDto.class)).collect(Collectors.toList());
		return DemandeResponseDto;
	}

	@Override
	public void delete(Integer id) {
		System.out.println("controleur contacté");
		demandeDao.deleteById(id);
		
		
	}

	@Override
	public DemandeResponseDto LoaddemandeById(Integer id) {
		Optional<Demande> optionaldemande = demandeDao.findById(id);
		Demande demande= optionaldemande.get();
        return modelMapper.map(demande, DemandeResponseDto.class);
	}

	@Override
	public DemandeResponseDto updatedemande(DemandeRequestDto demandeRequestDto, Integer id) {
		Optional<Demande> demandeoptional =demandeDao.findById(id);
		Demande ledemandemodifie=modelMapper.map(demandeRequestDto, Demande.class);
			if (demandeoptional.isPresent()) {
				Demande demande=modelMapper.map(demandeRequestDto, Demande.class);
				demande.setId(id);
				Demande update=demandeDao.save(demande);
			return modelMapper.map(update, DemandeResponseDto.class);
			}	
			else { 
				
				return modelMapper.map(ledemandemodifie, DemandeResponseDto.class);
		
			}

}
}