package com.cinema.prosenium.entity;

import java.sql.Date;
import java.sql.Time;

/**
 * 场次
 * @author Administrator
 *
 */
public class Schedule {
	/**
	 * 场次id
	 */
	private int scheduleItemId;
	/**
	 * 电影
	 */
	private Movie movie;
	/**
	 * 场次时间
	 */
	private Time scheduleItemTime;
	/**
	 * 放映厅
	 */
	private VideoHall videoHall;
	public Schedule() {
		super();
	}

	
	
	public Schedule(int scheduleItemId, Movie movie, Time scheduleItemTime, VideoHall videoHall) {
		super();
		this.scheduleItemId = scheduleItemId;
		this.movie = movie;
		this.scheduleItemTime = scheduleItemTime;
		this.videoHall = videoHall;
	}



	public int getScheduleItemId() {
		return scheduleItemId;
	}
	public void setScheduleItemId(int scheduleItemId) {
		this.scheduleItemId = scheduleItemId;
	}

	public Time getScheduleItemTime() {
		return scheduleItemTime;
	}
	public void setScheduleItemTime(Time scheduleItemTime) {
		this.scheduleItemTime = scheduleItemTime;
	}



	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public VideoHall getVideoHall() {
		return videoHall;
	}



	public void setVideoHall(VideoHall videoHall) {
		this.videoHall = videoHall;
	}

	
	

}
