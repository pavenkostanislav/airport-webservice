package com.example.demo.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Lane;
import com.example.demo.service.GenericService;

@RestController
@RequestMapping("/api/lane")
public class LaneController extends GenericController<Lane, CrudRepository<Lane, Long>> {

	public LaneController() {
		super(new GenericService<Lane, CrudRepository<Lane, Long>>());
	}
}
