package cn.gcu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	
	/**
	 * 处理首页请求
	 * 返回 WEB-INF/jsp/index.jsp 给前台
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value= {"","/","index.html","index"})
	public String getIndexPage(HttpServletRequest request , HttpServletResponse response) {
		return "index";
	}

}
