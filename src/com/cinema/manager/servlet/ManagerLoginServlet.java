package com.cinema.manager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.cinema.manager.serv.UserServ;
import com.cinema.manager.serv.impl.UserServImpl;
import com.cinema.prosenium.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/ManagerLoginServlet")
public class ManagerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(ManagerLoginServlet.class);   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerLoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("后台登录，收到请求");
		String userName = request.getParameter("userName");
		String userPwd = request.getParameter("userPwd");
		System.out.println(userName);
		System.out.println(userPwd);
		User user = new User();
		user.setUserName(userName);
		user.setUserPwd(userPwd);
		UserServ userServ = new UserServImpl();
		user=userServ.queryUser(user);
		
		
		HttpSession session = request.getSession();
		if(user != null && (user.getUserType()==0)){
			session.setAttribute("user", user);
			int userType = user.getUserType();
			if(userType!=0){
				session.setAttribute("userType", userType);
				response.sendRedirect("after_login.jsp");
			}else{
				response.sendRedirect("after_index.jsp");
			}
		}else{
			session.setAttribute("loginFlag", 1);//1表示after_login.jsp请求过servlet
			response.sendRedirect("after_login.jsp");
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
