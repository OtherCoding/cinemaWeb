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

import com.cinema.manager.serv.VideoHallServ;
import com.cinema.manager.serv.impl.VideoHallServImpl;
import com.cinema.prosenium.entity.Movie;
import com.cinema.prosenium.entity.MovieType;
import com.cinema.prosenium.entity.VideoHall;
import com.cinema.prosenium.entity.VideoHallType;

/**
 * Servlet implementation class ManagerVideoHallServlet
 */
@WebServlet("/ManagerVideoHallServlet")
public class ManagerVideoHallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ManagerVideoHallServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerVideoHallServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		VideoHallServ videoHallServ = new VideoHallServImpl();
		
		/******************************添加影厅******************************/
		String addVideoHallSeatRows= request.getParameter("addVideoHallSeatRows");
		

		if(addVideoHallSeatRows!=null){
			logger.info("ManagerVideoHallServlet->开始添加影厅");
			
			int addVideoHallSeatRows1 = Integer.valueOf(request.getParameter("addVideoHallSeatRows"));
			int addVideoHallSeatCols = Integer.valueOf(request.getParameter("addVideoHallSeatCols"));
			int addVideoHallTypeId = Integer.valueOf(request.getParameter("addVideoHallTypeId"));
			System.out.println("添加的影厅座位行数："+ addVideoHallSeatRows);

			VideoHall videoHall = new VideoHall(0, new VideoHallType(addVideoHallTypeId, null), (addVideoHallSeatRows1*addVideoHallSeatCols), addVideoHallSeatRows1, addVideoHallSeatCols);
			int result = 0;
			result = videoHallServ.addVideoHall(videoHall);
			if(result!=0){
				System.out.println("添加影厅成功");
			}else{
				System.out.println("添加影厅失败");
			}
		}
		/******************************删除影厅******************************/
		if(request.getParameter("deleteVideoHallId")!=null){
			logger.info("ManagerVideoHallServlet->开始删除影厅");
			
			int deleteVideoHallId = Integer.valueOf(request.getParameter("deleteVideoHallId"));
		
			int result = videoHallServ.deleteVideoHall(deleteVideoHallId);
			if(result!=0){
				logger.info("ManagerVideoHallServlet->删除影厅成功");
			}else{
				logger.info("ManagerVideoHallServlet->删除影厅失败");
			}
		}
		/******************************修改影厅******************************/
		if(request.getParameter("editorVideoHallId")!=null){
			logger.info("ManagerVideoHallServlet->开始修改影厅");
			
			int editorVideoHallId = Integer.valueOf(request.getParameter("editorVideoHallId"));
			int editorVideoHallRows = Integer.valueOf(request.getParameter("editorVideoHallRows"));
			int editorScheduleCols = Integer.valueOf(request.getParameter("editorScheduleCols"));
			int editorVideoHallTypeId = Integer.valueOf(request.getParameter("editorVideoHallTypeId"));
			
			VideoHall videoHall = new VideoHall(editorVideoHallId, new VideoHallType(editorVideoHallTypeId, null), (editorVideoHallRows*editorScheduleCols), editorVideoHallRows, editorScheduleCols);
			int result = videoHallServ.editorVideoHall(videoHall);
			
			if(result!=0){
				logger.info("ManagerVideoHallServlet->修改影厅成功");
			}else{
				logger.info("ManagerVideoHallServlet->修改影厅失败");
			}
		}
		/******************************查全部影厅*****************************/
		List<VideoHall> videoHallList = new ArrayList<VideoHall>();
		videoHallList = videoHallServ.queryVideoHallAll();

		if(videoHallList != null){
			session.setAttribute("videoHallList", videoHallList);
			logger.info("ManagerMovieServlet->后台影厅数量："+videoHallList.size());
			response.sendRedirect("after_videoHallManager.jsp");
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
