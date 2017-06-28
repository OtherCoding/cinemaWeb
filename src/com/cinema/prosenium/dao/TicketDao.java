package com.cinema.prosenium.dao;

import java.util.List;

import com.cinema.prosenium.entity.Ticket;

public interface TicketDao {

	int addTickets(Ticket ticket);

	List<Ticket> queryScheduleIdTicket(int scheduleItemId);

}
