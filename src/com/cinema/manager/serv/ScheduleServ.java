package com.cinema.manager.serv;

import java.util.List;

import com.cinema.prosenium.entity.Schedule;

public interface ScheduleServ {

	List<Schedule> queryScheduleAll();

	int deleteSchedule(int scheduleItemId);

	List<Schedule> queryMovieIdSchedule(int deleteMovieId);

	int addSchedule(Schedule schedule);
	//±à¼­³¡´Î
	int editorSchedule(Schedule schedule);

}
