package com.cinema.prosenium.serv.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.cinema.prosenium.entity.Movie;
import com.cinema.prosenium.entity.PageBean;
import com.cinema.prosenium.dao.MovieDao;
import com.cinema.prosenium.dao.impl.MovieDaoImpl;
import com.cinema.prosenium.serv.MovieServ;

public class MovieServImpl implements MovieServ {
	private static Logger logger = Logger.getLogger(MovieServImpl.class);
	private MovieDao movieDao = new MovieDaoImpl();
	@Override
	public List<Movie> queryMoviePage(PageBean pageBean) {
		//¼ÆËã×ÜÒ³Êý
		if(pageBean.getTotalCount() % pageBean.getPageSize()==0){
			pageBean.setTotalPageCount(pageBean.getTotalCount() / pageBean.getPageSize());
		}else{
			pageBean.setTotalPageCount(pageBean.getTotalCount() / pageBean.getPageSize() + 1);
		}
		
		logger.info("MovieServImpl:CurrPageNo:"+pageBean.getCurrPageNo());
		
		return movieDao.queryMoviePage(pageBean);
	}
	@Override
	public int queryMovieCount() {
		return movieDao.queryMovieCount();
	}


}
