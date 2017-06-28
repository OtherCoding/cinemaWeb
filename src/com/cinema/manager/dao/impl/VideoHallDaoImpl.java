package com.cinema.manager.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.cinema.manager.dao.VideoHallDao;
import com.cinema.prosenium.entity.VideoHall;
import com.cinema.util.DBHelper;

public class VideoHallDaoImpl extends DBHelper implements VideoHallDao {

	@Override
	public List<VideoHall> queryVideoHallAll() {
		SqlSession sqlSession = this.getSqlSession();
		String stm = "com.cinema.manager.mapping.videoHallMapper.queryVideoHallAll";
		List<VideoHall> videoHallList = sqlSession.selectList(stm);
		sqlSession.close();
		return videoHallList;
	}


	@Override
	public int deleteVideoHall(int deleteVideoHallId) {
		SqlSession sqlSession = this.getSqlSession(true);
		String stm = "com.cinema.manager.mapping.videoHallMapper.deleteVideoHall";
		int result = sqlSession.update(stm,deleteVideoHallId);
		sqlSession.close();
		return result;
	}


	@Override
	public VideoHall queryVideoHall(int addScheduleVideoHallId) {
		SqlSession sqlSession = this.getSqlSession();
		String stm = "com.cinema.manager.mapping.videoHallMapper.queryVideoHall";
		VideoHall videoHall = sqlSession.selectOne(stm,addScheduleVideoHallId);
		sqlSession.close();
		return videoHall;
	}


	@Override
	public int addVideoHall(VideoHall videoHall) {
		SqlSession sqlSession = this.getSqlSession(true);
		String stm = "com.cinema.manager.mapping.videoHallMapper.addVideoHall";
		int result = sqlSession.insert(stm,videoHall);
		sqlSession.close();
		return result;
	}


	@Override
	public int editorVideoHall(VideoHall videoHall) {
		SqlSession sqlSession = this.getSqlSession(true);
		String stm = "com.cinema.manager.mapping.videoHallMapper.editorVideoHall";
		int result = sqlSession.insert(stm,videoHall);
		sqlSession.close();
		return result;
	}
	


}
