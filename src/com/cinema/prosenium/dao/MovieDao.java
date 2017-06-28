package com.cinema.prosenium.dao;

import java.util.List;

import com.cinema.prosenium.entity.Movie;
import com.cinema.prosenium.entity.PageBean;

public interface MovieDao {

	List<Movie> queryMoviePage(PageBean pageBean);

	int queryMovieCount();



}
