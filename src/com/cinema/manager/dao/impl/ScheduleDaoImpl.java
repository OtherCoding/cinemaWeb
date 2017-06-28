package com.cinema.manager.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.cinema.manager.dao.ScheduleDao;
import com.cinema.prosenium.entity.Schedule;
import com.cinema.util.DBHelper;

public class ScheduleDaoImpl extends DBHelper implements ScheduleDao {

	@Override
	public List<Schedule> queryScheduleAll() {
		SqlSession sqlSession = this.getSqlSession();
		String stm = "com.cinema.manager.mapping.scheduleMapper.queryScheduleAll";
		List<Schedule> scheduleList = sqlSession.selectList(stm);
		sqlSession.close();
		return scheduleList;
	}

	@Override
	public int deleteSchedule(int scheduleItemId) {
		SqlSession sqlSession = this.getSqlSession(true);
		String stm = "com.cinema.manager.mapping.scheduleMapper.deleteSchedule";
		int result = sqlSession.update(stm,scheduleItemId);
		sqlSession.close();
		return result;
	}

	@Override
	public List<Schedule> queryMovieIdSchedule(int movieId) {
		SqlSession sqlSession = this.getSqlSession();
		String stm = "com.cinema.manager.mapping.scheduleMapper.queryMovieIdSchedule";
		List<Schedule> scheduleList = sqlSession.selectList(stm, movieId);
		sqlSession.close();
		return scheduleList;
	}

	@Override
	public int addSchedule(Schedule schedule) {
		SqlSession sqlSession = this.getSqlSession(true);
		String stm = "com.cinema.manager.mapping.scheduleMapper.addSchedule";
		int result = sqlSession.insert(stm,schedule);
		sqlSession.close();
		return result;
	}

	@Override
	public int editorSchedule(Schedule schedule) {
		SqlSession sqlSession = this.getSqlSession(true);
		String stm = "com.cinema.manager.mapping.scheduleMapper.editorSchedule";
		int result = sqlSession.update(stm,schedule);
		sqlSession.close();
		return result;
	}
	

}
