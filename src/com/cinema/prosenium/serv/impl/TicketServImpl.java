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
	//打印票
	@Override
	public void printTicket(Ticket ticket) {
		String path = "E:\\ticket\\";
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
		String[] timestr = new String[3];//时间截取后存放的数组
		
		String movieName = ticket.getSchedule().getMovie().getMovieName();
		String seatNo = ticket.getSeatNo();
		Time scheduleItemTime = ticket.getSchedule().getScheduleItemTime(); 
		int videoHallId = ticket.getSchedule().getVideoHall().getVideoHallId();
		String videoHallType = ticket.getSchedule().getVideoHall().getVideoHallType().getVideoHallType();
		
		timestr = scheduleItemTime.toString().split(":");
		
		path = "E:\\ticket\\"+ticket.getTicketType().getTicketType()
				+" " +  movieName
				+ " " + seatNo +" "  + timestr[0] +"时" + timestr[1]
				+ "分.txt";
		
		try {
			FileWriter fw = new FileWriter(path);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("*************************************");
			bw.newLine();
			bw.write("\t\t小小鹏影院");
			bw.newLine();
			bw.write("-------------------------------------");
			bw.newLine();
			bw.write("电影名称:\t" + movieName);
			bw.newLine();
			bw.write("时间:\t\t" + scheduleItemTime);
			bw.newLine();
			bw.write("价格:\t\t" + ticket.getTicketPrice());
			bw.newLine();
			bw.write("放映厅编号:\t" + videoHallId);
			bw.newLine();
			bw.write("放映厅类型:\t" + videoHallType);
			bw.newLine();
			bw.write("座位号:\t\t" + ticket.getSeatNo());
			bw.newLine();
			bw.write("*************************************");
			logger.info("TicketServImpl:票已经打印好");
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
