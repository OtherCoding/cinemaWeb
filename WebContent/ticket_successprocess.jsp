<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购票成功跳转页面</title>
</head>
<body>

	<div class="tip"></div>
	<input id="skip" type="hidden" value="PTicketServlet?scheduleItemId=${scheduleItemId }" />
	<a href="PTicketServlet?scheduleItemId=${scheduleItemId }">购票成功，重新跳转到选座页面</a>
</body>
</html>