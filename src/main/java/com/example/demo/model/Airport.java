package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.NaturalId;

@Entity(name = "Airport")
@Table(name = "airport")
public class Airport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long ID;

	@NotNull(message = "{com.example.demo.controller.Vocabulary.notNull}")
	private String city;

	@NotNull(message = "{com.example.demo.controller.Vocabulary.notNull}")
    @NaturalId
	private String IATACode;

	@NotNull(message = "{com.example.demo.controller.Vocabulary.notNull}")
	private int countLane;

	@NotNull(message = "{com.example.demo.controller.Vocabulary.notNull}")
	private int scheduleId;

	public int getCountLane() {
		return countLane;
	}

	public void setCountLane(int countLane) {
		this.countLane = countLane;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getIATACode() {
		return IATACode;
	}

	public void setIATACode(String iATACode) {
		IATACode = iATACode;
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

}
