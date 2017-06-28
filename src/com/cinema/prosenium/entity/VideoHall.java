package com.cinema.prosenium.entity;

/**
 * ��ӳ����
 * 
 * @author Administrator
 *
 */
public class VideoHall {
	// ��ӳ�����
	private int videoHallId;
	// ��ӳ�����ͱ��
	private VideoHallType videoHallType;
	// ��λ��
	private int videoHallSeatNum;
	// ��λ����
	private int videoHallSeatRows;
	// ��λ����
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
