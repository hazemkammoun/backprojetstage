package com.example.demo.dao;





import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Reservation;
import com.example.demo.entities.Salle;


@Repository
public interface ReservationDao extends JpaRepository<Reservation, Integer>{
	List<Reservation> findBySalle(Salle salle);

}
