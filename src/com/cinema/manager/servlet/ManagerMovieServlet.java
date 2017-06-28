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
		logger.info("ManagerMovieServlet:电影管理收到请求");
		MovieServ movieServ = new MovieServImpl();
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("UTF-8");
		/******************************添加电影******************************/
		String addMovieName= request.getParameter("addMovieName");
		System.out.println("添加的电影名："+ addMovieName);
		//添加电影,如果在添加电影的输入框内填写了内容并且提交，我就让你 添加电影
		if(addMovieName!=null){
			logger.info("ManagerMovieServlet->开始添加电影");
			
			
			String addMoviePoster= request.getParameter("addMoviePoster");
			
			String addMovieDirector= request.getParameter("addMovieDirector");
			
			String addMovieActor= request.getParameter("addMovieActor");
			
			int addMovieType= Integer.valueOf(request.getParameter("addMovieType"));
			System.out.println("添加电影类型："+addMovieType);
			double addMoviePrice= Double.valueOf(request.getParameter("addMoviePrice"));
			System.out.println("添加电影价格："+addMoviePrice);
			
			int result = 1;
			MovieType movieType = new MovieType(addMovieType, null);
			Movie movie = new Movie(0, addMovieName, addMoviePoster, addMovieDirector, addMovieActor, movieType, addMoviePrice, null, null);
			
			result = movieServ.addMovie(movie);
			if(result!=0){
				System.out.println("添加成功");
			}else{
				System.out.println("添加失败");
			}
		}
		/******************************删除电影******************************/
		if(request.getParameter("deleteMovieId")!=null){
			logger.info("ManagerMovieServlet->开始删除电影");
			
			int deleteMovieId = Integer.valueOf(request.getParameter("deleteMovieId"));
			
			//查询场次，如果场次中有这个电影应该提醒他不能删除
			ScheduleServ scheduleServ = new ScheduleServImpl();
			List<Schedule> scheduleList = null;	
			scheduleList = scheduleServ.queryMovieIdSchedule(deleteMovieId);
			logger.info("scheduleList的数量："+scheduleList.size());
			
			if(!(scheduleList.isEmpty())){
				session.setAttribute("deleteFail", 1);//0表示场次中有这个电影，不可以删除
				logger.info("ManagerMovieServlet->场次中有该电影，不可删除");
			}else{
				session.setAttribute("deleteFail", 0);//0表示场次中无这个电影，可以删除
				int result =movieServ.deleteMovie(deleteMovieId);
				if(result!=0){
					System.out.println("删除成功");
				}else{
					System.out.println("删除失败");
				}
			}
		}
		/******************************编辑电影******************************/
		if(request.getParameter("editorMovieId")!=null){
			logger.info("ManagerMovieServlet->开始编辑电影");
			
			int editorMovieId = Integer.valueOf(request.getParameter("editorMovieId"));
			String editorMovieName= request.getParameter("editorMovieName");
			//System.out.println("电影名："+editorMovieName);
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
				logger.info("ManagerMovieServlet->电影编辑成功");
			}else{
				logger.info("ManagerMovieServlet->电影编辑失败");
			}
		}
		
		/******************************查全部电影*****************************/
		List<Movie> movieList = new ArrayList<Movie>();
		movieList = movieServ.queryMovieAll();
	
		if(movieList != null){
			session.setAttribute("movieList", movieList);
			logger.info("ManagerMovieServlet->后台电影数量："+movieList.size());			
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
