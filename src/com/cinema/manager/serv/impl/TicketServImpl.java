package com.cinema.manager.serv.impl;

import java.util.List;

import com.cinema.manager.dao.TicketDao;
import com.cinema.manager.dao.impl.TicketDaoImpl;
import com.cinema.manager.serv.TicketServ;
import com.cinema.prosenium.entity.Ticket;

public class TicketServImpl implements TicketServ {
	private TicketDao ticketDao = new TicketDaoImpl();

	@Override
	public List<Ticket> queryTicketAll() {
		
		return ticketDao.queryTicketAll();
	}
}
