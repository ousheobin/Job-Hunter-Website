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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/style-enterpise.css" />
    <script type="text/javascript">
    		var id = "${applyEntity.id}";
    </script>
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
                <div class="list-group-item text-left header">申请职位 Apply Job</div>
                <div class="list-group-item text-left">
                    <p>${applyEntity.job.jobName }</p>
                </div>
            </div>
            <div class="list-group row">
                <div class="list-group-item text-left header">基本信息 Infomation</div>
                <div class="list-group-item text-left">
                    <p>姓名：${applyEntity.resume.name }</p>
                    <p>性别：${applyEntity.resume.gender }</p>
                    <p>出生年月：${applyEntity.resume.birthday }</p>
                    <p>参加工作室时间：${applyEntity.resume.timeToWork }</p>
                    <p>现在居住的城市：${applyEntity.resume.residence }</p>
                    <p>户口所在地：${applyEntity.resume.originResidence }</p>
                    <p>手机号码：${applyEntity.resume.phone }</p>
                    <p>电子邮箱：${applyEntity.resume.email }</p>
                </div>
            </div>
            <div class="list-group row">
                <div class="list-group-item text-left header">教育信息 Education Information</div>
                <c:forEach items="${requestScope.applyEntity.resume.educationDeatil }" var="item">
                <div class="list-group-item education">
                    <p>学校名称：${item.schoolName }</p>
                    <p>入学时间：${item.enrollmentTime }</p>
                    <p>毕业时间：${item.graduateTime }</p>
                    <p>专业：${item.major }</p>
                    <p>学位学历：${item.degree }</p>
                </div>
                </c:forEach>
                
            </div>
            <div class="list-group row">
                <div class="list-group-item text-left header">工作经历 Work Experience</div>
                 <c:forEach items="${requestScope.applyEntity.resume.experienceDetail }" var="item">
                <div class="list-group-item experience">
                    <p>公司名称：${item.companyName }</p>
                    <p>开始时间：${item.beginTime }</p>
                    <p>结束时间：${item.endTime }</p>
                    <p>所在行业：${item.industry }</p>
                    <p>工作描述：${item.describe }</p>
                </div>
                </c:forEach>
            </div>
            <div class="list-group row">
                <div class="list-group-item text-left header">项目经验 Project Experience</div>
                <div class="list-group-item text-left">
                    <p>${applyEntity.resume.projectExperience }</p>
                </div>
            </div>
            <div class="list-group row">
                <div class="list-group-item text-left header">自我评价 Self-Appraisal</div>
                <div class="list-group-item text-left">
                    <p>${applyEntity.resume.evaluate }</p>
                </div>
            </div>
            <div class="list-group row">
                <div class="list-group-item text-left header">操作 Operation</div>
                <div class="list-group-item text-center">
                <c:if test="${!applyEntity.handle }">
                	   <button class="btn btn-info" id="acceptBtn" type="button">通过简历，允许面试</button> 
                    <button class="btn btn-danger" id="refuseBtn" type="button">拒绝简历</button>
                </c:if>
                <c:if test="${applyEntity.handle }">
                	   <p>您已经处理了本简历</p>
                </c:if>
                </div>
            </div>
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
     <c:if test="${!applyEntity.handle }">
     <script type="text/javascript" src="${pageContext.request.contextPath}/res/js/handle-apply.js"></script>    
     </c:if>
</body>

</html>