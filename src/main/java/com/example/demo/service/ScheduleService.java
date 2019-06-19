package com.example.demo.service;

import java.util.Calendar;
import java.util.TimeZone;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Schedule;


public class ScheduleService extends GenericService<Schedule> {
	@Override
	public Schedule set(CrudRepository<Schedule, Long> crudRepository, Schedule row) {
		/*
		 
		if(row.getArrival() >= row.getDeparture()) {
			throw new Exeption(Vocabulary.dictionary.get(VocabularyKeys.badRequest));
		};
		
		
		*/

		row.setArrival(this.roundHour(row.getArrival()));
		row.setDeparture(this.roundHour(row.getDeparture()));
		
		return super.set(crudRepository, row);
	}

	private Calendar roundHour(Calendar dt) {
		Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.set(dt.get(Calendar.YEAR), dt.get(Calendar.MONTH), dt.get(Calendar.DATE), dt.get(Calendar.HOUR_OF_DAY), 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
		return calendar;
	}
}
