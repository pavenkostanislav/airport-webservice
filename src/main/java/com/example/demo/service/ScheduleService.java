package com.example.demo.service;

import java.util.Calendar;
import java.util.TimeZone;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.controller.Vocabulary;
import com.example.demo.controller.VocabularyKeys;
import com.example.demo.model.Schedule;


public class ScheduleService extends GenericService<Schedule> {
	@Override
	public Schedule set(CrudRepository<Schedule, Long> crudRepository, Schedule row) throws Exception {
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
	
	private boolean verifyEmptyLane(CrudRepository<Schedule, Long> crudRepository, Schedule row) {
		/*String sql = "SELECT COUNT(s.*) FROM Schedule s";
Query q = em.createQuery(sql);
long count = (long)q.getSingleResult();*/
		
		return true;
	}
}
