package com.example.demo.service;

import java.util.List;

import com.example.demo.DTO.DirectionRequestDto;
import com.example.demo.DTO.DirectionResponseDto;
import com.example.demo.DTO.UtilisateurRequestDto;
import com.example.demo.DTO.UtilisateurResponseDto;


public interface DirectionService {
	DirectionResponseDto AjouterDirection(DirectionRequestDto directionRequestDto);
	List<DirectionResponseDto>findall();
	void delete(Integer id);
	DirectionResponseDto LoadDirecById(Integer id);
	DirectionResponseDto updateDirec(DirectionRequestDto directionRequestDto, Integer id);
}
