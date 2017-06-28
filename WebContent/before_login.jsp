<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	    <title>无标题文档</title>
	    <link href="css/prosenium/before.css" rel="stylesheet" type="text/css"/>
	    <link href="css/prosenium/before_login.css" rel="stylesheet" type="text/css"/>
	    <script src="js/jquery/jquery-1.8.3.min.js" type="text/javascript"></script>
	    <script>
	    	
	    </script>
	    <style>
	
		</style>
	</head>

   	<body>
    <!--------------------------top---------------------------------->
    <div class="top">
          <div id="logo-main" class="active"></div>
          
          <ul>
        <li class="active"> <a href="PIndexServlet">首页</a></li>
        <li class="active">影片</li>
        <li class="active">分类</li>
        <li class="active">影院</li>
      </ul>
          <ul id="top-ul2">
        <li class="active">登录</li>
        <li class="active"><a href="before_register.jsp">注册</a></li>
      </ul>
    </div>
    <!--------------------------main---------------------------------->
    <div class="main">
    	<div class="application">
        	<div class="right">
            	<div >
                	<img src="images/prosenium/3aafe0da0fc7d9b82ee2f9d82ee34cae.png"/>
                </div>
            </div>
            <div class="left">
            	<div>
                	<h3>账号登录</h3>
                </div>
            	<div class="left-form">
            		<form action="PLoginServlet" method="post">
	                	<ul>
	                    	<li><input type="text" name="userName" placeholder="输入账号"/></li>
	                        <li class=""><input type="password" name="userPwd" placeholder="输入密码"></li>
	                        <button type="submit" id="b_login">立即登录</button>
	                    </ul>
                    </form>
                </div>
                <div class="service-login">
                	<p>
                    	<a>忘记密码</a>
                        <a>立即注册</a>
                    <p>
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