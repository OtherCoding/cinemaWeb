package com.cinema.prosenium.entity;
/**
 * Ʊ����
 * @author Administrator
 *
 */
public class TicketType {
	//Ʊ���ͱ��
	private int ticketTypeId;
	//Ʊ����
	private String ticketType;
	//Ʊ�ۿ�
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
