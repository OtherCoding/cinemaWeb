package com.cinema.prosenium.entity;

import java.sql.Date;
import java.sql.Time;

/**
 * ����
 * @author Administrator
 *
 */
public class Schedule {
	/**
	 * ����id
	 */
	private int scheduleItemId;
	/**
	 * ��Ӱ
	 */
	private Movie movie;
	/**
	 * ����ʱ��
	 */
	private Time scheduleItemTime;
	/**
	 * ��ӳ��
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
