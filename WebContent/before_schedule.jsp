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
    <style>

		
	</style>
    </head>

    <body>
    <!--------------------------top---------------------------------->
    <div class="top">
          <div id="logo-main" class="active"></div>
          
      <ul>
        <li class="active"><a href="PIndexServlet">首页</a></li>
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
            
            <div class="movie-intro">
            <c:forEach items="${scheduleList }" var="schedule" begin="0" end="0">
            	<div class="information clearfix">
            		<c:if test="${schedule.movie.movieName!=null }">
						<img src="${schedule.movie.movieImgPath }" width="254">
					</c:if>
					<c:if test="${schedule.movie.movieName==null }">
						<img src="images/prosenium/c8e9206ab3169de99d4a77060c953653.jpg" width="254">
					</c:if>
                	
                	<div class="outline">
                		<div class="title">
                			<h3>
								<c:if test="${schedule.movie.movieName!=null }">
									<c:out value="${schedule.movie.movieName }"></c:out>
								</c:if>
								<c:if test="${schedule.movie.movieName==null }">
									<c:out value="金刚狼3：殊死一战"></c:out>
								</c:if>
							</h3>
                        	<span class="grade">
                        	<!-- react-text: 1280 -->8<!-- /react-text --><i>.5</i>
                        	</span>
                       </div>
                       <div class="film-intro">
                            <ul class="film-intro-one">
                                <li>
                                	<label>上映：</label><span>2017-03-03</span>
                               	</li>
                                <li>
                                	<label>类型：</label>
                                	<c:if test="${schedule.movie.movieName==null }">
										<span>动作 | 科幻</span>
									</c:if>
									<c:if test="${schedule.movie.movieName!=null }">
										<span><c:out value="${schedule.movie.movieType.movieType }" /></span>
									</c:if>
                                </li>
                                <li>
                                	<label>导演：</label>
                                	<span>
                           				<c:if test="${schedule.movie.movieName!=null }">
											<c:out value="${schedule.movie.movieDirector }" />
										</c:if>
									</span>
                                </li>
                            </ul>
                            <ul class="film-intro-two">
                                <li><label>剧情：</label>
                                    <div class="synopsis">
                                    	<c:if test="${ schedule.movie.movieName==null}">
                                    		<c:out value="电影《金刚狼3》为《金刚狼》系列电影的第三集，《金刚狼2》上映后在世界各地的票房都表现不俗，全球票房已经超过4亿美元，这样的好成绩也让20世纪福克斯影业高层对导演詹姆斯·曼高德和休·杰克曼的组合更有信心，据Deadline独家报道，福斯正在与《金刚狼2》的导演詹姆斯·曼高德与休·杰克曼洽谈，希望他们合力拍摄《金刚狼3》。" /><!-- /react-text -->
                                        <!--<span>更多</span>-->
                                        </c:if>
                                        <c:if test="${ schedule.movie.movieName!=null}">
                                        	<c:out value="${schedule.movie.movieInfo}" />
                                        </c:if>
                                    </div>
                                </li>
                                
                                <li class="avatar"><label>主演：</label>
                                    <div class="avatar-wrap">
                                        <ul class="film-intro-three">
                                            <li>
                                                <span>
                                                	<c:if test="${ schedule.movie.movieName==null}">
                                                		<c:out value="休·杰克曼饰罗根 / 金刚狼" />
                                                	</c:if>
                                                	<c:if test="${ schedule.movie.movieName!=null}">
                                                		<c:out value="${ schedule.movie.movieActor}" />
                                                	</c:if>
                                                </span>
                                            </li>
                                            <!-- 
                                            <li>
                                                <span>帕特里克·斯图尔特饰查尔斯·泽维尔 / X教授</span>
                                            </li>
                                            <li>
                                                <span>达芙妮·基恩饰劳拉·金尼</span>
                                            </li>
                                            <li>
                                                <span>波伊德·霍布鲁克饰唐纳德·皮尔斯</span>
                                            </li>
                                            <li>
                                                <span>斯戴芬·莫昌特饰卡利班</span>
                                            </li>
                                            <li>
                                                <span>多瑞丝·莫加多饰Maria</span>
                                            </li>
                                            -->
                                        </ul>
                                   </div>
                                </li>
                           </ul>
						</div>
					</div>
				</c:forEach>
				</div>
            	
            </div>
            <!-------------------schedule-view---------------------->
            <div class="schedule-view">
            	<div class="content">
                	<ul class="title">
                    	<li class="search">电影名</li>
                    	<li class="time">放映时间</li>
                        <li>语言/版本</li>
                        <li>放映厅</li>
                        <li>票价</li>
                        <li >&nbsp;</li>
                    </ul>
                    <c:forEach items="${scheduleList}" var="schedule">
                    	<ul class="item clearfix">
	                    	<li class="movieid">
								<c:out value="${schedule.movie.movieName}"/>
							</li>
	                        <li class="time">
								<c:out value="${schedule.scheduleItemTime}"/>
							</li>
	                        <li>
								<c:out value="国语/${schedule.videoHall.videoHallType.videoHallType}" />
							</li>
	                        <li>
								<c:out value="${schedule.videoHall.videoHallType.videoHallTypeId}号厅" />
							</li>
	                        <li class="price">
								<c:out value="${schedule.movie.moviePrice}"/>
							</li>
	                        <li class="buy"><a href="PTicketServlet?scheduleItemId=${schedule.scheduleItemId}" class="buy_button">选座购票</a></li>
	                    </ul>
                    </c:forEach>
                    
                    <!--  
                  
               		<ul class="item clearfix">
                    	<li class="movieid">金刚狼3</li>
                        <li class="time">17:30</li>
                        <li>国语/2D</li>
                        <li>2号厅</li>
                        <li class="price">￥23</li>
                        <li class="buy"><button type="button" class="">选座购票</button></li>
                    </ul>
                
                    -->
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
      <div class="bottom-fix">Copyright ? 2017 xiaoxiaopeng. All Rights Reserved 小小鹏网 版权所有 增值业务经营许可证:京B2-200502318</div>
    </div>
</body>
</html>