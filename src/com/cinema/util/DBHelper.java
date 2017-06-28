package com.cinema.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBHelper {

	private SqlSessionFactory sqlSessionFactory(){
		InputStream is = DBHelper.class.getClassLoader().getResourceAsStream("conf.xml");
		
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is); 
		return sqlSessionFactory;
	}
	
	public  SqlSession getSqlSession(){
		
		return sqlSessionFactory().openSession();
	}
	
	public SqlSession getSqlSession(boolean flag){
		return sqlSessionFactory().openSession(true);
	}
}
