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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/style-login.css" />
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
                    <li  class="active">
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
    <div class="container">
        <div class="login-panel">
            <h3>登录到万才网</h3>
            <form>
                <div class="form-group">
                    <label for="username">用户名</label>
                    <input type="username" class="form-control" id="username" placeholder="请输入用户名">
                </div>
                <div class="form-group">
                    <label for="password">密码</label>
                    <input type="password" class="form-control" id="password" placeholder="请输入密码">
                </div>
                <button type="button" class="btn btn-success btn-block" id="login">登录</button>
            </form>
            <hr>
            <div class="row">
                <div class="col-md-6 col-xs-12 col-sm-12">
                    <a href="regisiter.html" class="btn btn-info btn-block">还没有账户，点此注册</a>
                </div>
                <div class="col-md-6 col-xs-12 col-sm-12">
                    <a href="forget-password.html" class="btn btn-warning btn-block">忘记密码</a>
                </div>
            </div>
        </div>
    </div>

    <div class="footer">
        <p><a href="enterprise-login.html">我要发布招聘信息</a></p>
        <p>Guangzhou College &copy; 2006-2017 All rights reserve.</p>
    </div>
    <!-- Main Container End -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/res/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/res/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/res/js/public-login.js"></script>
</body>
</html>