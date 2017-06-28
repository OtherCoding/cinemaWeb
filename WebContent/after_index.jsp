<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="css/manager/after2.css" rel="stylesheet" type="text/css"/>
     <link href="css/manager/after_index.css" rel="stylesheet" type="text/css"/>
    <style>
		#nodiv{
			color:#F00;
			#347e81;
		}
		a{
			color:#347e81;
			text-decoration:none;
		}
	</style>
    </head>

    <body>
    <!--------------------------top---------------------------------->
    <div class="top">
          <div id="logo-main" class="active"></div>
          <div class="top-title">
          	影 院 管 理 系 统
          </div>
       	  <div class="top-user">
         	<c:if test="${user.userName==null }">
				<a href="after_login.jsp">&nbsp;登录 &nbsp;</a>
			</c:if>
			<c:if test="${user.userName!=null }">
				<a><c:out value="当前用户:${user.userName }"></c:out></a>
			</c:if>
			<c:if test="${user.userType==0 }">
				<a><c:out value="用户权限:管理员"></c:out></a>
			</c:if>
			<c:if test="${user.userType!=0 }">
				<a><c:out value="用户权限:非管理员"></c:out></a>
			</c:if>
          </div>
      
     
    </div>
    <!--------------------------main---------------------------------->
    <div class="main">
    	<c:if test="${user.userType!=0 }">
			<div id="nodiv"><c:out value="您不是管理员不可管理影院"></c:out></div>
		</c:if>
		<c:if test="${user.userType==0 }"><!-- 用户是：管理员，才能看见内容 -->
	    	<div class="application">
	        	<div class="div-title" id="movie-m"><a href="ManagerMovieServlet">影片管理</a></div>
	            <div class="div-title" id="schedule-m"><a href="ManagerScheduleServlet">场次管理</a></div>
	            <div class="div-title" id="videohall-m"><a href="ManagerVideoHallServlet">放映厅管理</a></div>
	            <div class="div-title" id="user-m"><a href="ManagerUserServlet">用户管理</a></div>
	            <div class="div-title" id="ticket-m"><a href="ManagerTicketServlet">售票管理</a></div>
	        </div>	
		</c:if>
    </div>
    
    <!--------------------------foot---------------------------------->
	<div class="foot">
        客服电话：4006-118-118（8:30-22:00）
        影院合作咨询邮箱：<a href="mailto:theaterservice@mtime.com">theaterservice@mtime.com</a>
        <span class="ml50 px11">Copyright 2006-2010 Mtime.com Inc. All rights reserved.</span>
   </div>
</body>
</html>