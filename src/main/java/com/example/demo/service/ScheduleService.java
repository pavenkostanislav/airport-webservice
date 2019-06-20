package com.example.demo.service;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.TimeZone;

import com.example.demo.controller.Vocabulary;
import com.example.demo.controller.VocabularyKeys;
import com.example.demo.dao.ISchedule;
import com.example.demo.model.Schedule;

public class ScheduleService extends GenericService<Schedule, ISchedule> {
	@Override
	public Schedule set(ISchedule crudRepository, Schedule row) throws Exception {
		if(!this.verifyEmptyLane(crudRepository, row)) {
			throw new Exception(Vocabulary.dictionary.get(VocabularyKeys.badRequest));
		}

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
	
	private boolean verifyEmptyLane(ISchedule scheduleRepository, Schedule row) throws SQLException {
		Calendar from = row.getArrival();
		Calendar until = row.getDeparture();
		Long airportid = row.getAirportId().longValue();
		int countFlightByPeriodActual =  scheduleRepository.countFlightByPeriod(from, until, airportid);
		int countLaneInAirport = scheduleRepository.countLaneInAirport(airportid);
		
		return countFlightByPeriodActual < countLaneInAirport;
	}
}
