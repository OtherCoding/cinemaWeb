package com.cinema.prosenium.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.cinema.prosenium.dao.ScheduleDao;
import com.cinema.prosenium.entity.Schedule;
import com.cinema.prosenium.entity.User;
import com.cinema.util.DBHelper;

public class ScheduleDaoImpl extends DBHelper implements ScheduleDao {
	//根据电影id 查出场次
	@Override
	public List<Schedule> queryMovieIdSchedule(int movieId) {
		SqlSession sqlSession = this.getSqlSession();
		String stm = "com.cinema.prosenium.mapping.scheduleMapper.queryMovieIdSchedule";
	
		List<Schedule> scheduleList = sqlSession.selectList(stm, movieId);
		sqlSession.close();
		return scheduleList;
	}

	@Override
	public Schedule queryScheduleIdSchedule(int scheduleItemId) {
		SqlSession sqlSession = this.getSqlSession();
		String stm = "com.cinema.prosenium.mapping.scheduleMapper.queryScheduleIdSchedule";
		Schedule schedule = sqlSession.selectOne(stm, scheduleItemId);
		sqlSession.close();
		return schedule;
	}

}
