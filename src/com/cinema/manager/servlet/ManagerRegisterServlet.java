package com.cinema.manager.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cinema.prosenium.entity.User;
import com.cinema.prosenium.serv.UserServ;
import com.cinema.prosenium.serv.impl.UserServImpl;

/**
 * Servlet implementation class ManagerRegisterServlet
 */
@WebServlet("/ManagerRegisterServlet")
public class ManagerRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("后台，收到注册请求");
		String userName = request.getParameter("userName");
		String userPwd = request.getParameter("userPwd");
		
		User user = new User();
		user.setUserName(userName);
		user.setUserPwd(userPwd);
		UserServ userServ = new UserServImpl();
		int state=userServ.addUser(user);

		if(state != 0){
			HttpSession session = request.getSession();
			session.setAttribute("state",state);
			System.out.println("成功");
			
			response.sendRedirect("manager_registerprocess.jsp");
		}else{
			System.out.println("失败");
			response.sendRedirect("manager_registerprocess.jsp");
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
