<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>影厅管理</title>
        <link href="css/manager/after2.css" rel="stylesheet" type="text/css"/>
        <link href="css/manager/after_videohallManager.css" rel="stylesheet" type="text/css"/>
        <link href="css/H-ui.min.css" type="text/css" rel="stylesheet"/>
        <script src="js/jquery/jquery-1.8.3.min.js" type="text/javascript"></script>  
		<script src="js/html5shiv.js"></script>
    	<script src="js/H-ui.min.js"></script>     
        <style type="text/css">
			#editorform-div {
			    position: absolute;
			    top: 500px;
			    left: 650px;
			    background-color: white;
			    border: #ccc solid 5px;
			    border-radius: 10px;
			    width: 500px;
			}
        </style>
        <script type="text/javascript">
			/*修改场次*/
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
            	<div class="add">
                	<div class="add-title">
                        	添加影厅
                    </div>
                <div class="add-context">
                    <form action="ManagerVideoHallServlet">
                    	<table width="901">
                            <tr>
                                <td class="name">影厅类型：
                                	<select name="addVideoHallTypeId">
                                	<c:forEach items="${videoHallList }" var="videoHall">
                                        <option value=${videoHall.videoHallType.videoHallTypeId }>${videoHall.videoHallType.videoHallType }</option>
                                    </c:forEach>
                                    </select>
                                </td>
                                <td >座位行数：</td>
                                <td ><input name="addVideoHallSeatRows" type="text"/></td>
                                <td >座位列数：</td>
                                <td ><input name="addVideoHallSeatCols" type="text"/></td>
                                <td class="name"><input type="submit" value="提交" class="bottom" /></td>
                             </tr>
                      	</table>  
                      </form>
                </div><!--end of add-movie-context--> 
           		</div><!--end of add-movie-->
                <div class="-table">
                    <div class="add-title">
                        影厅数据
                    </div>
                    <form class="table-form">
                    	<table>
                        <tr>
                            <td >放映厅编号</td>
                         	<td >座位数</td>
                            <td >座位行数</td>
                            <td >座位列数</td>
                            <td >放映厅类型编号</td>
                          	<td >放映厅类型</td>
                            <td >&nbsp;</td>  
                        </tr>
	                        <c:forEach items="${videoHallList }" var="videoHall" >
	                        	<tr class="alterTr">
		                            <td class="alterTd">${videoHall.videoHallId }</td>
		                            <td>${videoHall.videoHallSeatNum }</td>
		                            <td class="alterTd">${videoHall.videoHallSeatRows }</td>
		                            <td class="alterTd">${videoHall.videoHallSeatCols }</td>
		                            <td class="alterTd">${videoHall.videoHallType.videoHallTypeId }</td>
		                            <td>${videoHall.videoHallType.videoHallType }</td>
		                            <td>
		                            	<input type="hidden" class="alterInput" value="${videoHall.videoHallId }"/>
		                                <input type="button" class="bottom alter" value="编辑"/><br />
		                                <a name="delete" href="ManagerVideoHallServlet?deleteVideoHallId=${videoHall.videoHallId }" class="bottom"/>删除</a>
		                            </td>
		                        </tr>
	                        </c:forEach>
                    	</table>
                    </form>
                </div>
            </div><!--end of  application-->
            <div id="editorform-div"><!-- start editorform -->
		    <form action="ManagerVideoHallServlet" method="post" class="form form-horizontal responsive alterBox" >
		        <div class="row cl">
		            <label class="form-label col-xs-3">放映厅编号：</label>
		            <div class="formControls col-xs-8">
		            	<input type="text" class="input-text"  disabled>
		        	</div>
		        </div> 
		        <div class="row cl">
		            <label class="form-label col-xs-3">座位行数：</label>
		            <div class="formControls col-xs-8">
		            	<input type="text" class="input-text" value="" autocomplete="off" name="editorVideoHallRows">
		        	</div>
		        </div> 
		        <div class="row cl">
		            <label class="form-label col-xs-3">座位列数：</label>
		            <div class="formControls col-xs-8">
		            	<input type="text" class="input-text" value="" autocomplete="off" name="editorScheduleCols">
		        	</div>
		        </div> 
		        <div class="row cl">
		            <label class="form-label col-xs-3">放映厅类型编号：</label>
		            <div class="formControls col-xs-8">
		            	<input type="text" class="input-text" name="editorVideoHallTypeId"/>
		            </div>
		        </div>	
		        <div class="row cl">
		            <div class="col-xs-8 col-xs-offset-3">
		            	<input type="hidden" class="input-hidden" name="editorVideoHallId" />
		            	<input class="btn btn-primary alterSubmit" id="editorVideoHallSubmit" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
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