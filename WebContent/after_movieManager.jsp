<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>电影管理</title>
        <link href="css/manager/after2.css" rel="stylesheet" type="text/css"/>
        <link href="css/manager/after_movieManager.css" rel="stylesheet" type="text/css"/>
        <link href="css/manager/H-ui.min.css" rel="stylesheet" type="text/css"/>
   		<script src="js/jquery/jquery-1.8.3.min.js" type="text/javascript"></script>      
        <style type="text/css">
			#editorform-div{
				width:700px;
				margin:0 auto;
				position:fixed;
				z-index:2;
				left:600px;
				top:300px;
				background-color:#fff;
				border:#ccc solid 4px;
				border-radius:15px;
			}
			
        </style>
        <script type="text/javascript">
        	$(function(){
        		
        		$("[name=delete]").click(function(){
        			return confirm("是否删除");
        		});
        	});
        	$(function(){
        		if($("[name=deleteFail]").val()==1){
        			alert("场次中已有该电影，不可删除");
        		}
        	});
        	
        	$(".alterSubmit").click(function(){
        		return confirm("是否确认修改？");
        		
        		});
        	
        	
        	$(function(){
        		
        		$("#editorform-div").hide();
        		$(".alter").each(function(index) {
        	        $(this).on('click',function(event){
        				//alert(index)
        				event.stopPropagation();//阻止冒泡
        				$("#editorform-div").show();
        				//$alterParent=$(".alterTbody").eq(index)
        				//alert($(".alter").eq(index).parents(".alterTr").find('.alterTd').eq(2).text())
        				$(".alterBox .row ").each(function(){
        					var $index=$(this).index();		
        					$(this).find(".input-text").val($(".alter").eq(index).parents(".alterTr").find('.alterTd').eq($index).text());	
        					$(this).find(".input-hidden").val($(".alter").eq(index).parents(".alterTr").find('.alterInput').val());
        				});
        			});

        	    });
        		$(".alterSubmit").click(function(){
        			return confirm("是否确认修改？");
        			
        			});
        		
        		$(".application:not(#editorform-div > div)").click(function(){
        			
        			$("#editorform-div").hide();
        		});
        		
        	});

        </script>
    </head>
    
    <body>
    	<!-- 标志位 -->
    	<input type="hidden" name="deleteFail" value="${deleteFail }"/>
    	<!--------------------------top---------------------------------->
        <div class="top">
            <div id="logo-main" class="active"></div>
              
            <ul>
                <li class="active"><a  href="after_index.jsp">首页</a></li>
                <li class="active"><a  href="ManagerMovieServlet">影片管理</a></li>
		        <li class="active"><a  href="ManagerScheduleServlet">场次管理</a></li>
		        <li class="active"><a  href="ManagerVideoHallServlet">放映厅管理</a></li>
		        <li class="active"><a  href="ManagerUserServlet">用户管理</a></li>
		        <li class="active"><a  href="ManagerTicketServlet">售票管理</a></li>
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
            	<div class="add-movie">
                	<div class="add-movie-title">
                        添加电影
                    </div>
                <div class="add-movie-context">
                	<form action="ManagerMovieServlet" method="get" enctype="multipart/form-data">
                    	<table width="901">
                             <tr>
	                             <td >电影名：</td>
	                             <td><input type="text" name="addMovieName"/></td>
	                             <td class="name" >电影英文名：</td>
	                             <td ><input type="text" name="addMoviePoster"/></td>
	                             <td >类型：</td>
	                             <td>
	                             	<select name="addMovieType">
	                                     <option value="5">卡通</option>
	                                     <option value="4">动作</option>
	                                     <option value="6">恐怖</option>
	                                     <option value="3">爱情</option>
	                                     <option value="2">战争</option>
	                                     <option value="1">喜剧</option>
	                                 </select>
	                             </td>
                             </tr>
                             <tr>
                                 <td class="name">导演：</td>
                                 <td><input type="text" name="addMovieDirector"/></td>
                                 <td class="name">主演：</td>
                                 <td><input type="text" name="addMovieActor"/></td>
                                 <td class="name">价格：</td>
                                 <td><input type="text" name="addMoviePrice"/></td>

                                 <td class="name"><input type="submit" value="确认添加" class="bottom" /></td>
                             </tr>
                            
                        </table>
                        </form>  
                    </div><!--end of add-movie-context--> 
           		</div><!--end of add-movie-->
                <div class="movie-table">
                    <div class="add-movie-title">
                        用户数据
                    </div>
                    <table>
                        <form class="table-form">
                        <tr>
                            <td width="56">编号</td>
                            <td width="149">电影名</td>
                            <td width="150">电影英文名</td>
                            <td width="114">导演</td>
                            <td width="114">主演</td>
                            <td width="99">电影类型</td>
                            <td width="71">价格</td>
                            <td width="71">简介</td>
                            <td width="111">操作</td>  
                        </tr>
                        <c:forEach items="${movieList }" var ="movie" varStatus="status">
                        	<tr class="alterTr">
	                            <td >${status.count }</td>
	                            <td class="alterTd">${movie.movieName }</td>
	                            <td class="alterTd">${movie.moviePoster }</td>
	                            <td class="alterTd">${movie.movieDirector }</td>
	                            <td class="alterTd">${movie.movieActor }</td>
	                            <td class="alterTd">${movie.movieType.movieType }</td>
	                            <td class="alterTd">${movie.moviePrice }</td>
	                            <td class="alterTd">${movie.movieInfo }<input type="hidden" class="alterInput" value="${movie.movieId }"></td>
	                            
	                            <td>             	
	                            	<input type="button" class="bottom alter" value="编辑"/><br />
		                            <a name="delete" href="ManagerMovieServlet?deleteMovieId=${movie.movieId }" class="bottom"/>删除</a>
	                            </td>
                        	</tr>
                        </c:forEach>
                      
                        </form>
                    </table>
                </div>
               
            </div><!--end of  application-->
            <div id="editorform-div"><!-- start editorform -->
			    <form action="ManagerMovieServlet" method="post" class="form form-horizontal responsive alterBox" >
			        <div class="row cl">
			            <label class="form-label col-xs-3">电影名称：</label>
			            <div class="formControls col-xs-8">
			            	<input type="text" class="input-text" name="editorMovieName">
			        	</div>
			        </div> 
			        <div class="row cl">
			            <label class="form-label col-xs-3">电影英文名：</label>
			            <div class="formControls col-xs-8">
			            	<input type="text" class="input-text" name="editorMoviePoster">
			        	</div>
			        </div> 
			        <div class="row cl">
			            <label class="form-label col-xs-3">导演：</label>
			            <div class="formControls col-xs-8">
			            	<input type="text" class="input-text" name="editorMovieDirector">
			            </div>
			        </div>	 
			        <div class="row cl">
			            <label class="form-label col-xs-3">主演：</label>
			            <div class="formControls col-xs-8">
			            	<input type="text" class="input-text" name="editorMovieActor">
			            </div>
			        </div>	 
			        <div class="row cl">
			            <label class="form-label col-xs-3">电影类型：</label>
			            <div class="formControls col-xs-8">
			                <span class="select-box">
			                    <select class="select" size="1"  name="editorMovieTypeId">
			                    <option value="1" selected>喜剧</option>
			                    <option value="2">战争</option>
			                    <option value="3">爱情</option>
			                    <option value="4">动作</option>
			                    <option value="5">卡通</option>
			                    <option value="6">恐怖</option>
			                    </select>
			                </span>
			            </div>
			        </div>
			        <div class="row cl">
			            <label class="form-label col-xs-3">价格：</label>
			            <div class="formControls col-xs-8">
			            	<input type="text" class="input-text" name="editorMoviePrice">
			            </div>
			        </div>	 
			        <div class="row cl">
			            <label class="form-label col-xs-3">简介：</label>
			            <div class="formControls col-xs-8">
			            	<input type="text" class="text-l input-text" name="editorMovieInfo">
			            </div>
			        </div>	
			            <div class="row cl">
			            <div class="col-xs-8 col-xs-offset-3">
			            	<input type="hidden" class="input-hidden" name="editorMovieId" />
			            	<input class="btn btn-primary alterSubmit" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			            </div>
			        </div>
			    </form>
			</div><!-- end editorform -->
        </div><!--end of main-->
    	<!--------------------------foot---------------------------------->
		<div class="foot">
        	客服电话：4006-118-118（8:30-22:00）
        	影院合作咨询邮箱：<a href="mailto:theaterservice@mtime.com">theaterservice@mtime.com</a>
        	<span class="ml50 px11">Copyright 2006-2010 Mtime.com Inc. All rights reserved.</span>
  	 	</div>
    </body>
    
</html>