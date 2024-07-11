package com.example.demo.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.DTO.ReservationRequestDto;
import com.example.demo.DTO.ReservationResponseDto;

import com.example.demo.service.ReservationService;

@RestController
@RequestMapping("reservation")
@CrossOrigin("origins = \"*\", allowedHeaders = \"*\"")
public class ReservationController {

	ReservationService reservationService;

	public ReservationController(ReservationService reservationService) {
		super();
		this.reservationService = reservationService;
	}

	@PostMapping()
	@PreAuthorize("hasAuthority('SCOPE_USER')")
	public ReservationResponseDto ajouterReservation(@RequestBody() ReservationRequestDto reservationRequestDto) {
		return reservationService.ajouterReservation(reservationRequestDto);

	}

	@GetMapping()
	@PreAuthorize("hasAuthority('SCOPE_USER')")
	public List<ReservationResponseDto> getreservation() {
		return reservationService.findall();

	}
	
	@DeleteMapping("/id/{id}")
	@PreAuthorize("hasAuthority('SCOPE_USER')")
	public void delete(@PathVariable() Integer id) {
		reservationService.delete(id);
		System.out.println("Controler contacter");
	}
	
	@GetMapping("{id}")
	@PreAuthorize("hasAuthority('SCOPE_USER')")
	public ReservationResponseDto LoadReservationById(@PathVariable("id") Integer id) {
		return reservationService.LoadReservationById(id);
		
	}
	
	@PutMapping("/majres/{id}")
	@PreAuthorize("hasAuthority('SCOPE_USER')")
	public ReservationResponseDto updateReservation(@PathVariable("id") Integer id, @RequestBody ReservationRequestDto reservationRequestDto) {
		  System.out.println("Controller contacté");

	
		return reservationService.updateReservation(reservationRequestDto ,id);

		
	}
}
