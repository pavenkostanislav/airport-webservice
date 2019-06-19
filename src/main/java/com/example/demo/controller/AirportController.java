package com.example.demo.controller;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Airport;
import com.example.demo.service.GenericService;

@RestController
@RequestMapping("/api/airport")
public class AirportController extends GenericController<Airport, CrudRepository<Airport, Long>> {

	public AirportController() {
		super(new GenericService<Airport,CrudRepository<Airport, Long>>());
	}
}
