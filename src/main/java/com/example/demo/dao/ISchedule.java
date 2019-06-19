package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Schedule;

public interface ISchedule extends CrudRepository<Schedule, Long> {
	//@Query("from Schedule s where c.name=:categoryName  FROM SCHEDULE S WHERE NOT (S.ARRIVAL > :UNTIL  OR S.DEPARTURE < :FROM)")
	//public Iterable<Schedule> findByPeriod(@Param("FROM") Calendar from, @Param("UNTIL") Calendar until);
}
