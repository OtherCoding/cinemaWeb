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
		
		/******************************���Ӱ��******************************/
		String addVideoHallSeatRows= request.getParameter("addVideoHallSeatRows");
		

		if(addVideoHallSeatRows!=null){
			logger.info("ManagerVideoHallServlet->��ʼ���Ӱ��");
			
			int addVideoHallSeatRows1 = Integer.valueOf(request.getParameter("addVideoHallSeatRows"));
			int addVideoHallSeatCols = Integer.valueOf(request.getParameter("addVideoHallSeatCols"));
			int addVideoHallTypeId = Integer.valueOf(request.getParameter("addVideoHallTypeId"));
			System.out.println("��ӵ�Ӱ����λ������"+ addVideoHallSeatRows);

			VideoHall videoHall = new VideoHall(0, new VideoHallType(addVideoHallTypeId, null), (addVideoHallSeatRows1*addVideoHallSeatCols), addVideoHallSeatRows1, addVideoHallSeatCols);
			int result = 0;
			result = videoHallServ.addVideoHall(videoHall);
			if(result!=0){
				System.out.println("���Ӱ���ɹ�");
			}else{
				System.out.println("���Ӱ��ʧ��");
			}
		}
		/******************************ɾ��Ӱ��******************************/
		if(request.getParameter("deleteVideoHallId")!=null){
			logger.info("ManagerVideoHallServlet->��ʼɾ��Ӱ��");
			
			int deleteVideoHallId = Integer.valueOf(request.getParameter("deleteVideoHallId"));
		
			int result = videoHallServ.deleteVideoHall(deleteVideoHallId);
			if(result!=0){
				logger.info("ManagerVideoHallServlet->ɾ��Ӱ���ɹ�");
			}else{
				logger.info("ManagerVideoHallServlet->ɾ��Ӱ��ʧ��");
			}
		}
		/******************************�޸�Ӱ��******************************/
		if(request.getParameter("editorVideoHallId")!=null){
			logger.info("ManagerVideoHallServlet->��ʼ�޸�Ӱ��");
			
			int editorVideoHallId = Integer.valueOf(request.getParameter("editorVideoHallId"));
			int editorVideoHallRows = Integer.valueOf(request.getParameter("editorVideoHallRows"));
			int editorScheduleCols = Integer.valueOf(request.getParameter("editorScheduleCols"));
			int editorVideoHallTypeId = Integer.valueOf(request.getParameter("editorVideoHallTypeId"));
			
			VideoHall videoHall = new VideoHall(editorVideoHallId, new VideoHallType(editorVideoHallTypeId, null), (editorVideoHallRows*editorScheduleCols), editorVideoHallRows, editorScheduleCols);
			int result = videoHallServ.editorVideoHall(videoHall);
			
			if(result!=0){
				logger.info("ManagerVideoHallServlet->�޸�Ӱ���ɹ�");
			}else{
				logger.info("ManagerVideoHallServlet->�޸�Ӱ��ʧ��");
			}
		}
		/******************************��ȫ��Ӱ��*****************************/
		List<VideoHall> videoHallList = new ArrayList<VideoHall>();
		videoHallList = videoHallServ.queryVideoHallAll();

		if(videoHallList != null){
			session.setAttribute("videoHallList", videoHallList);
			logger.info("ManagerMovieServlet->��̨Ӱ��������"+videoHallList.size());
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
