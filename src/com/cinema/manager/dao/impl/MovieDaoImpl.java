package com.cinema.manager.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.cinema.manager.dao.MovieDao;
import com.cinema.prosenium.entity.Movie;
import com.cinema.util.DBHelper;

public class MovieDaoImpl extends DBHelper implements MovieDao {

	@Override
	public List<Movie> queryMovieAll() {
		SqlSession sqlSession = this.getSqlSession();
		String stm ="com.cinema.manager.mapping.movieMapper.queryMovieAll";
		List<Movie> movieList = sqlSession.selectList(stm);
		sqlSession.close();
		
		return movieList;
	}
	//添加电影
	@Override
	public int addMovie(Movie movie) {
		SqlSession sqlSession = this.getSqlSession(true);
		String stm ="com.cinema.manager.mapping.movieMapper.addMovie";
		int result = sqlSession.update(stm,movie);
		sqlSession.close();
		return result;
	}
	
	@Override
	public int deleteMovie(int deleteMovieId) {
		SqlSession sqlSession = this.getSqlSession(true);
		String stm ="com.cinema.manager.mapping.movieMapper.deleteMovie";
		int result = sqlSession.update(stm,deleteMovieId);
		sqlSession.close();
		return result;
	}

	@Override
	public int editorMovie(Movie editorMovie) {
		SqlSession sqlSession = this.getSqlSession(true);
		String stm ="com.cinema.manager.mapping.movieMapper.editorMovie";
		int result = sqlSession.update(stm,editorMovie);
		sqlSession.close();
		return result;
	}
	//根据电影id查电影
	@Override
	public Movie queryMovie(int addScheduleMovieId) {
		SqlSession sqlSession = this.getSqlSession();
		String stm ="com.cinema.manager.mapping.movieMapper.queryMovie";
		Movie movie = sqlSession.selectOne(stm,addScheduleMovieId);
		sqlSession.close();
		
		return movie;
	}

}
