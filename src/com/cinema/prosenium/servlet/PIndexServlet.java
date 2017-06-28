package com.cinema.prosenium.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cinema.prosenium.entity.Movie;
import com.cinema.prosenium.entity.PageBean;
import com.cinema.prosenium.serv.MovieServ;
import com.cinema.prosenium.serv.impl.MovieServImpl;

/**
 * Servlet implementation class PIndexServlet
 */
@WebServlet("/PIndexServlet")
public class PIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("收到首页请求");
		MovieServ movieServ = new MovieServImpl();
		
		//给PageBean初始化
		int totalCount = movieServ.queryMovieCount();
		PageBean pageBean = new PageBean();
		pageBean.setTotalCount(totalCount);
		if(request.getParameter("currPageNo")==null){
			pageBean.setCurrPageNo(1);
		}else{
			pageBean.setCurrPageNo(Integer.valueOf(request.getParameter("currPageNo")));
		}
		
		//用pageBean去查电影
		List<Movie> movieList = new ArrayList<Movie>();
		movieList = movieServ.queryMoviePage(pageBean);

		if(movieList != null){
			HttpSession session = request.getSession();
			
			session.setAttribute("movieList", movieList);
			session.setAttribute("pageBean", pageBean);
			System.out.println("前台首页->电影数量："+movieList.size());
			response.sendRedirect("before_index.jsp");
		}else{
			response.sendRedirect("before_login.jsp");
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
