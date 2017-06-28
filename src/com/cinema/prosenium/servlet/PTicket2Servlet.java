package com.cinema.prosenium.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cinema.prosenium.entity.Schedule;
import com.cinema.prosenium.entity.Ticket;
import com.cinema.prosenium.entity.TicketType;
import com.cinema.prosenium.serv.ScheduleServ;
import com.cinema.prosenium.serv.TicketServ;
import com.cinema.prosenium.serv.impl.ScheduleServImpl;
import com.cinema.prosenium.serv.impl.TicketServImpl;

/**
 * Servlet implementation class PTicket2Servlet
 */
@WebServlet("/PTicket2Servlet")
public class PTicket2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PTicket2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//场次编号
		int scheduleItemId = Integer.valueOf(request.getParameter("scheduleItemId"));
		ScheduleServ scheduleServ = new ScheduleServImpl();
		Schedule schedule = scheduleServ.queryScheduleIdSchedule(scheduleItemId);
		
		//座位编号
		String [] seats = request.getParameterValues("seat_no");
		//票价格
		double ticketPrice = Double.valueOf(request.getParameter("ticketPrice"));
		//向数据库添加票数据
		TicketServ ticketServ = new TicketServImpl();
		for (String seatno : seats) {
			
			System.out.println(seatno);//票座位
			Ticket ticket = new Ticket(0,schedule,seatno,ticketPrice,new TicketType(0, "普通票", 1));
			int result = ticketServ.addTickets(ticket);
			if(result!=0){
				System.out.println(result+"条数据添加成功");
				//出票
				ticketServ.printTicket(ticket);
				
				System.out.println("PTicket2Servlet:"+scheduleItemId);
				
			}else{
				System.out.println("出票失败");
			}
		}
		session.setAttribute("scheduleItemId", scheduleItemId);
		response.sendRedirect("ticket_successprocess.jsp");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
