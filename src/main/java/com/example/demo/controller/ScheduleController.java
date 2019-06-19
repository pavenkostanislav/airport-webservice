package com.example.demo.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ISchedule;
import com.example.demo.model.Schedule;
import com.example.demo.service.ScheduleService;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController extends GenericController<Schedule, ISchedule> {

	public ScheduleController() {
		super(new ScheduleService());
	}
}
