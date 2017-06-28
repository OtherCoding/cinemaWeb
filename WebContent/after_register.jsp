<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="css/manager/after1.css" rel="stylesheet" type="text/css"/>
    <link href="css/manager/after_zhuce.css" rel="stylesheet" type="text/css"/>
    <script src="js/jquery/jquery-1.8.3.min.js" type="text/javascript"></script>
    <script src="js/manager/after_zhuce.js" rel="stylesheet" type="text/javascript"></script>
    <style>
		.title a{
			text-decoration: none;
			color: #b2b2b2;
		}
	</style>
    </head>

    <body>
    <!--------------------------top---------------------------------->
    <div class="top">
  
    </div>
    <!--------------------------main---------------------------------->
    <div class="main">
    	<div class="application">
        	<div class="panel">
            	<div>
                	<h3>欢迎加入XXXX影院管理系统</h3>
                </div>
                <form>
                	<form action="ManagerRegisterServlet" method="get">
	                  <ul>
                        <li class="">
                            <input type="text" id="userName" name="userName" placeholder="输入用户名" onblur="checkUserName();"><p id="uText" ></p>
                        </li>
                        <li class=""><input type="text" placeholder="请输入验证码">
                            <div class="captcha">
                                <!--  <img src="">-->
                            </div><p></p>
                        </li>
                        <li class=""><input type="text" class="clearfix" placeholder="请输入动态码">
                            <div class="send-btn">发送动态码</div><p class="pText"></p>
                        </li>
                        <li class="password">
                        	<input type="passWord" name="userPwd" id="userPwd" placeholder="设置新密码 6-16位，数字、字母" onblur="checkPwd()"><p id="pText"></p>
                        </li>
                        <li class="surePassword">
                        	<input type="passWord" name="userPwd1" id="userPwd1" placeholder="请再次输入登录密码" onblur="checkRPwd()"><p id="prText"></p>
                        </li>
                        <input type="submit" id="b_zhuc" value="立即注册" onclick="checkReg();">
                     </ul>
                     </form>
                     <div class="title">
                     	<input type="checkbox" value="on"><!-- react-text: 81 -->我已阅读并同意<!-- /react-text -->
                        	<a href="#/service" target="_blank" id="tiaokuan" >《卖座网服务条款》</a>
                     </div>
                 </form>
            </div>
            <div class="billboard">
            	<h5>更加实用 ● 更加智能 ● 更多服务</h5>
                <div class="poster">
                	<img src="images/manager/3aafe0da0fc7d9b82ee2f9d82ee34cae.png">
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