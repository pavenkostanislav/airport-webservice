package com.example.demo.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Airport;

@RestController
@RequestMapping("/api/airport")
public class AirportController extends GenericController<Airport> {
}
