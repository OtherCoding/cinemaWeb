package com.cinema.prosenium.entity;

import java.io.Serializable;

/**
 * ��Ӱ����
 * @author Administrator
 *
 */
public class Movie  implements Serializable{
	
	private static final long serialVersionUID = 7260003158171437080L;
	
	/**
	 * ��Ӱid
	 */
	private int movieId;
	/**
	 * ��Ӱ����
	 */
	private String movieName;
	/**
	 * Ӣ������
	 */
	
	private String moviePoster;
	/**
	 * ����
	 */
	private String movieDirector;
	/**
	 * ��Ա
	 */
	private String movieActor;
	/**
	 * ��Ӱ���ͣ�����������������һ��
	 */
	private MovieType movieType;
	/**
	 * �۸�
	 */
	
	
	private double moviePrice;
	/**
	 * ��ӰͼƬ·��
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
