<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script src="js/jquery/jquery-1.8.3.min.js" type="text/javascript"></script>
		<title>注册跳转页面</title>
		<script>
			
		</script>
	</head>
	<body>
		<%	
			int num = (Integer)session.getAttribute("state");
			System.out.println(num);
			if(num==1){
			
		%>
		
				<script type="text/javascript">
					var i=4;
					$(function(){
						document.getElementById("err").innerHTML="注册成功，5秒后转到登录界面";
					});
					
					function timeout(){
						document.getElementById("err").innerHTML="注册成功，"+i+"秒后转到登录界面";
						if(i==0){						
							window.location.href="after_login.jsp";
						}
						i--;
					}
					setInterval("timeout()",1000);
				</script>
		<%
			}else{
		%>
				<script type="text/javascript">
					var i=4;
					$(function(){
						document.getElementById("err").innerHTML="注册失败，5秒后转到注册界面";
					});
					
					function timeout(){
						document.getElementById("err").innerHTML="注册失败，"+i+"秒后转到注册界面";
						if(i==0){						
							window.location.href="after_register.jsp";
						}
						i--;
					}
					setInterval("timeout()",1000);
				</script>
		<%
			}
		%>
		<span id="err"></span>
	</body>
</html>