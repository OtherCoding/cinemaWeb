<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>无标题文档</title>
        <link  href="css/manager/after1.css" type="text/css" rel="stylesheet"/>
        <link  href="css/manager/after_login.css" type="text/css" rel="stylesheet"/>
        <script src="js/jquery/jquery-1.8.3.min.js" type="text/javascript"></script>
        <style type="text/css">
			
        </style>
        <script type="text/javascript">
        	$(function(){
        		
        		var $userType = $("#userType").val();
        		var $loginFlag = $("#loginFlag").val();
        		
        		if($userType!=0 && $loginFlag==1){
        			alert("您不是管理员，请重新登录");
        		}
        	});
        </script>
    </head>

    <body>
    	<!--------------------------top---------------------------------->
        <div class="top">
        	
        </div>
    	<!--------------------------main---------------------------------->
      	<div class="main">
        	<div class="login_head">
            	<img src="images/manager/logo_main.jpg"/>
              <a href="#" target="_blank" id="login-head-name">XXXX影院管理系统</a>
            </div>
     
            <div class="application">
                <div class="right">
                    <div >
                        <img src="images/manager/3aafe0da0fc7d9b82ee2f9d82ee34cae.png"/>
                    </div>
                </div>
                <div class="left">
                    <div>
                        <h3>欢迎登陆管理系统</h3>
                    </div>
                    <div class="left-form">
                    	<input id = "userType" type="hidden" value="${userType }" />
                    	<input id = "loginFlag" type="hidden" value="${loginFlag }" />
                    	
                    	<form action="ManagerLoginServlet" method="post">
                        <ul>
                            <li><input type="text" name="userName" placeholder="输入用户名"/></li>
                            <li class=""><input type="password" name="userPwd" placeholder="输入密码"></li>
                            
                            <input type="submit" id="b_login" value="立即登录" />
                        </ul>
                        </form>
                    </div>
                    <div class="service-login">
                        <p>
                            <a href="#" target="_blank">忘记密码</a>
                        <p>
                    </div>
                </div>
            </div>	
        </div>
        
        
        
        <!--------------------------foot---------------------------------->
        <div class="foot">
        客服电话：4006-118-118（8:30-22:00）
        影院合作咨询邮箱：<a href="mailto:theaterservice@mtime.com">theaterservice@mtime.com</a>
        <span class="ml50 px11">Copyright 2006-2010 Mtime.com Inc. All rights reserved.</span>
        </div>
    </body>

</html>