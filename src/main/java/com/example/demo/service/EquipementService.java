package com.example.demo.service;

import java.util.List;

import com.example.demo.DTO.DirectionRequestDto;
import com.example.demo.DTO.DirectionResponseDto;
import com.example.demo.DTO.EquipementRequestDto;
import com.example.demo.DTO.EquipementResponseDto;

public interface EquipementService {
EquipementResponseDto ajouterEquipement(EquipementRequestDto equipementRequestDto);
	List<EquipementResponseDto>findall();
	void delete(Integer id);
EquipementResponseDto LoadequipById(Integer id);
EquipementResponseDto updateEquip(EquipementRequestDto equipementRequestDto , Integer id);
}
