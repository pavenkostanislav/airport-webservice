package com.example.demo.dao;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Schedule;

public interface ISchedule extends CrudRepository<Schedule, Long> {
	/*
	@Query(value = "select count(s) from Schedule s where not (s.arrival > :dtuntil or s.departure < :dtfrom) and s.airportId = :airportid")
	public List<Schedule> countFlightByPeriod(@Param("dtfrom") Calendar dtfrom, @Param("dtuntil") Calendar dtuntil, @Param("airportid") Long airportid);
	*/
	@Query(value = "select count(s) from Schedule s where "+
"(s.arrival between :dtfrom and :dtuntil or s.departure between :dtfrom and :dtuntil "+
"or :dtfrom between s.arrival and s.departure or :dtuntil between s.arrival and s.departure) "+
"and s.airportId = :airportid")
	public int countFlightByPeriod(@Param("dtfrom") Calendar dtfrom, @Param("dtuntil") Calendar dtuntil, @Param("airportid") Long airportid);
	

	@Query(value = "select a.countLane from Airport a where a.id = :id")
	public int countLaneInAirport(@Param("id") Long id);
}
