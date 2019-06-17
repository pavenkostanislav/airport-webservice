package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Lane {

	@Id
	@GeneratedValue
	private int ID;

	@NotNull
	private String strip;
	

	@NotNull
	private int airportId;
	


	public String getStrip() {
		return strip;
	}


	public void setStrip(String strip) {
		this.strip = strip;
	}

	public int getAirportId() {
		return airportId;
	}


	public void setAirportId(int airportId) {
		this.airportId = airportId;
	}


	public int getID() {
		return ID;
	}

}
