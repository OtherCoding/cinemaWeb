package com.cinema.prosenium.serv;

import java.util.List;

import com.cinema.prosenium.entity.Schedule;

public interface ScheduleServ {

	List<Schedule> queryMovieIdSchedule(int movieId);

	Schedule queryScheduleIdSchedule(int scheduleItemId);

}
