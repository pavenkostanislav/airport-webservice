package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Airport {
	
	@Id
	@GeneratedValue
	private int ID;
	
	@NotNull
	private String city;

	@NotNull
	@Column(unique=true)
	private String IATACode;
	
	private int countLane;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "scheduleId")
	private Schedule schedule;

	public int getCountLane() {
		return countLane;
	}

	public void setCountLane(int countLane) {
		this.countLane = countLane;
	}

}
