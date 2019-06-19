package com.example.demo.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.demo.dao.ICleanAndId;

@Entity(name = "Schedule")
@Table(name = "schedule")
public class Schedule implements ICleanAndId {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long ID;

	@Column(name="flight", nullable=false)
	private String flight;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar arrival;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar departure;

	@Column(name="lane_id")
	private Long laneId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="lane_id", insertable=false, updatable=false)
	private Lane lane;
	
	@Column(name="airport_id")
	private Long airportId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="airport_id", insertable=false, updatable=false)
	private Airport airport;
	
	public Long getID() {
		return ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}

	public Calendar getArrival() {
		return arrival;
	}

	public void setArrival(Calendar arrival) {
		this.arrival = arrival;
	}

	public Calendar getDeparture() {
		return departure;
	}

	public void setDeparture(Calendar departure) {
		this.departure = departure;
	}

	@Override
	public void clean() {
		this.lane = null;
		this.airport = null;
	}

	public Lane getLane() {
		return lane;
	}

	public void setLane(Lane lane) {
		this.lane = lane;
	}

	public String getFlight() {
		return flight;
	}

	public void setFlight(String flight) {
		this.flight = flight;
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

	public Long getLaneId() {
		return laneId;
	}

	public void setLaneId(Long laneId) {
		this.laneId = laneId;
	}

}
