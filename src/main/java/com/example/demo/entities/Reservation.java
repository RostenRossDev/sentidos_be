package com.example.demo.entities;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="reservations", uniqueConstraints = { @UniqueConstraint(columnNames={"reservation_date", "restaurantTable_id"})})
public class Reservation  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonIgnore
	@ManyToOne()
    @JoinColumn(name = "restaurantTable_id")
	private RestaurantTable restaurantTable;

	@ManyToOne()
    @JoinColumn(name = "customer_id")
    private Customer customer;
	
    @DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name = "create_at")
    @Temporal(TemporalType.DATE)
	private Date createAt;
	
    @DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name = "reservation_date")
    @Temporal(TemporalType.DATE)
	private Date reservationDate;
	
	private Boolean confirmed;
	
	@PrePersist
    public void prePersist() {
        createAt = new Date();
    }
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RestaurantTable getRestaurantTable() {
		return restaurantTable;
	}

	public void setRestaurantTable(RestaurantTable restaurantTable) {
		this.restaurantTable = restaurantTable;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Boolean getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(Boolean confirmed) {
		this.confirmed = confirmed;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", restaurantTable=" + restaurantTable + ", customer=" + customer
				+ ", createAt=" + createAt + ", reservationDate=" + reservationDate + ", confirmed=" + confirmed + "]";
	}	
}
