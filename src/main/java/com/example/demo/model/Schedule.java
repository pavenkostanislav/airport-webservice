package com.example.demo.model;

import java.util.Date;

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

import com.example.demo.dao.IClean;

@Entity(name = "Schedule")
@Table(name = "schedule")
public class Schedule implements IClean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long ID;

	@Temporal(TemporalType.TIMESTAMP)
	private Date arrival;

	@Temporal(TemporalType.TIMESTAMP)
	private Date departure;

	@Column(name="lane_id")
	private int laneId;

	@Column(name="flight_id")
	private int flightId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="lane_id", insertable=false, updatable=false)
	private Lane lane;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="flight_id", insertable=false, updatable=false)
	private Flight flight;
	
	public Long getID() {
		return ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}

	public Date getArrival() {
		return arrival;
	}

	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}

	public Date getDeparture() {
		return departure;
	}

	public void setDeparture(Date departure) {
		this.departure = departure;
	}

	public int getLaneId() {
		return laneId;
	}

	public void setLaneId(int laneId) {
		this.laneId = laneId;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	@Override
	public void clean() {
		this.lane = null;
		this.flight = null;
	}

	public Lane getLane() {
		return lane;
	}

	public void setLane(Lane lane) {
		this.lane = lane;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

}
