package com.cinema.manager.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.cinema.manager.serv.TicketServ;
import com.cinema.manager.serv.impl.TicketServImpl;
import com.cinema.prosenium.entity.Ticket;


/**
 * Servlet implementation class ManagerTicketServlet
 */
@WebServlet("/ManagerTicketServlet")
public class ManagerTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(ManagerTicketServlet.class);   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerTicketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("ManagerTicketServlet:票管理收到请求");
		HttpSession session = request.getSession(); 
		TicketServ ticketServ = new TicketServImpl();
		
		/******************************查全部用户*****************************/
		List<Ticket> ticketList = new ArrayList<Ticket>();
		ticketList = ticketServ.queryTicketAll();

		if(ticketList != null){
			session.setAttribute("ticketList", ticketList);
			logger.info("ManagerTicketServlet->后台票数量："+ticketList.size());			
			response.sendRedirect("after_ticketManager.jsp");
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
