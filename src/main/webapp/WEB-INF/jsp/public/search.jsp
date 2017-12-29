<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt"   uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/style-search-result.css" />
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
                    <li>
                        <a href="index.html">首页</a>
                    </li>
                    <li class="active">
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
    <!-- Banner Begin -->
    <div class="banner-container">
        <p class="title">Discovery 发现</p>
        <p>搜索你未来的职位</p>
    </div>
    <!-- Banner End -->
    <!-- Main Container -->
    <div class="container">
        <form>
            <input class="form-control" placeholder="请输入职位的关键词" value="${word }" name="word">
            <button class="btn btn-primary btn-primary btn-large">Search 搜索</button>
        </form>
        <div class="row">
        <c:forEach items="${requestScope.pageData.pageData}" var="item" >
        
	        <div class="col-md-4 col-xs-12 col-sm-12 job-box">
	            <a class="content-container" href="job-detail.html">
	                <div class="row">
	                    <div class="col-md-8 col-xs-8 col-sm-8">
	                        <p class="job-name">${item.jobName }</p>
	                        <p class="company">${item.enterpise.enterpiseName }</p>
	                    </div>
	                    <div class="col-md-4 col-sm-4 col-xs-4">
	                        <p class="job-salary">薪资水平<br>${item.lowSal }-${item.highSal }</p>
	                    </div>
	                </div>
	                <p class="job-place">工作地点：${item.place }</p>
	                <p class="job-publish-time">发布时间：<fmt:formatDate value="${item.publishDate}"/></p>
	            </a>
	        </div>
        </c:forEach>
        </div>
        <!-- Cell End -->
        
        ${requestScope.pageNavi }
    </div>
    <div class="footer">
        <p>
            <a href="enterprise-login.html">我要发布招聘信息</a>
        </p>
        <p>Guangzhou College &copy; 2006-2017 All rights reserve.</p>
    </div>
    <!-- Main Container End -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/res/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/res/js/bootstrap.min.js"></script>
</body>

</html>