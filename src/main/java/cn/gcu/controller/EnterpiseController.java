package cn.gcu.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
		if(type==null || !type.equals("enterpise")) {
			response.sendRedirect("index.html");
		}
		return "enterpise/publish-jobs";
	}
	
	@RequestMapping(value="view-apply.html")
	public String viewApply( String id, HttpServletRequest request,HttpServletResponse response ) throws IOException {
		String type = (String) request.getSession().getAttribute("type");
		if(type==null || !type.equals("enterpise")) {
			response.sendRedirect("index.html");
		}
		if(id!=null && id.length() > 0){
			ApplyEntity apply = applyService.getApplyById(id);
			if(apply!=null) {
				request.setAttribute("applyEntity", apply);
			}else {
				response.sendRedirect("mgr-apply.html");
			}
		}else {
			response.sendRedirect("mgr-apply.html");
		}
		
		return "enterpise/view-apply";
	}
	
	@RequestMapping(value="enterpise/handle_apply")
	@ResponseBody
	public Map<String,Object> handleApply( String id, String flag,HttpServletRequest request,HttpServletResponse response ) throws IOException {
		Map<String,Object> res  = new HashMap<String,Object>();
		String type = (String) request.getSession().getAttribute("type");
		EnterpiseEntity enterpise = (EnterpiseEntity) request.getSession().getAttribute("enterpiseEntity");
		if(type==null || !type.equals("enterpise")) {
			response.sendRedirect("index.html");
		}
		if(id!=null && id.length() > 0){
			ApplyEntity apply = applyService.getApplyById(id);
			if(apply!=null) {
				if(enterpise.getId().equals(apply.getJob().getEnterpise().getId())) {
					apply.setHandle(true);
					if(flag!=null && flag.equals("accept")) {
						apply.setOffer(true);
					}else {
						apply.setOffer(false);
					}
					applyService.updateApply(apply);
					res.put("status", "ok");
				}else {
					res.put("status", "error");
				}
			}else {
				res.put("status", "error");
			}
		}else {
			res.put("status", "error");
		}
		
		return res;
	}

}
