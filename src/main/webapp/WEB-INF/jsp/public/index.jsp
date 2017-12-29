<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>万才网</title>
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta name="apple-mobile-web-app-capable" content="no" />
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/style-bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/style-index.css" />
    <link rel="stylesheet" href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css">
</head>
<body>
    <!-- Navbar Begin -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
                    aria-expanded="false">
                    <span class="sr-only">展开导航栏</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">万才网</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active">
                        <a href="index.html">首页</a>
                    </li>
                    <li>
                        <a href="discovery.html">发现</a>
                    </li>
                    <li>
                        <a href="message.html">消息</a>
                    </li>
                    <li>
                        <a href="mine.html">我的</a>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li>
                    	<c:if test="${sessionScope.isLogin != null }">
                    		<a href="logout">退出</a>
                    	</c:if>
                    	<c:if test="${sessionScope.isLogin == null }">
                    		<a href="login.html">登录或注册</a>
                    	</c:if>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- Navbar end -->
    <!-- Slider Begin -->
    <div class="slider-box">
        <div id="slider" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#slider" data-slide-to="2"></li>
                <li data-target="#slider" data-slide-to="1" class="active"></li>
                <li data-target="#slider" data-slide-to="0"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
                <div class="item pic-3"></div>
                <div class="item pic-1 active"></div>
                <div class="item pic-2"></div>
            </div>
            <a class="left carousel-control" href="#slider" role="button" data-slide="prev">
                <span class="fa fa-chevron-left" aria-hidden="true"></span>
            </a>
            <a class="right carousel-control" href="#slider" role="button" data-slide="next">
                <span class="fa fa-chevron-right" aria-hidden="true"></span>
            </a>
        </div>
    </div>
    <!-- Slider End -->
    <!-- Main Container -->
    <div class="container">
        <div>
            <div class="header-row">
                <a class="more" href="discovery.html">查看更多</a>
                <h3 class="title">最新招聘信息</h3>
            </div>
            <c:forEach items="${requestScope.jobPage.pageData }" var="item">
            <div class="col-md-3 col-xs-12 col-sm12 job-detail">
                <a href="jobs/detail-${item.id}.html">
                    <p>${item.jobName }</p>
                    <p>${item.enterpise.enterpiseName }</p>
                </a>
            </div>  
            </c:forEach>
        </div>
    </div>
    <div class="join">
        <p class="text-center">
            <a href="login.html" class="btn btn-primary btn-lg">登录或注册，马上开始</a>
        </p>
    </div>
    <div class="footer">
        <p><a href="enterprise-login.html">我要发布招聘信息</a></p>
        <p>Guangzhou College &copy; 2006-2017 All rights reserve.</p>
    </div>
    <!-- Main Container End -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/res/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/res/js/bootstrap.min.js"></script>
</body>
</html>