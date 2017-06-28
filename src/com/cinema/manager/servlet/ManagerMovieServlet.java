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

import com.cinema.manager.serv.MovieServ;
import com.cinema.manager.serv.ScheduleServ;
import com.cinema.manager.serv.impl.MovieServImpl;
import com.cinema.manager.serv.impl.ScheduleServImpl;
import com.cinema.prosenium.entity.Movie;
import com.cinema.prosenium.entity.MovieType;
import com.cinema.prosenium.entity.Schedule;


/**
 * Servlet implementation class ManagerMovieServlet
 */
@WebServlet("/ManagerMovieServlet")
public class ManagerMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Logger logger = Logger.getLogger(ManagerMovieServlet.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("ManagerMovieServlet:��Ӱ�����յ�����");
		MovieServ movieServ = new MovieServImpl();
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("UTF-8");
		/******************************��ӵ�Ӱ******************************/
		String addMovieName= request.getParameter("addMovieName");
		System.out.println("��ӵĵ�Ӱ����"+ addMovieName);
		//��ӵ�Ӱ,�������ӵ�Ӱ�����������д�����ݲ����ύ���Ҿ����� ��ӵ�Ӱ
		if(addMovieName!=null){
			logger.info("ManagerMovieServlet->��ʼ��ӵ�Ӱ");
			
			
			String addMoviePoster= request.getParameter("addMoviePoster");
			
			String addMovieDirector= request.getParameter("addMovieDirector");
			
			String addMovieActor= request.getParameter("addMovieActor");
			
			int addMovieType= Integer.valueOf(request.getParameter("addMovieType"));
			System.out.println("��ӵ�Ӱ���ͣ�"+addMovieType);
			double addMoviePrice= Double.valueOf(request.getParameter("addMoviePrice"));
			System.out.println("��ӵ�Ӱ�۸�"+addMoviePrice);
			
			int result = 1;
			MovieType movieType = new MovieType(addMovieType, null);
			Movie movie = new Movie(0, addMovieName, addMoviePoster, addMovieDirector, addMovieActor, movieType, addMoviePrice, null, null);
			
			result = movieServ.addMovie(movie);
			if(result!=0){
				System.out.println("��ӳɹ�");
			}else{
				System.out.println("���ʧ��");
			}
		}
		/******************************ɾ����Ӱ******************************/
		if(request.getParameter("deleteMovieId")!=null){
			logger.info("ManagerMovieServlet->��ʼɾ����Ӱ");
			
			int deleteMovieId = Integer.valueOf(request.getParameter("deleteMovieId"));
			
			//��ѯ���Σ�����������������ӰӦ������������ɾ��
			ScheduleServ scheduleServ = new ScheduleServImpl();
			List<Schedule> scheduleList = null;	
			scheduleList = scheduleServ.queryMovieIdSchedule(deleteMovieId);
			logger.info("scheduleList��������"+scheduleList.size());
			
			if(!(scheduleList.isEmpty())){
				session.setAttribute("deleteFail", 1);//0��ʾ�������������Ӱ��������ɾ��
				logger.info("ManagerMovieServlet->�������иõ�Ӱ������ɾ��");
			}else{
				session.setAttribute("deleteFail", 0);//0��ʾ�������������Ӱ������ɾ��
				int result =movieServ.deleteMovie(deleteMovieId);
				if(result!=0){
					System.out.println("ɾ���ɹ�");
				}else{
					System.out.println("ɾ��ʧ��");
				}
			}
		}
		/******************************�༭��Ӱ******************************/
		if(request.getParameter("editorMovieId")!=null){
			logger.info("ManagerMovieServlet->��ʼ�༭��Ӱ");
			
			int editorMovieId = Integer.valueOf(request.getParameter("editorMovieId"));
			String editorMovieName= request.getParameter("editorMovieName");
			//System.out.println("��Ӱ����"+editorMovieName);
			String editorMoviePoster= request.getParameter("editorMoviePoster");
			
			String editorMovieDirector= request.getParameter("editorMovieDirector");
			
			String editorMovieActor= request.getParameter("editorMovieActor");
			
			int editorMovieTypeId= Integer.valueOf(request.getParameter("editorMovieTypeId"));
			
			double editorMoviePrice= Double.valueOf(request.getParameter("editorMoviePrice"));
			
			String editorMovieInfo= request.getParameter("editorMovieInfo");
			
			MovieType movieType = new MovieType(editorMovieTypeId, null);
			Movie editorMovie = new Movie(editorMovieId, editorMovieName, editorMoviePoster, editorMovieDirector, editorMovieActor, movieType, editorMoviePrice, null, editorMovieInfo);
			int result =movieServ.editorMovie(editorMovie);
			if(result!=0){
				logger.info("ManagerMovieServlet->��Ӱ�༭�ɹ�");
			}else{
				logger.info("ManagerMovieServlet->��Ӱ�༭ʧ��");
			}
		}
		
		/******************************��ȫ����Ӱ*****************************/
		List<Movie> movieList = new ArrayList<Movie>();
		movieList = movieServ.queryMovieAll();
	
		if(movieList != null){
			session.setAttribute("movieList", movieList);
			logger.info("ManagerMovieServlet->��̨��Ӱ������"+movieList.size());			
			response.sendRedirect("after_movieManager.jsp");
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
