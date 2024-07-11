package com.example.demo.service;


import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.ReservationRequestDto;
import com.example.demo.DTO.ReservationResponseDto;
import com.example.demo.dao.ReservationDao;
import com.example.demo.entities.Reservation;
import com.example.demo.entities.Salle;

@Service
public class ReservationServiceImpl implements ReservationService {

    private ReservationDao reservationDao;
    private ModelMapper modelMapper;
    private static final Logger logger = LoggerFactory.getLogger(ReservationServiceImpl.class);

    public ReservationServiceImpl(ReservationDao reservationDao, ModelMapper modelMapper) {
        this.reservationDao = reservationDao;
        this.modelMapper = modelMapper;
    }

    public boolean isDateOverlap(Date startDate, Date endDate, Salle salle) {
        List<Reservation> reservations = reservationDao.findBySalle(salle);
        for (Reservation reservation : reservations) {
            if (startDate.before(reservation.getDate_fin()) && endDate.after(reservation.getDate_du_resrvation())) {
                return true; // Chevauchement trouvé
            }
        }
        return false; // Pas de chevauchement
    }

    @Override
    public ReservationResponseDto ajouterReservation(ReservationRequestDto reservationRequestDto) {
        ReservationResponseDto response = new ReservationResponseDto();
        try {
            Reservation reserv = modelMapper.map(reservationRequestDto, Reservation.class);

            // Vérifiez les chevauchements de dates
            if (isDateOverlap(reserv.getDate_du_resrvation(), reserv.getDate_fin(), reserv.getSalle())) {
                response.setMessage("La salle est déjà réservée pour cette période. Veuillez choisir une autre période.");
                return response;
            }

            Reservation reservationsaved = reservationDao.save(reserv);
            return modelMapper.map(reservationsaved, ReservationResponseDto.class);
        } catch (Exception e) {
            // Gérer toute autre exception générique
            logger.error("Une erreur s'est produite lors de l'ajout de la réservation.", e);
            response.setMessage("Une erreur s'est produite lors de l'ajout de la réservation. Veuillez réessayer plus tard.");
            return response;
        }
    }



    public List<ReservationResponseDto> findall() {
		List<ReservationResponseDto> ReservationResponseDto =reservationDao.findAll().stream().map(el->modelMapper.map(el,ReservationResponseDto.class)).collect(Collectors.toList());
		return ReservationResponseDto;
		 
	}
	@Override
	public void delete(Integer id) {
		System.out.println("controleur contacté");
		reservationDao.deleteById(id);
		
	}
	@Override
	public ReservationResponseDto LoadReservationById(Integer id) {
		Optional<Reservation> optionalreservation = reservationDao.findById(id);
		Reservation util= optionalreservation.get();
        return modelMapper.map(util, ReservationResponseDto.class);
	}
	@Override
	public ReservationResponseDto updateReservation(ReservationRequestDto reservationRequestDto , Integer id){
	Optional<Reservation>reservationoptional =reservationDao.findById(id);
	Reservation reservationmodifie=modelMapper.map(reservationRequestDto, Reservation.class);
		if (reservationoptional.isPresent()) {
			Reservation reservation =modelMapper.map(reservationRequestDto, Reservation.class);
		reservation.setId(id);
		Reservation update=reservationDao.save(reservation);
		return modelMapper.map(update, ReservationResponseDto.class);
		}	
		else { 
			
			return modelMapper.map(reservationmodifie, ReservationResponseDto.class);
		}
				

	}


    // Autres méthodes de service...
}
