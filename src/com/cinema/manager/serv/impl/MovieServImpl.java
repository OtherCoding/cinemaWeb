package com.cinema.manager.serv.impl;

import java.util.List;

import com.cinema.manager.dao.MovieDao;
import com.cinema.manager.dao.impl.MovieDaoImpl;
import com.cinema.manager.serv.MovieServ;
import com.cinema.prosenium.entity.Movie;

public class MovieServImpl implements MovieServ {
	MovieDao movieDao = new MovieDaoImpl();
	@Override
	public List<Movie> queryMovieAll() {
		return movieDao.queryMovieAll();
	}
	@Override
	public int addMovie(Movie movie) {
		
		return movieDao.addMovie(movie);
	}
	@Override
	public int deleteMovie(int deleteMovieId) {
		return movieDao.deleteMovie(deleteMovieId);
	}

	@Override
	public int editorMovie(Movie editorMovie) {
		return movieDao.editorMovie(editorMovie);
	}
	//根据电影id查电影
	@Override
	public Movie queryMovie(int addScheduleMovieId) {
		
		return movieDao.queryMovie(addScheduleMovieId);
	}

}
