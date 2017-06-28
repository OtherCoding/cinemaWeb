package com.cinema.manager.serv.impl;

import java.util.List;

import com.cinema.manager.dao.VideoHallDao;
import com.cinema.manager.dao.impl.VideoHallDaoImpl;
import com.cinema.manager.serv.VideoHallServ;
import com.cinema.prosenium.entity.VideoHall;

public class VideoHallServImpl implements VideoHallServ {
	VideoHallDao videoHallDao = new VideoHallDaoImpl();

	@Override
	public List<VideoHall> queryVideoHallAll() {
		
		return videoHallDao.queryVideoHallAll();
	}


	@Override
	public int deleteVideoHall(int deleteVideoHallId) {

		return videoHallDao.deleteVideoHall(deleteVideoHallId);
	}


	@Override
	public VideoHall queryVideoHall(int addScheduleVideoHallId) {
		
		return videoHallDao.queryVideoHall(addScheduleVideoHallId);
	}


	@Override
	public int addVideoHall(VideoHall videoHall) {
		
		return videoHallDao.addVideoHall(videoHall);
	}


	@Override
	public int editorVideoHall(VideoHall videoHall) {
		
		return videoHallDao.editorVideoHall(videoHall);
	}
	
	
}
