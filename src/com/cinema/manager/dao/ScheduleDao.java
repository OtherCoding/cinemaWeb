package com.cinema.manager.dao;

import java.util.List;

import com.cinema.prosenium.entity.Schedule;

public interface ScheduleDao {

	List<Schedule> queryScheduleAll();

	int deleteSchedule(int scheduleItemId);

	List<Schedule> queryMovieIdSchedule(int movieId);

	int addSchedule(Schedule schedule);

	int editorSchedule(Schedule schedule);

}
