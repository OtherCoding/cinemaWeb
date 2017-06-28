package com.cinema.manager.dao;

import java.util.List;

import com.cinema.prosenium.entity.Movie;

public interface MovieDao {


	List<Movie> queryMovieAll();

	int addMovie(Movie movie);

	int deleteMovie(int deleteMovieId);

	int editorMovie(Movie editorMovie);
	//根据电影id查电影
	Movie queryMovie(int addScheduleMovieId);

}
