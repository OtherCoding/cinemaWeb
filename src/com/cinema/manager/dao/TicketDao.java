package com.cinema.manager.dao;

import java.util.List;

import com.cinema.prosenium.entity.Ticket;

public interface TicketDao {

	List<Ticket> queryTicketAll();

}
