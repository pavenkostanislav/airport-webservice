package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Airport;

public interface IAirportRepository extends CrudRepository<Airport, Long> {

}
