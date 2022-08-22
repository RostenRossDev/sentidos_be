package com.example.demo.entities;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="customers")
public class Customer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JoinColumn(name = "user_id")
    @OneToOne(fetch = FetchType.LAZY)
	private User user;
	
	private String name;
	
	private String lastname;
	
	private String email;
	
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Post> posts;
	
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Reservation> reservations;
	
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Order> orders;
    
	@ManyToOne()
    @JoinColumn(name = "streetName_id")
	private StreetName streetName;
	
	@ManyToOne()
    @JoinColumn(name = "streetNumber_id")
	private StreetNumber streetNumber;
	
	@ManyToOne()
    @JoinColumn(name = "departmen_id")
	private Departmen departmen;
	
	@ManyToOne()
    @JoinColumn(name = "floor_id")
	private Floor floor;	
	
	@Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createAt;
	
	private String potho;
	
	@PrePersist
    public void prePersist() {
        createAt = new Date();
    }
	public void addOrder(Order order) {
		this.orders.add(order);
	}
	
	public void addReservation(Reservation reservation) {
		this.reservations.add(reservation);
	}
	public void addPost(Post post) {
		this.posts.add(post);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public StreetName getStreetName() {
		return streetName;
	}

	public void setStreetName(StreetName streetName) {
		this.streetName = streetName;
	}

	public StreetNumber getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(StreetNumber streetNumber) {
		this.streetNumber = streetNumber;
	}

	public Departmen getDepartmen() {
		return departmen;
	}

	public void setDepartmen(Departmen departmen) {
		this.departmen = departmen;
	}

	public Floor getFloor() {
		return floor;
	}

	public void setFloor(Floor floor) {
		this.floor = floor;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPotho() {
		return potho;
	}
	public void setPotho(String potho) {
		this.potho = potho;
	}			
	
}
