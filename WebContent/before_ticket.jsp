<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="css/prosenium/before.css" rel="stylesheet" type="text/css"/>
    <link href="css/prosenium/before_seat.css" rel="stylesheet" type="text/css"/>
    <script src="js/jquery/jquery-1.8.3.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="js/jquery/jquery.seat-charts.min.js"></script>
    <style>
		a{
			text-decoration:none;
		}
		.seat-center{
			/*border:#F00 solid 1px;*/
			width:500px;
			margin:0 auto;
			position:relative;
		}
		.changer-seat{
			background-color:#36bfd1;
		}
		 .front{width: 300px;margin: 5px 32px 45px 32px;background-color: #f0f0f0;	color: #666;text-align: center;padding: 3px;border-radius: 5px;}
          .booking_area {float: right;position: relative;width:200px;height: 450px; margin-top:50px;}
          .booking_area h3 {margin: 5px 5px 0 0;font-size: 16px;}
          .booking_area p{line-height:26px; font-size:16px; color:#999}
          .booking_area p span{color:#666}
          div.seatCharts-cell {color: #182C4E;height: 25px;width: 25px;line-height: 25px;margin: 3px;float: left;text-align: center;outline: none;font-size: 13px;}
          div.seatCharts-seat {color: #fff;cursor: pointer;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px;}
          div.seatCharts-row {height: 35px;margin-left:32px;}
          div.seatCharts-seat.available {background-color: #B9DEA0;}
          div.seatCharts-seat.focused {background-color: #76B474;border: none;}
          div.seatCharts-seat.selected {background-color: #E6CAC4;}
          div.seatCharts-seat.unavailable {background-color: #472B34;cursor: not-allowed;}
          div.seatCharts-container {width: 400px;padding: 20px;margin-left:50px;}
          div.seatCharts-legend {padding-left: 0px;position: absolute;bottom: 16px;}
          ul.seatCharts-legendList {padding-left: 0px;}
          .seatCharts-legendItem{float:left; width:90px;margin-top: 10px;line-height: 2;}
          span.seatCharts-legendDescription {margin-left: 5px;line-height: 30px;}
          .checkout-button {display: block;width:80px; height:24px; line-height:20px;margin: 10px auto;border:1px solid #999;font-size: 14px; cursor:pointer}
          #seats_chose {max-height: 150px;overflow-y: auto;overflow-x: none;width: 200px;}
          #seats_chose li{float:left; width:72px; height:26px; line-height:26px; border:1px solid #d3d3d3; background:#f7f7f7; margin:6px; font-size:14px; font-weight:bold; text-align:center}
	</style>
		
    </head>

    <body>
    <!--------------------------top---------------------------------->
    <div class="top">
          <div id="logo-main" class="active"></div>
          
      <ul>
        <li class="active">首页</li>
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
        <li class="active">注册</li>
      </ul>
    </div>
    <!--------------------------main---------------------------------->
    <div class="main">
    	<div class="application">
        	<div class="breadcrumb">
            	<ul class="breadcrumb-list">
                	<li class="breadcrumb-item"><i class="breadcrumb-num">1</i>选择影院，电影</li>
                    <li class="breadcrumb-item"><i class="breadcrumb-num">2</i>在线选座</li>
                    <li class="breadcrumb-item"><i class="breadcrumb-num">3</i>确认订单</li>
                    <li class="breadcrumb-item"><i class="breadcrumb-num">4</i>到店自助取票观影</li>
                </ul>
            </div>
            
          
            <div class="seat-ticket">
            	<!-------------------隐藏域---------------------->
            	<input type="hidden" class="Rows" value="${schedule.videoHall.videoHallSeatRows }" />
            	<input type="hidden" class="Cols" value="${schedule.videoHall.videoHallSeatCols }" />
            	<input type="hidden" id="moviePrice" value="${schedule.movie.moviePrice }" />
            	<input type="hidden" id="soldTickets" value="${tickets} }"/>
            	<c:forEach items="${tickets }" var="soldTicket" >
            		<input type="hidden" name="soldTicketSeatNo" value="${soldTicket.seatNo }"/>
            	</c:forEach>
            	<!-------------------seat-view---------------------->
            	<div class="seat-view">
                    <div class="seat-map">
                    	 
                    	<div class="seat-center" >
                    	<!-- 
                    		<div class="front">屏幕</div>	
                    		<c:forEach begin="1" var="i" end="${schedule.videoHall.videoHallSeatRows }">
                    			<c:forEach var="j" begin="1" end="${schedule.videoHall.videoHallSeatRows }">
		                            <span class="seat" ><c:out value="${i}_${j}"></c:out></span>

                    			</c:forEach>
                    				<br />
                    		</c:forEach>
                    		-->
                    		<!---左边座位列表----->
			                <div id="seat_area">
			                    <div class="front">屏幕</div>					
			                </div>
                        </div>
                       
                        
                    </div>
                    
                    
                </div>
                <!-------------------ticket-view---------------------->
                 
            	<div class="ticket-view">
            	<!-- 
                	<div class="film">
                    	<img width="80" src="${schedule.movie.movieImgPath }" />
                        <p class="name">
							<c:out value="${schedule.movie.movieName }" />
						</p>
                        <p>
							<c:out value="${schedule.movie.movieType.movieType }" />
						</p>
                        <p>国语</p>
                        <p>123分钟</p>
                    </div>
                    
                    <div class="pre-order">
                        <ul>
                            <li>
                            	<label>影城：</label><span>深圳宝影国际影城</span>
                            </li>
                            <li>
                            	<label>影厅：</label><span>${schedule.videoHall.videoHallType.videoHallType}</span>
                            </li>
                            <li>
                            	<label>场次：</label><span class="date">${schedule.scheduleItemTime}</span>
                            </li>
                            <li>
                            	<label id="seat-no">座位：</label>  <span class="seat"></span>   
                            </li>
                        </ul>
                    </div>
                    
                    <div class="fee">
                    	<ul>
                        	<li><label>总计：</label><span>¥152</span></li>
                        </ul>
                    </div>
                    <button type="button" class="disabled">确认下单</button>
                 -->  
	                 <div class="booking_area">
	                 	<form action="PTicket2Servlet" method="post">
	                 		<input type="hidden" name="scheduleItemId" value="${schedule.scheduleItemId }" />
		                    <p>电影：<span><c:out value="${schedule.movie.movieName }" /></span></p>
		                    <p>时间：<span>${schedule.scheduleItemTime}</span></p>
		                    <p>座位：</p>
		                    <ul id="seats_chose"></ul>
		                    <p>票数：<span id="tickects_num">0</span></p>
		                    <p>总价：<b>￥<span id="total_price">0</span></b></p>
		                    <input type="hidden" name="ticketPrice" value="${schedule.movie.moviePrice }"/>
		                    <input type="submit" class="btn" value="确定购买"/>
		                    <div id="legend"></div>
	                    </form>
	                </div> 
                
                
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
        </div>
      <div class="bottom-fix">Copyright © 2017 xiaoxiaopeng. All Rights Reserved 小小鹏网 版权所有 增值业务经营许可证:京B2-200502318</div>
    </div>
</body>
<script type="text/javascript">
				
		  var $videoHallSeatRows = parseInt($(".Cols").val());
		  var $videoHallSeatCols = parseInt($(".Cols").val());
		  var $moviePrice = parseFloat($('#moviePrice').val());
		  
		  var price = $moviePrice; 
	      var map=[];
	      for(var i=0;i<$videoHallSeatRows;i++){
	          map[i]="";
	         for(var j=0;j<$videoHallSeatCols;j++){
	              map[i]+="e";
	         }
	      }
	      $(document).ready(function() {
	          var $cart = $('#seats_chose'), //座位区
	                  $tickects_num = $('#tickects_num'), //票数
	                  $total_price = $('#total_price'); //票价总额
	          var sc = $('#seat_area').seatCharts({
	             
	                  //座位结构图 a 代表座位; 下划线 "_" 代表过道 
	        	  map: map,
	              naming: {//设置行列等信息
	                  top: false, //不显示顶部横坐标（行） 
	                  getLabel: function(character, row, column) { //返回座位信息 
	                      return column;
	                  }
	              },
	              legend: {//定义图例
	                  node: $('#legend'),
	                  items: [
	                      ['c', 'available', '可选座'],
	                      ['c', 'unavailable', '已售出']
	                  ]
	              },
	              click: function() {
	                  if (this.status() == 'available') { //若为可选座状态，添加座位
	                      $('<li>' + (this.settings.row + 1) + '排' + this.settings.label + '座</li>')
	                              .attr('id', 'cart-item-' + this.settings.id)
	                              .data('seatId', this.settings.id)
	                              .appendTo($cart);
	                      $('<input />')
                          .attr('type', 'hidden')
                          .attr('name', 'seat_no')
                          .attr('value', (this.settings.row + 1)+'-'+this.settings.label)
                          .appendTo($cart);
	                      $tickects_num.text(sc.find('selected').length + 1); //统计选票数量
	                      $total_price.text(getTotalPrice(sc) + price);//计算票价总金额
	                      return 'selected';
	                  } else if (this.status() == 'selected') { //若为选中状态
	                      $tickects_num.text(sc.find('selected').length - 1);//更新票数量
	                      $total_price.text(getTotalPrice(sc) - price);//更新票价总金额
	                      $('#cart-item-' + this.settings.id).remove();//删除已预订座位
	                      return 'available';
	                  } else if (this.status() == 'unavailable') { //若为已售出状态
	                      return 'unavailable';
	                  } else {
	                      return this.style();
	                  }
	              }
	          });
	          //设置已售出的座位
	          var $mapUnavailable=[];
	          $("[name=soldTicketSeatNo]").each(function(i,val){
	        	  $mapUnavailable[i]="";
	        	  $mapUnavailable[i]+=$(val).val().substring(0,1)+"_"+$(val).val().substring(2,3);
	          });
	          
	          //['1_3', '1_4', '4_4', '4_5', '4_6', '4_7', '4_8']
	          sc.get($mapUnavailable).status('unavailable');
	      });
	      function getTotalPrice(sc) { //计算票价总额
	          var total = 0;
	          sc.find('selected').each(function() {
	              total += price;
	          });
	          return total;
	      }
	</script>
</html>