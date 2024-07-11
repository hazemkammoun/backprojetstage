package com.example.demo.DTO;

import java.util.List;

import com.example.demo.entities.Reservation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalleRequestDto {
	
	private String nom;
	private Integer nombre_des_places; 
	private List<Reservation> reservation;
}
