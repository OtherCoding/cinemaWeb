package com.cinema.prosenium.serv.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.util.List;

import org.apache.log4j.Logger;

import com.cinema.prosenium.dao.TicketDao;
import com.cinema.prosenium.dao.impl.TicketDaoImpl;
import com.cinema.prosenium.entity.Ticket;
import com.cinema.prosenium.serv.TicketServ;

public class TicketServImpl implements TicketServ {
	private Logger logger = Logger.getLogger(TicketServImpl.class); 
	TicketDao ticketDao = new TicketDaoImpl();
	@Override
	public int addTickets(Ticket ticket) {
		return ticketDao.addTickets(ticket);
	}
	//��ӡƱ
	@Override
	public void printTicket(Ticket ticket) {
		String path = "E:\\ticket\\";
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
		String[] timestr = new String[3];//ʱ���ȡ���ŵ�����
		
		String movieName = ticket.getSchedule().getMovie().getMovieName();
		String seatNo = ticket.getSeatNo();
		Time scheduleItemTime = ticket.getSchedule().getScheduleItemTime(); 
		int videoHallId = ticket.getSchedule().getVideoHall().getVideoHallId();
		String videoHallType = ticket.getSchedule().getVideoHall().getVideoHallType().getVideoHallType();
		
		timestr = scheduleItemTime.toString().split(":");
		
		path = "E:\\ticket\\"+ticket.getTicketType().getTicketType()
				+" " +  movieName
				+ " " + seatNo +" "  + timestr[0] +"ʱ" + timestr[1]
				+ "��.txt";
		
		try {
			FileWriter fw = new FileWriter(path);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("*************************************");
			bw.newLine();
			bw.write("\t\tСС��ӰԺ");
			bw.newLine();
			bw.write("-------------------------------------");
			bw.newLine();
			bw.write("��Ӱ����:\t" + movieName);
			bw.newLine();
			bw.write("ʱ��:\t\t" + scheduleItemTime);
			bw.newLine();
			bw.write("�۸�:\t\t" + ticket.getTicketPrice());
			bw.newLine();
			bw.write("��ӳ�����:\t" + videoHallId);
			bw.newLine();
			bw.write("��ӳ������:\t" + videoHallType);
			bw.newLine();
			bw.write("��λ��:\t\t" + ticket.getSeatNo());
			bw.newLine();
			bw.write("*************************************");
			logger.info("TicketServImpl:Ʊ�Ѿ���ӡ��");
			bw.flush();
			fw.flush();
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	@Override
	public List<Ticket> queryScheduleIdTicket(int scheduleItemId) {
		
		return ticketDao.queryScheduleIdTicket(scheduleItemId);
	}

}
