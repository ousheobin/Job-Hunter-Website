package cn.gcu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.gcu.service.JobService;

@Controller
public class PageController {
	
	@Resource
	JobService jobService;
	
	
	/**
	 * 处理首页请求
	 * 返回 WEB-INF/jsp/index.jsp 给前台
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value= {"","/","index.html","index"})
	public String getIndexPage(HttpServletRequest request , HttpServletResponse response) {
		request.setAttribute("jobPage", jobService.getHomePageJobs());
		return "public/index";
	}
	
	@RequestMapping(value="discovery.html")
	public String getDiscoveryPage() {
		return "public/discovery";
	}

}
