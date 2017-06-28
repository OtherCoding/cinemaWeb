package com.cinema.manager.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.cinema.manager.serv.MovieServ;
import com.cinema.manager.serv.ScheduleServ;
import com.cinema.manager.serv.VideoHallServ;
import com.cinema.manager.serv.impl.MovieServImpl;
import com.cinema.manager.serv.impl.ScheduleServImpl;
import com.cinema.manager.serv.impl.VideoHallServImpl;
import com.cinema.prosenium.entity.Movie;
import com.cinema.prosenium.entity.Schedule;
import com.cinema.prosenium.entity.VideoHall;


/**
 * Servlet implementation class ManagerScheduleServlet
 */
@WebServlet("/ManagerScheduleServlet")
public class ManagerScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(ManagerScheduleServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerScheduleServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("ManagerScheduleServlet->�յ���̨��������");
		ScheduleServ scheduleServ = new ScheduleServImpl();
		MovieServ movieServ = new MovieServImpl();
		VideoHallServ videoHallServ = new VideoHallServImpl();
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("UTF-8");
		/******************************��ӳ���******************************/
		//��ѯ���е�Ӱ
		List<Movie> movieList = new ArrayList<Movie>();
		movieList = movieServ.queryMovieAll();
		if(movieList != null){
			session.setAttribute("movieList", movieList);
		}	
		//��ѯ����Ӱ��(����ӵ�Ӱ��ѡ��)
		videoHallServ = new VideoHallServImpl();
		List<VideoHall> videoHallList = new ArrayList<VideoHall>();
		videoHallList = videoHallServ.queryVideoHallAll();
		if(videoHallList != null){
			session.setAttribute("videoHallList", videoHallList);
			logger.info("ManagerScheduleServlet->��̨Ӱ��������"+videoHallList.size());
		}
		if(request.getParameter("addScheduleMovieId")!=null){	
			logger.info("ManagerScheduleServlet->��ʼ��ӳ���");
			int addScheduleMovieId = Integer.valueOf(request.getParameter("addScheduleMovieId"));
			//��ȡֵ
			int addScheduleVideoHallId = Integer.valueOf(request.getParameter("addScheduleVideoHallId"));
			String addScheduleItemTime = request.getParameter("addScheduleItemTime");
			//ת��ʱ������
			java.util.Date date = null;
			try {
				date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(addScheduleItemTime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			java.sql.Time date1 = new Time(date.getTime());
			System.out.println(date1);
			//ͨ����Ӱidȥ���Ӱ
			Movie movie = movieServ.queryMovie(addScheduleMovieId);
			//ͨ��Ӱ��idȥ��Ӱ��
			VideoHall videoHall = videoHallServ.queryVideoHall(addScheduleVideoHallId);
			Schedule schedule = new Schedule(0, movie, date1, videoHall);

			int result = 0;
			result = scheduleServ.addSchedule(schedule);
			if(result!=0){
				System.out.println("��ӳɹ�");
			}else{
				System.out.println("���ʧ��");
			}
		}
		/******************************ɾ������******************************/
		if(request.getParameter("scheduleItemId")!=null){
			logger.info("ManagerMovieServlet->��ʼɾ������");
			
			int scheduleItemId = Integer.valueOf(request.getParameter("scheduleItemId"));
		
			int result = scheduleServ.deleteSchedule(scheduleItemId);
			if(result!=0){
				logger.info("ManagerMovieServlet->ɾ�����γɹ�");
			}else{
				logger.info("ManagerMovieServlet->ɾ������ʧ��");
			}
		}
		/******************************�޸ĳ���******************************/
		//
		if(request.getParameter("editorScheduleId")!=null){
			logger.info("ManagerMovieServlet->��ʼ�޸ĳ���");
			//��ȡֵ
			int editorScheduleId = Integer.valueOf(request.getParameter("editorScheduleId"));
			String editorScheduleTime = request.getParameter("editorScheduleTime");
			int editorVideoHallId = Integer.valueOf(request.getParameter("editorVideoHallId"));
			//ת��ʱ��
			java.util.Date date = null;
			try {
				date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(editorScheduleTime);
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			java.sql.Time date1 = new java.sql.Time(date.getTime());
			
			Schedule schedule = new Schedule(editorScheduleId, null, date1, new VideoHall(editorVideoHallId, null, 0, 0, 0)); 
			int result = scheduleServ.editorSchedule(schedule);
			if(result!=0){
				logger.info("ManagerMovieServlet->�޸ĳ��γɹ�");
			}else{
				logger.info("ManagerMovieServlet->�޸ĳ���ʧ��");
			}
		}
		/******************************��ȫ������*****************************/
		List<Schedule> scheduleList = new ArrayList<Schedule>();
		scheduleList = scheduleServ.queryScheduleAll();

		if(scheduleList != null){
			session.setAttribute("scheduleList", scheduleList);
			logger.info("ManagerMovieServlet->��̨����������"+scheduleList.size());
			response.sendRedirect("after_scheduleManager.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
