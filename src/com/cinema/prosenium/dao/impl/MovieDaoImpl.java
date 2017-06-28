package com.cinema.prosenium.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.cinema.prosenium.dao.MovieDao;
import com.cinema.prosenium.entity.Movie;
import com.cinema.prosenium.entity.PageBean;
import com.cinema.util.DBHelper;

public class MovieDaoImpl extends DBHelper implements MovieDao {
	
	@Override
	public List<Movie> queryMoviePage(PageBean pageBean) {
		SqlSession sqlSession = this.getSqlSession();
		String stm = "com.cinema.prosenium.mapping.movieMapper.queryMoviePage";
		
		List<Movie> movieList = sqlSession.selectList(stm,pageBean);
		sqlSession.close();
		return movieList;
	}

	@Override
	public int queryMovieCount() {
		SqlSession sqlSession = this.getSqlSession();
		String stm = "com.cinema.prosenium.mapping.movieMapper.queryMovieCount";
		int queryMovieCount = sqlSession.selectOne(stm);
		sqlSession.close();
		return queryMovieCount;
	}



}
