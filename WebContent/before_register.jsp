<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>注册</title>
    <link href="css/prosenium/before.css" rel="stylesheet" type="text/css"/>
    <link href="css/prosenium/before_zhuce.css" rel="stylesheet" type="text/css"/>
    <script src="js/jquery/jquery-1.8.3.min.js" type="text/javascript"></script>
    <script src="js/prosenium/before_zhuce.js" rel="stylesheet" type="text/javascript"></script>
    <script type="text/javascript">
  	
    </script>
    <style>
		
	</style>
    </head>

    <body>
    <!--------------------------top---------------------------------->
    <div class="top">
        <div id="logo-main" class="active"></div>
        <ul>
            <li class="active"><a href="before_index.jsp">首页</a></li>
            <li class="active">影片</li>
            <li class="active">分类</li>
            <li class="active">影院</li>
     	</ul>
        <ul id="top-ul2">
            <li class="active"><a href="before_login.jsp">登录</a></li>
            
      	</ul>
    </div>
    <!--------------------------main---------------------------------->
    <div class="main">
    	<div class="application">
        	<div class="panel">
            	<div>
                	<h3>欢迎加入小小鹏网</h3>
                </div>
                <form action="PRegisterServlet" method="get" onsubmit="checkReg();">
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
                        	<a href="#/service" target="_blank" id="tiaokuan">《卖座网服务条款》</a>
                     </div>
                 
            </div>
            <div class="billboard">
            	<h5>更加优惠 ● 更多服务 ● 更多朋友</h5>
                <div class="poster">
                	<img src="images/prosenium/3aafe0da0fc7d9b82ee2f9d82ee34cae.png">
                </div>
            </div>	
            
        </div>	
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
