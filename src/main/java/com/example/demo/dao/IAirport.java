package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Airport;

public interface IAirport extends CrudRepository<Airport, Integer> {

}
