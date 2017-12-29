<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/style-enterpise.css" />
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
                        <a href="index.html">招聘管理</a>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="logout">退出</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- Navbar end -->
    <!-- Banner Begin -->
    <div class="banner-container">
        <p class="title">招聘管理后台</p>
        <p>HR Control Panel</p>
    </div>
    <!-- Banner End -->
    <!-- Main Container -->
    <div class="container content">
        <div class="col-md-3">
            <div class="list-group">
                <div class="list-group-item header"> 菜单 Menu</div>
                <a href="mgr-jobs.html" class="list-group-item">招聘职位管理</a>
                <a href="mgr-apply.html" class="list-group-item">简历投递管理</a>
            </div>
        </div>
        <div class="col-md-9">
            <div class="list-group row">
                <div class="list-group-item text-left header">目前收到的简历</div>
                <!-- Item Begin -->
                <a href="#" class="list-group-item text-left">
                    <div class="row">
                        <div class="col-md-8 col-xs-8 col-sm-8">
                            <p class="job">机器学习工程师</p>
                            <p>2017-10-10</p>
                        </div>
                        <div>
                            <p class="status not-handle">企业未处理</p>
                        </div>
                    </div>
                </a>
                <!-- Item End -->
                <!-- Item Begin -->
                <a href="#" class="list-group-item text-left">
                    <div class="row">
                        <div class="col-md-8 col-xs-8 col-sm-8">
                            <p class="job">机器学习工程师</p>
                            <p>2017-10-10</p>
                        </div>
                        <div>
                            <p class="status not-handle">企业未处理</p>
                        </div>
                    </div>
                </a>
                <!-- Item End -->
                <!-- Item Begin -->
                <a href="#" class="list-group-item text-left">
                    <div class="row">
                        <div class="col-md-8 col-xs-8 col-sm-8">
                            <p class="job">机器学习工程师</p>
                            <p>2017-10-10</p>
                        </div>
                        <div>
                            <p class="status not-handle">企业未处理</p>
                        </div>
                    </div>
                </a>
                <!-- Item End -->
                <!-- Item Begin -->
                <a href="#" class="list-group-item text-left">
                    <div class="row">
                        <div class="col-md-8 col-xs-8 col-sm-8">
                            <p class="job">机器学习工程师</p>
                            <p>2017-10-10</p>
                        </div>
                        <div>
                            <p class="status offer">已通知面试</p>
                        </div>
                    </div>
                </a>
                <!-- Item End -->
                <!-- Item Begin -->
                <a href="#" class="list-group-item text-left">
                    <div class="row">
                        <div class="col-md-8 col-xs-8 col-sm-8">
                            <p class="job">机器学习工程师</p>
                            <p>2017-10-10</p>
                        </div>
                        <div>
                            <p class="status offer">已通知面试</p>
                        </div>
                    </div>
                </a>
                <!-- Item End -->

            </div>
            <!-- Pagination Begin -->
            <nav class="text-center">
                <ul class="pagination">
                    <li class="active">
                        <a href="#">1</a>
                    </li>
                    <li>
                        <a href="#">2 </a>
                    </li>
                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">»</span>
                        </a>
                    </li>
                </ul>
            </nav>
            <!-- Pagination End -->
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