<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>售票管理</title>
        <link href="css/manager/after2.css" rel="stylesheet" type="text/css"/>
        <link href="css/manager/after_ticketManager.css" rel="stylesheet" type="text/css"/>
        
        <style type="text/css">

        </style>
    </head>
    
    <body>
    	<!--------------------------top---------------------------------->
        <div class="top">
            <div id="logo-main" class="active"></div>
              
            <ul>
                <li class="active"><a  href="after_index.jsp">首页</a></li>
	            <li class="active"><a href="ManagerMovieServlet">影片管理</a></li>
	            <li class="active"><a href="ManagerScheduleServlet">场次管理</a></li>
	            <li class="active"><a href="ManagerVideoHallServlet">放映厅管理</a></li>
	            <li class="active"><a href="ManagerUserServlet">用户管理</a></li>
	            <li class="active"><a href="ManagerTicketServlet">售票管理</a></li>
            </ul>
             <ul id="top-ul2">
                <c:if test="${user.userName==null }">
				    <li class="active"><a href="after_login.jsp">登录 </a></li>
			    </c:if>
			    <c:if test="${user.userName!=null }">
				    <li class="active"><a><c:out value="当前用户:${user.userName }"></c:out></a></li>
			    </c:if>
            </ul>
        </div>
        <!--------------------------main---------------------------------->
    	<div class="main">
    		<div class="application">   
            	
                <div class="-table">
                    <div class="add-title">
                        票数据
                    </div>
                    <table>
                        <form class="table-form">
                        <tr>
                            <td>编号</td>
                          	<td>场次编号</td>
                         	<td>座位编号</td>
                            <td>票价格</td>
                            <td >票类型</td>
                            
                        </tr>
                        <c:forEach items="${ticketList }" var="ticket" varStatus="status">
	                        <tr>
	                            <td>${status.count }</td>
	                            <td>${ticket.schedule.scheduleItemId }号厅</td>
	                            <td>${ticket.seatNo }</td>
	                            <td>${ticket.ticketPrice }</td>
	                            <td>
	                            	<c:if test="${ticket.ticketType.ticketType==1 }">
	                            		<c:out value="普通票"></c:out>
	                            	</c:if>
	                            	<c:if test="${ticket.ticketType.ticketType==2 }">
	                            		<c:out value="学生票"></c:out>
	                            	</c:if>
	                            </td>
	                            
	                        </tr>
                      	</c:forEach>
                        </form>
                    </table>
                </div>
            </div><!--end of  application-->
        </div><!--end of main-->
    	<!--------------------------foot---------------------------------->
		<div class="foot">
        	客服电话：4006-118-118（8:30-22:00）
        	影院合作咨询邮箱：<a href="mailto:theaterservice@mtime.com">theaterservice@mtime.com</a>
        	<span class="ml50 px11">Copyright 2006-2010 Mtime.com Inc. All rights reserved.</span>
  	 	</div>
    </body>
</html>