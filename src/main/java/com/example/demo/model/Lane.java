package com.example.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.dao.ICleanAndId;

@Entity(name = "Lane")
@Table(name = "lane")
public class Lane implements ICleanAndId {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long ID;

	@Column(name="strip", nullable=false)
	private String strip;
	
	@Column(name="airport_id", nullable=false)
	private Long airportId;
	

	@OneToOne(fetch = FetchType.LAZY)
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
