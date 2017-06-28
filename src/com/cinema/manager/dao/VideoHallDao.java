package com.cinema.manager.dao;

import java.util.List;

import com.cinema.prosenium.entity.VideoHall;

public interface VideoHallDao {

	List<VideoHall> queryVideoHallAll();

	int deleteVideoHall(int deleteVideoHallId);

	VideoHall queryVideoHall(int addScheduleVideoHallId);

	int addVideoHall(VideoHall videoHall);

	int editorVideoHall(VideoHall videoHall);

}
