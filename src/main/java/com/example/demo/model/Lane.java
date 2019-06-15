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
	public String stripDesignation;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "airportId")
	public Airport airportId;
}
