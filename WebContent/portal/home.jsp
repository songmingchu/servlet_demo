<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>主页</title>

<link href="/servlet_demo/static/css/bootstrap.min.css" rel="stylesheet">
<script src="/servlet_demo/static/js/jquery-2.1.0.min.js"></script>
<script src="/servlet_demo/static/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-default" role="navigation">
	    <div class="container-fluid">
		    <div class="navbar-header">
		        <a class="navbar-brand" href="#">ServletDemo</a>
		    </div>
		    <div>
		        <ul class="nav navbar-nav">
		            <li class="active"><a href="#">buttonA</a></li>
		            <li><a href="#">buttonB</a></li>
		            <li class="dropdown">
		                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
		                    Java
		                    <b class="caret"></b>
		                </a>
		                <ul class="dropdown-menu">
		                    <li><a href="#">jmeter</a></li>
		                    <li><a href="#">EJB</a></li>
		                    <li><a href="#">Jasper Report</a></li>
		                    <li class="divider"></li>
		                    <li><a href="#">分离的链接</a></li>
		                    <li class="divider"></li>
		                    <li><a href="#">另一个分离的链接</a></li>
		                </ul>
		            </li>
		        </ul>
		    </div>
	    </div>
	    <!-- 图片轮播 -->
		<div id="myCarousel" class="carousel slide">
		    <!-- 轮播（Carousel）指标 -->
		    <ol class="carousel-indicators">
		        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		        <li data-target="#myCarousel" data-slide-to="1"></li>
		        <li data-target="#myCarousel" data-slide-to="2"></li>
		    </ol>   
		    <!-- 轮播（Carousel）项目 -->
		    <div class="carousel-inner">
		        <div class="item active">
		            <img src="/servlet_demo/static/1.jpg" alt="First slide">
		        </div>
		        <div class="item">
		            <img src="/servlet_demo/static/2.jpg" alt="Second slide">
		        </div>
		        <div class="item">
		            <img src="/servlet_demo/static/3.jpg" alt="Third slide">
		        </div>
		    </div>
		    <!-- 轮播（Carousel）导航 -->
		    <a class="carousel-control left" href="#myCarousel" 
		        data-slide="prev">&lsaquo;
		    </a>
		    <a class="carousel-control right" href="#myCarousel" 
		        data-slide="next">&rsaquo;
		    </a>
</div>




	</div>
</body>
</html>