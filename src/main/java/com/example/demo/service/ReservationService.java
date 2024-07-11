package com.example.demo.service;

import java.util.Date;
import java.util.List;

import com.example.demo.DTO.ReservationRequestDto;
import com.example.demo.DTO.ReservationResponseDto;
import com.example.demo.DTO.UtilisateurRequestDto;
import com.example.demo.DTO.UtilisateurResponseDto;
import com.example.demo.entities.Salle;

public interface ReservationService {
	ReservationResponseDto ajouterReservation(ReservationRequestDto reservationRequestDto);
	List<ReservationResponseDto>findall();
	void delete(Integer id);
	ReservationResponseDto LoadReservationById(Integer id);
	public boolean isDateOverlap(Date startDate, Date endDate, Salle salle);
	ReservationResponseDto updateReservation(ReservationRequestDto reservationRequestDto, Integer id);
}

