package com.cinema.prosenium.dao;

import java.util.List;

import com.cinema.prosenium.entity.Schedule;

public interface ScheduleDao {

	List<Schedule> queryMovieIdSchedule(int movieId);

	Schedule queryScheduleIdSchedule(int scheduleItemId);

}
