package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Schedule;

public interface ISchedule extends CrudRepository<Schedule, Integer> {

}
