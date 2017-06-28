package com.cinema.prosenium.serv;

import java.util.List;

import com.cinema.prosenium.entity.Ticket;

public interface TicketServ {

	int addTickets(Ticket ticket);

	void printTicket(Ticket ticket);

	List<Ticket> queryScheduleIdTicket(int scheduleItemId);

}
