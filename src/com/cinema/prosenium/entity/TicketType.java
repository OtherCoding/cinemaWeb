package com.cinema.prosenium.entity;
/**
 * 票类型
 * @author Administrator
 *
 */
public class TicketType {
	//票类型编号
	private int ticketTypeId;
	//票类型
	private String ticketType;
	//票折扣
	private double ticketDiscount;
	public TicketType() {
		super();
	}
	public TicketType(int ticketTypeId, String ticketType, double ticketDiscount) {
		super();
		this.ticketTypeId = ticketTypeId;
		this.ticketType = ticketType;
		this.ticketDiscount = ticketDiscount;
	}
	public int getTicketTypeId() {
		return ticketTypeId;
	}
	public void setTicketTypeId(int ticketTypeId) {
		this.ticketTypeId = ticketTypeId;
	}
	public String getTicketType() {
		return ticketType;
	}
	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}
	public double getTicketDiscount() {
		return ticketDiscount;
	}
	public void setTicketDiscount(double ticketDiscount) {
		this.ticketDiscount = ticketDiscount;
	}

	
}
