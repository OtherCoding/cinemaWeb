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

import com.cinema.manager.serv.UserServ;
import com.cinema.manager.serv.impl.UserServImpl;
import com.cinema.prosenium.entity.Movie;
import com.cinema.prosenium.entity.MovieType;
import com.cinema.prosenium.entity.User;

/**
 * Servlet implementation class ManagerUserServlet
 */
@WebServlet("/ManagerUserServlet")
public class ManagerUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private Logger logger = Logger.getLogger(ManagerUserServlet.class);  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("ManagerUserServlet->�û������յ�����");
		HttpSession session = request.getSession(); 
		UserServ userServ = new UserServImpl();
		
		/******************************����û�*****************************/
		if((request.getParameter("addUserName")!=null)&&(request.getParameter("addUserName")!="")){
			logger.info("ManagerUserServlet->��ʼ����û�");
			String addUserName = request.getParameter("addUserName");
			logger.info("ManagerUserServlet->��ӵ��û�����"+addUserName);
			String addUserPwd = request.getParameter("addUserPwd");
			int addUserType = Integer.valueOf(request.getParameter("addUserType"));
	
			User user = new User(0, addUserName, addUserPwd, addUserType);
			int result = userServ.addUser(user);
			if(result!=0){
				logger.info("ManagerUserServlet->����û��ɹ�");
			}else{
				logger.info("ManagerUserServlet->����û�ʧ��");
			}
		}
		/******************************�༭�û�*****************************/
		if(request.getParameter("editorUserId")!=null){
			logger.info("ManagerUserServlet->��ʼ�༭�û�Ȩ��");
			
			int editorUserId = Integer.valueOf(request.getParameter("editorUserId"));
			
			int editorUserType= Integer.valueOf(request.getParameter("editorUserType"));
			
			User user = new User(editorUserId, null, null, editorUserType);
			int result =userServ.editorUser(user);
			if(result!=0){
				logger.info("ManagerUserServlet->�û�Ȩ�ޱ༭�ɹ�");
			}else{
				logger.info("ManagerUserServlet->�û�Ȩ�ޱ༭ʧ��");
			}
		}
		/******************************��ȫ���û�*****************************/
		List<User> userList = new ArrayList<User>();
		userList = userServ.queryUserAll();

		if(userList != null){
			session.setAttribute("userList", userList);
			logger.info("ManagerUserServlet->��̨�û�������"+userList.size());		
			response.sendRedirect("after_userManager.jsp");
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
