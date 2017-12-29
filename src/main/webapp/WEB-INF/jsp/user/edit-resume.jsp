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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/style-mine.css" />
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
                    <li class="active">
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
        <p class="title">我</p>
        <p>About Me</p>
    </div>
    <!-- Banner End -->
    <!-- Main Container -->
    <div class="container content">
        <div class="col-md-3">
            <div class="list-group">
                <div class="list-group-item header"> 菜单 Menu</div>
                <a href="mine.html" class="list-group-item">我的投递</a>
                <a href="resume.html" class="list-group-item">我的简历</a>
                <a href="info.html" class="list-group-item">个人信息</a>
            </div>
        </div>
        <div class="col-md-9">
            <div class="list-group row">
                <div class="list-group-item text-left header">申请信息 Offer Information</div>
                <div class="list-group-item text-left">
                    <div class="form-group">
                        <label>本简历用于以下职位:</label>
                        <input class="form-control" placeholder="请输入职位" id="apply-work" value="${resume.applyWork }">
                    </div>
                </div>
            </div>
            <div class="list-group row">
                <div class="list-group-item text-left header">基本信息 Basic Infomation</div>
                <div class="list-group-item text-left">
                    <div class="form-group">
                        <label>姓名</label>
                        <input class="form-control" placeholder="请输入姓名" id="name" value="${resume.name }">
                    </div>
                    <div class="form-group">
                        <label>性别</label>
                        <div class="form-group">
                            <label class="radio-inline" style="margin-left:5px;">
                                <input type="radio" name="gender" id="gender-male" value="男" checked="checked"> 男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender-female" value="女"> 女
                            </label>
                        </div>                  
                    </div>
                    <div class="form-group">
                        <label>出生年月</label>
                        <input class="form-control" type="date" value="1996-01-01" id="birthday" value="${resume.birthday }">
                    </div>
                    <div class="form-group">
                        <label>参加工作时间</label> 
                        <input class="form-control" type="date" value="2017-01-01" id="timeToWork" value="${resume.timeToWork }">
                    </div>
                    <div class="form-group">
                        <label>现居住城市</label>
                        <input class="form-control" placeholder="请输入现在居住的城市" type="text" id="residence" value="${resume.residence }">
                    </div>
                    <div class="form-group">
                        <label>户口所在地</label>
                        <input class="form-control" placeholder="请输入户口所在地" type="text" id="originResidence" value="${resume.originResidence }">
                    </div>
                    <div class="form-group">
                        <label>手机号码</label>
                        <input class="form-control" placeholder="请输入手机号码" type="text" id="phone" value="${resume.phone }">
                    </div>
                    <div class="form-group">
                        <label>电子邮箱</label>
                        <input class="form-control" placeholder="请输入电子邮箱" type="email" id="email" value="${resume.email }">
                    </div>
                </div>
            </div>
            <div class="list-group row">
                <div class="list-group-item text-left header">教育信息 Education Information</div>
                <c:forEach items="${resume.educationDeatil }" var="item">
				    <div class="list-group-item education">
				        <div class="form-group">
				            <label>学校名称</label><input class="form-control" placeholder="请输入学习名称" type="text" name="schoolName" value="${item.schoolName }">
											</div>
				            <div class="form-group">
				                <label>入学时间</label>
				                <input class="form-control" placeholder="请输入入学时间" type="text" name="enrollmentTime" value="${item.enrollmentTime }">
											</div>
				                <div class="form-group">
				                    <label>毕业时间</label><input class="form-control"
				                        placeholder="请输入毕业时间" type="text" name="graduateTime" value="${item.graduateTime }">
											</div>
				                    <div class="form-group" name="graduateTime">
				                        <label>专业</label><input class="form-control"
				                            placeholder="请输入专业名称" type="text" name="major" value="${item.major }">
											</div>
				                        <div class="form-group">
				                            <label>学位学历</label><select class="form-control" name="degree"><option>小学</option>
				                                <option>初中</option>
				                                <option>高中</option>
				                                <option>专科</option>
				                                <option selected>本科</option>
				                                <option>硕士</option>
				                                <option>博士</option>
				                                <option>博士后</option></select>
				                        </div>
				                    </div>
						</c:forEach>
                		<div class="list-group-item text-center" id="add-education-container">
                    		<button class="btn btn-info" id="add-education">添加教育信息</button>
                		</div>
            </div>
            <div class="list-group row experience-list">
                <div class="list-group-item text-left header">工作经历 Work Experience</div>
                <c:forEach items="${resume.experienceDetail }" var="item">
                		<div class="list-group-item experience">
                    <div class="form-group">
                        <label>公司名称</label>
                        <input class="form-control" placeholder="请输入公司名称" type="text" name="companyName" value="${item.companyName }">
                    </div>
                    <div class="form-group">
                        <label>开始时间</label>
                        <input class="form-control" placeholder="请输入开始时间" type="text" name="beginTime" value="${item.beginTime }">
                    </div>
                    <div class="form-group">
                        <label>结束时间</label>
                        <input class="form-control" placeholder="请输入结束时间" type="text" name="endTime" value="${item.endTime }">
                    </div>
                    <div class="form-group">
                        <label>所在行业</label>
                        <input class="form-control" placeholder="请输入所在行业" type="text" name="industry" value="${item.industry }">
                    </div>
                    <div class="form-group">
                        <label>工作描述</label>
                        <textarea class="form-control" rows="5" placeholder="请输入工作描述" name="describe">${item.describe }</textarea>
                    </div>
                </div>
                </c:forEach>
                <div class="list-group-item text-center" id="add-experience-container"><button class="btn btn-info" id="add-experience">添加工作经历</div>
            </div>
            <div class="list-group row">
                <div class="list-group-item text-left header">项目经验 Project Experience</div>
                <div class="list-group-item text-left">
                    <div class="form-group">
                        <textarea class="form-control" rows="10" placeholder="请输入项目经验" id="project">${resume.projectExperience }</textarea>
                    </div>
                </div>
            </div>
            <div class="list-group row">
                <div class="list-group-item text-left header">自我评价 Self-Appraisal</div>
                <div class="list-group-item text-left">
                    <div class="form-group">
                        <textarea class="form-control" rows="10" placeholder="请输入自我评价" id="evaluate">${resume.evaluate }</textarea>
                    </div>
                </div>
            </div>
            <div class="btn btn-block btn-success" id="save-resume">保存简历</div>
        </div>
    </div>
    <div class="footer">
        <p>
            <a href="enterprise-login.html">我要发布招聘信息</a>
        </p>
        <p>Guangzhou College &copy; 2006-2017 All rights reserve.</p>
    </div>
    <!-- Main Container End -->
    <script type="text/javascript">
    		var id = "${resume.id}";
    </script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/res/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/res/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/res/js/resume-editor.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/res/js/user-update-resume.js"></script>
</body>

</html>