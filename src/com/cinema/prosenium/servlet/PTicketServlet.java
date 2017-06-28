package com.cinema.prosenium.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.cinema.prosenium.entity.Schedule;
import com.cinema.prosenium.entity.Ticket;
import com.cinema.prosenium.serv.ScheduleServ;
import com.cinema.prosenium.serv.TicketServ;
import com.cinema.prosenium.serv.impl.ScheduleServImpl;
import com.cinema.prosenium.serv.impl.TicketServImpl;

/**
 * Servlet implementation class ProseniumTicketServlet
 * ͨ��������Σ�������λͼ
 */
@WebServlet("/PTicketServlet")
public class PTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PTicketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger logger = Logger.getLogger(PTicketServlet.class);
		int scheduleItemId = Integer.valueOf(request.getParameter("scheduleItemId"));
		
		ScheduleServ scheduleServ = new ScheduleServImpl();
		
		HttpSession session = request.getSession();
		//ͨ������id���
		//request.get
		Schedule schedule = scheduleServ.queryScheduleIdSchedule(scheduleItemId);
		System.out.println("PTicketServlet:"+schedule.getMovie().getMovieType().getMovieType());
		
		//���ݳ��β�����иó��ε��Ѿ������Ʊ��
		TicketServ ticketServ = new TicketServImpl();
		List<Ticket> tickets = ticketServ.queryScheduleIdTicket(scheduleItemId);
		logger.info("PTicketServlet:Ʊ��������"+tickets.size());
		if(scheduleItemId != 0){
			session.setAttribute("schedule", schedule);
			session.setAttribute("tickets", tickets);
			response.sendRedirect("before_ticket.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
