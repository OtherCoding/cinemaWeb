package com.cinema.prosenium.entity;

import java.io.Serializable;

/**
 * 电影类型
 * @author Administrator
 *
 */
public class Movie  implements Serializable{
	
	private static final long serialVersionUID = 7260003158171437080L;
	
	/**
	 * 电影id
	 */
	private int movieId;
	/**
	 * 电影名称
	 */
	private String movieName;
	/**
	 * 英文名称
	 */
	
	private String moviePoster;
	/**
	 * 导演
	 */
	private String movieDirector;
	/**
	 * 演员
	 */
	private String movieActor;
	/**
	 * 电影类型？？？？这里再来改一下
	 */
	private MovieType movieType;
	/**
	 * 价格
	 */
	
	
	private double moviePrice;
	/**
	 * 电影图片路径
	 */
	private String movieImgPath;
	private String movieInfo;
	
	
	public Movie(int movieId, String movieName, String moviePoster, String movieDirector, String movieActor,
			MovieType movieType, double moviePrice, String movieImgPath, String movieInfo) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.moviePoster = moviePoster;
		this.movieDirector = movieDirector;
		this.movieActor = movieActor;
		this.movieType = movieType;
		this.moviePrice = moviePrice;
		this.movieImgPath = movieImgPath;
		this.movieInfo = movieInfo;
	}




	public String getMovieActor() {
		return movieActor;
	}




	public void setMovieActor(String movieActor) {
		this.movieActor = movieActor;
	}




	public String getMovieImgPath() {
		return movieImgPath;
	}




	public void setMovieImgPath(String movieImgPath) {
		this.movieImgPath = movieImgPath;
	}




	public Movie() {
		super();
	}

	





	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMoviePoster() {
		return moviePoster;
	}
	public void setMoviePoster(String moviePoster) {
		this.moviePoster = moviePoster;
	}
	public String getMovieDirector() {
		return movieDirector;
	}
	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}
	public String getMoviePlayer() {
		return movieActor;
	}
	public void setMoviePlayer(String movieActor) {
		this.movieActor = movieActor;
	}
	

	public MovieType getMovieType() {
		return movieType;
	}


	public void setMovieType(MovieType movieType) {
		this.movieType = movieType;
	}

	public double getMoviePrice() {
		return moviePrice;
	}
	public void setMoviePrice(double moviePrice) {
		this.moviePrice = moviePrice;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	public String getMovieInfo() {
		return movieInfo;
	}




	public void setMovieInfo(String movieInfo) {
		this.movieInfo = movieInfo;
	}
	
	

}
