<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/style-job-detail.css" />
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
        <p class="title">${jobDetail.jobName }</p>
        <p>${jobDetail.enterpise.enterpiseName }</p>
    </div>
    <!-- Banner End -->
    <!-- Main Container -->
    <div class="container">
        <div class="content">
            <h3>职位信息 Offer Detail</h3>
            <table class="table table-striped">
                <tr>
                    <td class="col-md-4 text-right">薪酬水平 Salary</td>
                    <td class="col-md-8">${jobDetail.lowSal }-${jobDetail.highSal }</td>
                </tr>
                <tr>
                    <td class="col-md-4 text-right">工作地点 Place</td>
                    <td class="col-md-8">${jobDetail.place }</td>
                </tr>
                <tr>
                    <td class="col-md-4 text-right">岗位描述 Describe</td>
                    <td class="col-md-8">${jobDetail.describe }</td>
                </tr>
                <tr>
                    <td class="col-md-4 text-right">岗位需求 Requires</td>
                    <td class="col-md-8">${jobDetail.require }</td>
                </tr>
            </table>
            <a class="btn btn-primary btn-block" href="apply.html?id=${jobDetail.id }">申请 Apply</a>
            <p class="text-center"><a href="javascript:history.go(-1);">返回</a></p>
        </div>
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