package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Schedule;

public interface ISchedule extends CrudRepository<Schedule, Long> {
	//@Query(value = "SELECT COUNT(S) FROM schedule S WHERE NOT (S.arrival > :dtuntil  OR S.departure < :dtfrom)")
	//public Long countFlightByPeriod();
}
