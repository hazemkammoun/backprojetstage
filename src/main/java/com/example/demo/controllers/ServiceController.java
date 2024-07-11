package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.DTO.ServiceRequestDto;
import com.example.demo.DTO.ServiceResponseDto;
import com.example.demo.DTO.UtilisateurRequestDto;
import com.example.demo.DTO.UtilisateurResponseDto;
import com.example.demo.service.ServicesService;

@RestController
@RequestMapping("services")
@CrossOrigin("origins = \"*\", allowedHeaders = \"*\"")
public class ServiceController {
	ServicesService servicesService;

	public ServiceController(ServicesService servicesService) {
		super();
		this.servicesService = servicesService;
	}

	@PostMapping()
	public ServiceResponseDto Ajouterservice(@RequestBody() ServiceRequestDto serviceRequestDto) {
		return servicesService.Ajouterservice(serviceRequestDto);

	}
	
	

	@GetMapping()
	public List<ServiceResponseDto> getservice() {
		return servicesService.findall();
		
		

	}
	
	@DeleteMapping("/id/{id}")
	public void delete(@PathVariable() Integer id) {
		servicesService.delete(id);
		System.out.println("Controler contacter");
	}
	
	@GetMapping("{id}")
	public ServiceResponseDto LoadServId(@PathVariable("id") Integer id) {
		return servicesService.LoadServId(id);
		
	}
	@PutMapping("/majserv/{id}")
	public ServiceResponseDto update(@PathVariable("id") Integer id, @RequestBody ServiceRequestDto serviceRequestDto) {
		 System.out.println("Controller contacté");
		return servicesService.update(serviceRequestDto,id);
	
		
	}
}
