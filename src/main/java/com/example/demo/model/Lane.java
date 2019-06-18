package com.example.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.example.demo.dao.IClean;

@Entity(name = "Lane")
@Table(name = "lane")
public class Lane implements IClean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long ID;

	@NotNull
	private String strip;
	
	@Column(name="airport_id")
	private Long airportId;
	

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airport_id", insertable=false, updatable = false)
	private Airport airport;
	
	public String getStrip() {
		return strip;
	}

	public void setStrip(String strip) {
		this.strip = strip;
	}
	
	public Long getID() {
		return ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}
	
	public Airport getAirport() {
		return airport;
	}

	public void setAirport(Airport airport) {
		this.airport = airport;
	}

	public Long getAirportId() {
		return airportId;
	}

	public void setAirportId(Long airportId) {
		this.airportId = airportId;
	}

	@Override
	public void clean() {
		this.airport= null;	
	}
}
