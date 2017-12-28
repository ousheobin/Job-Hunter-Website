package cn.gcu.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.gcu.service.UserService;

@Controller
public class LoginController {
	
	@Resource
	UserService userService;
	
	/**
	 * 同步请求，返回JSP
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="login.html")
	public String getLoginPage(HttpServletRequest request,HttpServletResponse response) {
		return "login";
	}
	
	/**
	 * 异步请求返回JSON串
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="login_comfirm")
	@ResponseBody
	public Map<String,Object> doLoginComfirm(HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> res = new HashMap<String,Object>();
		res.put("status", "ok");
		res.put("nextStep", "index.html");
		return res;
	}
}
