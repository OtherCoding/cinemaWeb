package com.cinema.prosenium.entity;
/**
 * ��Ӱ��
 * @author Administrator
 *
 */
public class MovieType {
	/**
	 * ��Ӱ����id
	 */
	private int movieTypeId;
	/**
	 * ��Ӱ����
	 */
	private String movieType;
	public MovieType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MovieType(int movieTypeId, String movieType) {
		super();
		this.movieTypeId = movieTypeId;
		this.movieType = movieType;
	}
	public int getMovieTypeId() {
		return movieTypeId;
	}
	public void setMovieTypeId(int movieTypeId) {
		this.movieTypeId = movieTypeId;
	}
	public String getMovieType() {
		return movieType;
	}
	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}
	
	

}
