package com.example.demo.entities;

public class Adress {

	private StreetName streeName;
	private StreetNumber streetName;
	private Departmen department;
	private Floor floor;
	public Adress(StreetName streeName, StreetNumber streetName, Departmen department, Floor floor) {
		super();
		this.streeName = streeName;
		this.streetName = streetName;
		this.department = department;
		this.floor = floor;
	}
	public Adress() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StreetName getStreeName() {
		return streeName;
	}
	public void setStreeName(StreetName streeName) {
		this.streeName = streeName;
	}
	public StreetNumber getStreetName() {
		return streetName;
	}
	public void setStreetName(StreetNumber streetName) {
		this.streetName = streetName;
	}
	public Departmen getDepartment() {
		return department;
	}
	public void setDepartment(Departmen department) {
		this.department = department;
	}
	public Floor getFloor() {
		return floor;
	}
	public void setFloor(Floor floor) {
		this.floor = floor;
	}
}
