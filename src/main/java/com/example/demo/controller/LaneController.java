package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ILaneRepository;
import com.example.demo.model.Lane;
import com.example.demo.service.LaneService;

@RestController
@RequestMapping("/api/lane")
public class LaneController extends GenericController<Lane, ILaneRepository> {

	public LaneController() {
		super(new LaneService());
	}
}
