package com.example.demo.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.IScheduleRepository;
import com.example.demo.model.Schedule;
import com.example.demo.service.ScheduleService;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController extends GenericController<Schedule, IScheduleRepository> {

	public ScheduleController() {
		super(new ScheduleService());
	}
}
