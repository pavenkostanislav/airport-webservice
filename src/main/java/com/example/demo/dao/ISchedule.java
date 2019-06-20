package com.example.demo.dao;

import java.util.Calendar;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Schedule;

public interface ISchedule extends CrudRepository<Schedule, Long> {
	@Query(value = "select count(s) from schedule s where not (s.arrival > :dtuntil or s.departure < :dtfrom) and s.airport_id = :airportid")
	public Long countFlightByPeriod(@Param("dtfrom") Calendar dtfrom, @Param("dtuntil") Calendar dtuntil, @Param("airportid") Long airportid);
}
