package com.cinema.prosenium.entity;
/**
 * ��ӳ��������
 * @author Administrator
 *
 */
public class VideoHallType {
	//��ӳ�����ͱ��
	private int videoHallTypeId;
	//��ӳ������
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
