package com.example.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name = "Lane")
@Table(name = "lane")
public class Lane {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long ID;

	@NotNull(message = "{com.example.demo.controller.Vocabulary.notNull}")
	private String strip;
	

	@NotNull(message = "{com.example.demo.controller.Vocabulary.notNull}")
	@Column(
	        name = "airport_Id",
	        nullable = false
    )
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


	public Long getID() {
		return ID;
	}


}
