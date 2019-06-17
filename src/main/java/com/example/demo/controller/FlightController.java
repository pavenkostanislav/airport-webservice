package com.example.demo.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Flight;

@RestController
@RequestMapping("/api/flight")
public class FlightController extends GenericController<Flight> {
}
