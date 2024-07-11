package com.example.demo.service;

import java.util.List;


import com.example.demo.DTO.SalleRequestDto;
import com.example.demo.DTO.SalleResponseDto;

public interface SalleService {
	SalleResponseDto ajouterSalle(SalleRequestDto salleRequestDto);
	List<SalleResponseDto>findall();
	void delete(Integer id);
	SalleResponseDto LoadSalleById(Integer id);
	SalleResponseDto updateSalle(SalleRequestDto salleRequestDto, Integer id);
}
