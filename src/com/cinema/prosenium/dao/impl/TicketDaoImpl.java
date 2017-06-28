package com.cinema.prosenium.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.cinema.prosenium.dao.TicketDao;
import com.cinema.prosenium.entity.Ticket;
import com.cinema.util.DBHelper;

public class TicketDaoImpl extends DBHelper implements TicketDao {

	@Override
	public int addTickets(Ticket ticket) {
		SqlSession sqlSession = this.getSqlSession(true);
		String stm = "com.cinema.prosenium.mapping.ticketMapper.addTicket";
		int result = sqlSession.update(stm, ticket);
		sqlSession.close();
		return result;
	}

	@Override
	public List<Ticket> queryScheduleIdTicket(int scheduleItemId) {
		SqlSession sqlSession = this.getSqlSession();
		String stm = "com.cinema.prosenium.mapping.ticketMapper.queryScheduleIdTicket";
		List<Ticket> tickets = sqlSession.selectList(stm, scheduleItemId);
		sqlSession.close();
		return tickets;
	}

}
