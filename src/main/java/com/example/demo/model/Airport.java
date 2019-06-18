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

import com.example.demo.dao.IClean;

@Entity(name = "Airport")
@Table(name = "airport")
public class Airport implements IClean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long ID;

	private String city;

	@Column(name="iata_code", unique=true)
	private String IATACode;

	@Column(name="lane_count")
	private int countLane;

	@Column(name="schedule_id")
	private int scheduleId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="schedule_id", insertable=false, updatable=false)	
	private Schedule schedule;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Lane> lanes;
	
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

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	@Override
	public void clean() {
		this.schedule = null;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public List<Lane> getLanes() {
		return lanes;
	}

	public void setLanes(List<Lane> lanes) {
		this.lanes = lanes;
	}

}
