package com.cinema.prosenium.entity;
/**
 * Æ±
 * @author Administrator
 *
 */
public class Ticket {
	//Æ±±àºÅ
	private int ticketId;
	//³¡´Î±àºÅ
	private Schedule schedule;
	//×ùÎ»±àºÅ
	private String seatNo;
	//Æ±¼Û¸ñ
	private double ticketPrice;
	//Æ±ÀàÐÍ±àºÅ
	private TicketType ticketType;
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Ticket(int ticketId, Schedule schedule, String seatNo, double ticketPrice, TicketType ticketType) {
		super();
		this.ticketId = ticketId;
		this.schedule = schedule;
		this.seatNo = seatNo;
		this.ticketPrice = ticketPrice;
		this.ticketType = ticketType;
	}


	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public String getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}
	public double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	public Schedule getSchedule() {
		return schedule;
	}


	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}


	public TicketType getTicketType() {
		return ticketType;
	}


	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}



}
