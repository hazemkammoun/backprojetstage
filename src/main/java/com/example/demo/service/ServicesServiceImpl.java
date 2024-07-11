package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.example.demo.DTO.ServiceRequestDto;
import com.example.demo.DTO.ServiceResponseDto;
import com.example.demo.dao.ServiceDao;
import com.example.demo.entities.Leservice;

@Service
public class ServicesServiceImpl implements ServicesService {

	private ServiceDao serviceDao;
	private ModelMapper modelMapper;
	
	public ServicesServiceImpl(ServiceDao  serviceDao, ModelMapper modelMapper) {
		super();
		this.serviceDao = serviceDao;
		this.modelMapper = modelMapper;
	}

	

	

	
	@Override
	public List<ServiceResponseDto> findall() {
		List<ServiceResponseDto> ServiceResponseDto =serviceDao.findAll().stream().map(el->modelMapper.map(el,ServiceResponseDto.class)).collect(Collectors.toList());
		return ServiceResponseDto;
		 
	}


	@Override
	public void delete(Integer id) {
		System.out.println("controleur contacté");
		serviceDao.deleteById(id);

	}

	@Override
	public ServiceResponseDto Ajouterservice(ServiceRequestDto serviceRequestDto) {
		  Leservice monservice=modelMapper.map(serviceRequestDto, Leservice.class);
	       Leservice servicesaved=serviceDao.save(monservice);
	       return modelMapper.map(servicesaved, ServiceResponseDto.class);
		
	}
	
	
	@Override
	public ServiceResponseDto LoadServId(Integer id) {
		Optional<Leservice> optionalservice = serviceDao.findById(id);
		Leservice leserv= optionalservice.get();
        return modelMapper.map(leserv, ServiceResponseDto.class);
	}


	
	@Override
	public ServiceResponseDto update(ServiceRequestDto serviceRequestDto , Integer id){
	Optional<Leservice>serviceOptional =serviceDao.findById(id);
	Leservice leservicemodifie=modelMapper.map(serviceRequestDto, Leservice.class);
		if (serviceOptional.isPresent()) {
			Leservice Leservice =modelMapper.map(serviceRequestDto, Leservice.class);
			Leservice.setId(id);
			Leservice update=serviceDao.save(Leservice);
		return modelMapper.map(update, ServiceResponseDto.class);
		}	
		else { 
			
			return modelMapper.map(leservicemodifie, ServiceResponseDto.class);
	
		}
	}
}