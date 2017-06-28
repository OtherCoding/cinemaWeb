<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="css/manager/after2.css" rel="stylesheet" type="text/css"/>
    <link href="css/manager/after_userManager.css" rel="stylesheet" type="text/css"/>
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
       	$(".alterSubmit").click(function(){
      		return confirm("是否确认修改？");
      	});
    	$(".addUserBottom").click(function(){
      		return confirm("是否确认添加？");
      	});
       	
       	$(function(){       		
       		$("#editorform-div").hide();
       		$(".alter").each(function(index) {
       	        $(this).on('click',function(event){
       				//alert(index)
       				event.stopPropagation();//阻止冒泡
       				$("#editorform-div").show();
       				
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
        	<div class"tool">
            	
            </div>
            
            <div class="add-user">
            	<div class="add-user-title">
                	添加用户
                </div>
                <div class="add-user-context">
                    <table>
                        <form action="ManagerUserServlet" method="post" >
                            <tr>
                                <td class="add-name">用户名：</td>
                                <td><input type="text" name="addUserName"/></td>
                                <td class="add-name">密码：</td>
                                <td><input type="password" name="addUserPwd"/></td>
                                <td class="add-name">用户类型：</td>
                                <td>
                                    <select name="addUserType">
                                       	<option value="2">普通用户</option>
                                       	<option value="0">管理员</option>
                                    </select>
                                </td>  
                                <td class="add-name"><input type="submit" value="提交" class="bottom addUserBottom" /></td>
                            </tr>
                         </form>
                    </table>  
                </div>   
            </div>
            <div class="user-table">
            	<div class="add-user-title">
                	用户数据
                </div>
            	<table>
                	<form class="table-form">
                	<tr>
                    	<td width="205">编号</td>
                        <td width="225">用户名</td>
                        <td width="225">用户类型</td>
                        <td width="225">操作</td>
                    </tr>
                    <c:forEach items="${userList }" var ="user" varStatus="status">
	                    <tr class="alterTr">
	                    	<td>${status.count }</td>
	                        <td>${user.userName }</td>
	                        <td class="alterTd">
	                        	<c:if test="${user.userType==0 }">
	                        		<c:out value="管理员"/>
	                        	</c:if>
	                        	<c:if test="${user.userType==2 }">
	                        		<c:out value="普通用户" />
	                        	</c:if>
	                        	<c:if test="${user.userType!=0 && user.userType!=2 }">
	                        		<c:out value="VIP用户" />
	                        	</c:if>
	                        	<input type="hidden" class="alterInput" value="${user.userId }">
	                        </td>
	                        <td>
	                        	<input type="button" value="编辑" class="bottom alter"/>
	                        </td>
	                    </tr>
                    </c:forEach>
                    </form>
                </table>
            </div>
        </div><!-- end application -->
           <div id="editorform-div"><!-- start editorform -->
		    <form action="ManagerUserServlet" method="post" class="form form-horizontal responsive alterBox" >
		        <div class="row cl">
		            <label class="form-label col-xs-3">用户类型：</label>
		            <div class="formControls col-xs-8">
		            	<select name="editorUserType">
                           	<option value="0">管理员</option>
                           	<option value="2">普通用户</option>
                        </select>
		        	</div>
		        </div>	
		        <div class="row cl">
		            <div class="col-xs-8 col-xs-offset-3">
		            	<input type="hidden" class="input-hidden" name="editorUserId" />
		            	<input class="btn btn-primary alterSubmit" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
		            </div>
		        </div> 
		    </form>
		</div><!-- end editorform -->	
    </div>
    
    <!--------------------------foot---------------------------------->
	<div class="foot">
        客服电话：4006-118-118（8:30-22:00）
        影院合作咨询邮箱：<a href="mailto:theaterservice@mtime.com">theaterservice@mtime.com</a>
        <span class="ml50 px11">Copyright 2006-2010 Mtime.com Inc. All rights reserved.</span>
   </div>
</body>
</html>