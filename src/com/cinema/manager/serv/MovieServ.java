package com.cinema.manager.serv;

import java.util.List;

import com.cinema.prosenium.entity.Movie;

public interface MovieServ {

	List<Movie> queryMovieAll();

	int addMovie(Movie movie);

	int editorMovie(Movie editorMovie);

	int deleteMovie(int deleteMovieId);
	//根据电影id,查电影
	Movie queryMovie(int addScheduleMovieId);

}
