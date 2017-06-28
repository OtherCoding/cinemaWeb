<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="css/prosenium/before.css" rel="stylesheet" type="text/css"/>
    <link href="css/prosenium/before_index.css" rel="stylesheet" type="text/css"/>
    <script src="js/jquery/jquery-1.8.3.min.js" type="text/javascript"></script>
    <style>
		
	</style>
	<script type="text/javascript">
		function upPage(){
			var currPage = $("#hiddenInput").val();
			var a="PIndexServlet?currPageNo=";
			//location.href="PIndexServlet?currPageNo=${pageBean.currPageNo-1 }";
		}
		function downPage(){
			
			var $currPage = $("#hiddenInput").val();
			alert($currPage);
			var a="PIndexServlet?="+(paraIn);
			location.href=a;
		}
	</script>
</head>

	<body>
	<!--------------------------top---------------------------------->
	    <div class="top">
	      <a href="after_login.jsp"><div id="logo-main" class="active"></div></a>
	      
	      <ul>
	        <li class="active"><a href="PIndexServlet">首页</a></li>
	        <li class="active">影片</li>
	        <li class="active">分类</li>
	        <li class="active">影院</li>
	      </ul>
	      <ul id="top-ul2">
	        <li class="active">
	        	<c:if test="${user.userName==null }">
					<a href="before_login.jsp">登录 </a>
				</c:if>
				<c:if test="${user.userName!=null }">
					<a><c:out value="${user.userName },欢迎您"></c:out></a>
				</c:if>
	        </li>
	        <li class="active"><a href="before_register.jsp">注册</a></li>
	      </ul>
	    </div>
	    <!--------------------------main---------------------------------->
	   	<div class="main-top-img">
	    	<div>
	        	<img src="images/prosenium/index-main-top-img.jpg"/>
	        </div>
	    </div>  
	    
	    
	    <div class="main" style="width:1000px">
	        <div class="header">
	            <h3>
	                <span class="">正在热映 </span>
	            </h3>
	        </div>
	        <!---------application----------->
	        <div id="main-application" >
	    	<div class="application">
				<c:forEach items="${movieList }" var="movie">
					<div class="box">
		        		<div class="roomTypeBox">
							<a  title="${movie.movieName }" href="PScheduleServlet?movieId=${movie.movieId}">
								<img alt=${movie.movieName } src="${movie.movieImgPath }" class="movie-img">
							</a>
		                </div>																																																																																					
						<p class="clear_mt10">
		                    	${movie.movieName}
		                </p> 
		                <a href="PScheduleServlet?movieId=${movie.movieId}" class="button_bigBt_redBt" >
		                    <span>选座购票</span>
		                </a>
		        	</div>
				</c:forEach>
				
	        </div><!--end of application-->
	        </div>
	    </div><!--end of main-->
	    <!-- 当前页大于1，显示上一页图标 --> 
		<!-- 当前页小于最大页，显示下一页图标 -->	 
		<div class="page">
			<input type="hidden" value="${pageBean.currPageNo}" id="hiddenInput"/>
			<c:if test="${pageBean.currPageNo>1}">  	
				<!--  <input type="button" value="上一页" onclick="upPage();"/>-->
				<a id="upPage" href="PIndexServlet?currPageNo=${pageBean.currPageNo-1 }">上一页</a>
			</c:if>
			<c:out value="第${pageBean.currPageNo}页"/>
			<c:if test="${pageBean.currPageNo<pageBean.totalPageCount}">   
				<!--<input type="button" value="下一页" onclick="downPage();"/>-->
				<a id="downPage" href="PIndexServlet?currPageNo=${pageBean.currPageNo+1 }">下一页</a>
	        </c:if> 
	    </div>
	    <!--------------------------foot---------------------------------->
		<div class="foot">
	      <div class="content_inner">
	        <h2>电影订座&nbsp;&nbsp;就上XX网</h2>
	        <div class="service">
	        	<span class="moblie">888-8888-888</span>
	            <span>周日-周四:9:00-22:00&nbsp;&nbsp;周五-周六:9:00-22:30</span>
	        </div>
	      </div>
	  
	         <div class="bottom-fix" id="bottom-fix-a">
	              <a href="#">关于卖座</a> | 
	              <a href="#">联系我们</a> | 
	              <a href="#">商务合作</a> | 
	              <a href="#">合作伙伴</a> | 
	              <a href="#">诚聘英才</a> | 
	              <a href="#">使用帮助</a> | 
	              <a href="#">退票服务</a> | 
	              <a href="#">服务条款</a>
	              <br />
	            </ul>
	        </div>
	      <div class="bottom-fix">Copyright © 2017 xiaoxiaopeng. All Rights Reserved 小小鹏网 版权所有 增值业务经营许可证:京B2-200502318</div>
	    </div>
	</body>

</html>