package com.example.demo.service;

import java.util.List;


import com.example.demo.DTO.ServiceRequestDto;
import com.example.demo.DTO.ServiceResponseDto;


public interface ServicesService {
	ServiceResponseDto Ajouterservice(ServiceRequestDto serviceRequestDto);
	
	/*
	ServiceResponseDto ChercherbyId(Integer id);

	ServiceResponseDto ChercherbyNom(String nom);

	
*/
	ServiceResponseDto update(ServiceRequestDto serviceRequestDto, Integer id);
	ServiceResponseDto LoadServId(Integer id);
	
	void delete(Integer id);

	List<ServiceResponseDto> findall();
}
