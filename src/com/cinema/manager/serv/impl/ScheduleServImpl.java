package com.cinema.manager.serv.impl;

import java.util.List;

import com.cinema.manager.dao.ScheduleDao;
import com.cinema.manager.dao.impl.ScheduleDaoImpl;
import com.cinema.manager.serv.ScheduleServ;
import com.cinema.prosenium.entity.Schedule;

public class ScheduleServImpl implements ScheduleServ {
	private ScheduleDao scheduleDao = new ScheduleDaoImpl();
	@Override
	public List<Schedule> queryScheduleAll() {

		return scheduleDao.queryScheduleAll();
	}
	@Override
	public int deleteSchedule(int scheduleItemId) {
		// TODO Auto-generated method stub
		return scheduleDao.deleteSchedule(scheduleItemId);
	}
	
	@Override
	public List<Schedule> queryMovieIdSchedule(int movieId) {

		return scheduleDao.queryMovieIdSchedule(movieId);
	}
	@Override
	public int addSchedule(Schedule schedule) {
		
		return scheduleDao.addSchedule(schedule);
	}
	@Override
	public int editorSchedule(Schedule schedule) {
		
		return scheduleDao.editorSchedule(schedule);
	}
}
