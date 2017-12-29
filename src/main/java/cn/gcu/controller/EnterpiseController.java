package cn.gcu.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.gcu.entity.ApplyEntity;
import cn.gcu.entity.EnterpiseEntity;
import cn.gcu.entity.JobsEntity;
import cn.gcu.pojo.Page;
import cn.gcu.service.ApplyService;
import cn.gcu.service.JobService;
import cn.gcu.utils.PageUtil;

@Controller
public class EnterpiseController {
	
	@Resource
	JobService jobService;
	@Resource
	ApplyService applyService;
	
	@RequestMapping(value="enterprise-login.html")
	public String getEnterpiseLoginPage() {
		return "enterpise/login";
	}
	
	@RequestMapping(value="mgr-apply.html")
	public String getEnterpiseLoginPage(String page,HttpServletRequest request,HttpServletResponse response ) throws IOException {
		String type = (String) request.getSession().getAttribute("type");
		if(type!=null && type.equals("enterpise")) {
			int currentPage = 1;
			if(page!=null && !page.isEmpty()) {
				try {
					currentPage = Integer.valueOf(page);
				}catch(Exception e) {
					
				}
			}
			EnterpiseEntity enterpise = (EnterpiseEntity) request.getSession().getAttribute("enterpiseEntity");
			Page<ApplyEntity> applyPage = applyService.getApplyByEnterpise(enterpise, currentPage);
			request.setAttribute("applyPage", applyPage);
			request.setAttribute("navi", PageUtil.generateBootstrapNav(applyPage, "mgr-apply.html?page=${pageNumber}"));
		}else {
			response.sendRedirect("index.html");
		}
		return "enterpise/mgr-apply";
	}
	
	@RequestMapping(value="mgr-jobs.html")
	public String getEnterpiseJobsPage(String page,HttpServletRequest request,HttpServletResponse response ) throws IOException {
		String type = (String) request.getSession().getAttribute("type");
		if(type!=null && type.equals("enterpise")) {
			int currentPage = 1;
			if(page!=null && !page.isEmpty()) {
				try {
					currentPage = Integer.valueOf(page);
				}catch(Exception e) {
					
				}
			}
			EnterpiseEntity enterpise = (EnterpiseEntity) request.getSession().getAttribute("enterpiseEntity");
			Page<JobsEntity> jobsPage = jobService.getJobsByEnterpise(enterpise, currentPage);
			request.setAttribute("jobsPage", jobsPage);
			request.setAttribute("navi", PageUtil.generateBootstrapNav(jobsPage, "mgr-jobs.html?page=${pageNumber}"));
		}else {
			response.sendRedirect("index.html");
		}
		return "enterpise/mgr-jobs";
	}
	
	@RequestMapping(value="publish-jobs.html")
	public String getPublishJobsPage(HttpServletRequest request,HttpServletResponse response ) throws IOException {
		String type = (String) request.getSession().getAttribute("type");
		if(type!=null && type.equals("enterpise")) {
			
		}else {
			response.sendRedirect("index.html");
		}
		return "enterpise/publish-jobs";
	}

}
