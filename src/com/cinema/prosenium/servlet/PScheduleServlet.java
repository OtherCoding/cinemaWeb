package com.cinema.prosenium.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cinema.prosenium.entity.Schedule;
import com.cinema.prosenium.serv.ScheduleServ;
import com.cinema.prosenium.serv.impl.ScheduleServImpl;

/**
 * Servlet implementation class PScheduleServlet
 */
@WebServlet("/PScheduleServlet")
public class PScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PScheduleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("收到前台场次请求");
		HttpSession session = request.getSession();

		/***************************场次**********************************************/
		//根据电影id查询场次
		ScheduleServ scheduleServ = new ScheduleServImpl();
		List<Schedule> scheduleList =null;
		if(request.getParameter("movieId")!=null){
			
			int movieId = Integer.valueOf(request.getParameter("movieId"));
			scheduleList = scheduleServ.queryMovieIdSchedule(movieId);
			session.setAttribute("scheduleList", scheduleList);
			
			System.out.println(scheduleList.get(0).getVideoHall().getVideoHallType().getVideoHallType());
			response.sendRedirect("before_schedule.jsp");
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
