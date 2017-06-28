package com.cinema.manager.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.cinema.manager.dao.TicketDao;
import com.cinema.prosenium.entity.Schedule;
import com.cinema.prosenium.entity.Ticket;
import com.cinema.util.DBHelper;

public class TicketDaoImpl extends DBHelper implements TicketDao {

	@Override
	public List<Ticket> queryTicketAll() {
		SqlSession sqlSession = this.getSqlSession();
		String stm = "com.cinema.manager.mapping.ticketMapper.queryTicketAll";
		List<Ticket> ticketList = sqlSession.selectList(stm);
		sqlSession.close();
		return ticketList;
	}
	
}
