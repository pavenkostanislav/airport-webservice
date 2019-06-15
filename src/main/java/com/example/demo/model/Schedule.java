package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Schedule {
	
	@Id
	@GeneratedValue
	private int ID;

    @Temporal(TemporalType.TIMESTAMP)
	public Date arrival;

    @Temporal(TemporalType.TIMESTAMP)
	public Date departure;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "laneId")
	public Lane lane;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "flightId")
	public Flight flight;

}
