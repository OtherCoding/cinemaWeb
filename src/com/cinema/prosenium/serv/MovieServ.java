package com.cinema.prosenium.serv;

import java.util.List;

import com.cinema.prosenium.entity.Movie;
import com.cinema.prosenium.entity.PageBean;

public interface MovieServ {

	List<Movie> queryMoviePage(PageBean pageBean);

	int queryMovieCount();


	

}
