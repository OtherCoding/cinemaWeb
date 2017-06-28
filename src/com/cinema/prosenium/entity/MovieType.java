package com.cinema.prosenium.entity;
/**
 * 电影类
 * @author Administrator
 *
 */
public class MovieType {
	/**
	 * 电影类型id
	 */
	private int movieTypeId;
	/**
	 * 电影类型
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
