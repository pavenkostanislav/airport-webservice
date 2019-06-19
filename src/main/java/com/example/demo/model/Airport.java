package com.example.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.dao.ICleanAndId;

@Entity(name = "Airport")
@Table(name = "airport")
public class Airport implements ICleanAndId {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long ID;

	@Column(name="city", nullable=false)
	private String city;

	@Column(name="iata_code", unique=true, nullable=true)
	private String IATACode;

	@Column(name="lane_count")
	private int countLane;

	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Lane> lanes;

	@OneToMany(fetch = FetchType.LAZY)
	private List<Schedule> schedules;
	
	public Long getID() {
		return ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}
	
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

	@Override
	public void clean() {
		// TODO Auto-generated method stub
		
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

}
