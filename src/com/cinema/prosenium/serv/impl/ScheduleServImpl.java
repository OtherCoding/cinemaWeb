package com.cinema.prosenium.serv.impl;

import java.util.List;

import com.cinema.prosenium.dao.ScheduleDao;
import com.cinema.prosenium.dao.impl.ScheduleDaoImpl;
import com.cinema.prosenium.entity.Schedule;
import com.cinema.prosenium.serv.ScheduleServ;

public class ScheduleServImpl implements ScheduleServ {
	private ScheduleDao scheduleDao = new ScheduleDaoImpl();
	@Override
	public List<Schedule> queryMovieIdSchedule(int movieId) {

		return scheduleDao.queryMovieIdSchedule(movieId);
	}
	@Override
	public Schedule queryScheduleIdSchedule(int scheduleItemId) {
		// TODO Auto-generated method stub
		return scheduleDao.queryScheduleIdSchedule(scheduleItemId);
	}

}
