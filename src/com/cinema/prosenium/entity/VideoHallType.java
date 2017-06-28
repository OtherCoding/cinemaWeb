package com.cinema.prosenium.entity;
/**
 * 放映厅类型类
 * @author Administrator
 *
 */
public class VideoHallType {
	//放映厅类型编号
	private int videoHallTypeId;
	//放映厅类型
	private String videoHallType;
	public VideoHallType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VideoHallType(int videoHallTypeId, String videoHallType) {
		super();
		this.videoHallTypeId = videoHallTypeId;
		this.videoHallType = videoHallType;
	}
	public int getVideoHallTypeId() {
		return videoHallTypeId;
	}
	public void setVideoHallTypeId(int videoHallTypeId) {
		this.videoHallTypeId = videoHallTypeId;
	}
	public String getVideoHallType() {
		return videoHallType;
	}
	public void setVideoHallType(String videoHallType) {
		this.videoHallType = videoHallType;
	}

	
}
