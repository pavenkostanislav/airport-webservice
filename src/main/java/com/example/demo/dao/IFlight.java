package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Flight;

public interface IFlight extends CrudRepository<Flight, Long> {

}
