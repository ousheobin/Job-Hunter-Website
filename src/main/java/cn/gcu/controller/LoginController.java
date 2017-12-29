package cn.gcu.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.gcu.entity.UserEntity;
import cn.gcu.service.UserService;
import cn.gcu.utils.SecurityUtil;

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
		return "public/default-login";
	}
	
	/**
	 * 异步请求返回JSON串
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="public/login_comfirm")
	@ResponseBody
	public Map<String,Object> doLoginComfirm(String username, String password ,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> res = new HashMap<String,Object>();
		if(!username.isEmpty() && ! password.isEmpty()) {
			UserEntity userEntity = userService.getUserByUserName(username);
			if( userEntity!=null ) {
				String encryptPassword = SecurityUtil.encryptPassword(password);
				if(encryptPassword.equals(userEntity.getPassword())) {
					res.put("status", "ok");
					res.put("nextStep", "index.html");
					request.getSession().setAttribute("isLogin", true);
					request.getSession().setAttribute("type", "user");
					request.getSession().setAttribute("userEntity", userEntity);
				}else {
					res.put("status", "error");
					res.put("message", "账户或密码有误");
				}
			}else {
				res.put("status", "error");
				res.put("message", "账户或密码有误");
			}
		}else {
			res.put("status", "error");
			res.put("message", "请求有误");
		}
		return res;
	}
}
