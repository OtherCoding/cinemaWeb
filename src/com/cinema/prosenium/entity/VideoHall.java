package com.cinema.prosenium.entity;

/**
 * 放映厅类
 * 
 * @author Administrator
 *
 */
public class VideoHall {
	// 放映厅编号
	private int videoHallId;
	// 放映厅类型编号
	private VideoHallType videoHallType;
	// 座位数
	private int videoHallSeatNum;
	// 座位行数
	private int videoHallSeatRows;
	// 座位列数
	private int videoHallSeatCols;

	public VideoHall() {
		super();
	}

	public VideoHall(int videoHallId, VideoHallType videoHallType, int videoHallSeatNum, int videoHallSeatRows,
			int videoHallSeatCols) {
		super();
		this.videoHallId = videoHallId;
		this.videoHallType = videoHallType;
		this.videoHallSeatNum = videoHallSeatNum;
		this.videoHallSeatRows = videoHallSeatRows;
		this.videoHallSeatCols = videoHallSeatCols;
	}

	public int getVideoHallId() {
		return videoHallId;
	}

	public void setVideoHallId(int videoHallId) {
		this.videoHallId = videoHallId;
	}

	public VideoHallType getVideoHallTypeId() {
		return videoHallType;
	}

	public void setVideoHallTypeId(VideoHallType videoHallType) {
		this.videoHallType = videoHallType;
	}

	public int getVideoHallSeatNum() {
		return videoHallSeatNum;
	}

	public void setVideoHallSeatNum(int videoHallSeatNum) {
		this.videoHallSeatNum = videoHallSeatNum;
	}

	public int getVideoHallSeatRows() {
		return videoHallSeatRows;
	}

	public void setVideoHallSeatRows(int videoHallSeatRows) {
		this.videoHallSeatRows = videoHallSeatRows;
	}

	public int getVideoHallSeatCols() {
		return videoHallSeatCols;
	}

	public void setVideoHallSeatCols(int videoHallSeatCols) {
		this.videoHallSeatCols = videoHallSeatCols;
	}

	public VideoHallType getVideoHallType() {
		return videoHallType;
	}

	public void setVideoHallType(VideoHallType videoHallType) {
		this.videoHallType = videoHallType;
	}

	
}
