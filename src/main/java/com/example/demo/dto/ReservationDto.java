package com.example.demo.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReservationDto {
	private Logger log = LoggerFactory.getLogger(ReservationDto.class);
	private Integer table;
	
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateReservation;
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date create_at;
	private String username;
	private String dateReservationString;
	
	public Integer getTable() {
		return table;
	}
	public void setTable(Integer table) {
		this.table = table;
	}
	public Date getDateReservation() {
		return dateReservation;
	}
	
    
	public String getDateReservationString() {
		return dateReservationString;
	}

	public void setDateReservation(Date dateReservation) {
		log.info(dateReservation.toString());
		Date date = new Date((dateReservation.getYear()), (dateReservation.getMonth()), dateReservation.getDate());
		log.info(date.toString());

		this.dateReservation = date;
		log.info((dateReservation.getYear()+1900)+"-"+"0"+(dateReservation.getMonth())+"-"+dateReservation.getDate());
		this.dateReservationString=(dateReservation.getYear()+1900) +"-"+(dateReservation.getMonth()+1)+"-"+dateReservation.getDate();
	    log.info("resrevation date strin: "+dateReservationString);
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}	
	
	public Date getCreate_at() {
		return create_at;
	}
	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}
	@Override
	public String toString() {
		return "ReservationDto [table=" + table + ", dateReservation=" + dateReservation + ", username=" + username
				+ "]";
	}
	
}
