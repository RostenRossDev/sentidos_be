package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Reservation;



@Repository
public interface IReservation extends CrudRepository<Reservation, Long>{
	
}