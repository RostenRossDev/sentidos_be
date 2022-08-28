package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IReservation;
import com.example.demo.entities.Reservation;


@Service
public class ReservationService {

	@Autowired
	private IReservation reservationDao;
	
	
	
	public List<Reservation> findAll(){
		
		return (List<Reservation>) reservationDao.findAll();
	}
	
	public Reservation save(Reservation res) {
		return reservationDao.save(res);
	}
}
