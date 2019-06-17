package com.example.demo.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Schedule;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController extends GenericController<Schedule> {
}
