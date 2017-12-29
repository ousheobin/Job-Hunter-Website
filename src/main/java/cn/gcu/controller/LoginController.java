package cn.gcu.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.gcu.entity.EnterpiseEntity;
import cn.gcu.entity.UserEntity;
import cn.gcu.entity.VericodeEntity;
import cn.gcu.service.EnterpiseService;
import cn.gcu.service.UserService;
import cn.gcu.service.VericodeService;
import cn.gcu.utils.SecurityUtil;
import cn.gcu.utils.VericodeUtil;

@Controller
public class LoginController {
	
	@Resource
	UserService userService;
	
	@Resource
	EnterpiseService enterpiseService;
	
	@Resource
	VericodeService vericodeService;
	
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
	
	@RequestMapping(value="regisiter.html")
	public String getRegisiterPage(HttpServletRequest request,HttpServletResponse response) {
		return "public/regisiter";
	}
	
	@RequestMapping(value="forget-password.html")
	public String getForgetPasswordPage(HttpServletRequest request,HttpServletResponse response) {
		return "public/forget-password";
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
	
	@RequestMapping(value="user_register")
	@ResponseBody
	public Map<String ,Object>userRegister(HttpServletRequest request,HttpServletResponse response){
		Map<String ,Object> res = new HashMap<String ,Object>();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String code = request.getParameter("vericode");
		if(!username.isEmpty()&&!password.isEmpty()&&!phone.isEmpty()) {
			UserEntity user = userService.getUserByUserName(username);
				if(user!=null) {
					res.put("status", "error");
					res.put("message", "该用户已注册");
					return res;
				}
			VericodeEntity vericode = vericodeService.getVericodeByPhone(phone);
			if(vericode!=null) {
				if(vericode.getCode().equals(code)) {
					user = new UserEntity();
					user.setMobilePhone(phone);
					user.setPassword(SecurityUtil.encryptPassword(password));
					user.setUserName(username);
					userService.addUser(user);
					res.put("status", "ok");
					res.put("nextStep", "index.html");
					request.getSession().setAttribute("isLogin", true);
					request.getSession().setAttribute("type", "user");
					request.getSession().setAttribute("userEntity", user);
				
				}
				else {
					res.put("status", "error");
					res.put("message", "验证码错误");
				}
			}
			else {
				res.put("status", "error");
				res.put("message", "验证码过期");
			}
		}
		else {
			res.put("status", "error");
			res.put("message","请求有误");
		}
		return res;
	}
	
	@RequestMapping(value="enterpise_login_confirm")
	@ResponseBody
	public Map<String ,Object> enterpiseLogin(HttpServletRequest request,HttpServletResponse response){
		Map<String ,Object> res = new HashMap<String ,Object>();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(!username.isEmpty()&&!password.isEmpty()) {
			EnterpiseEntity enterpise = enterpiseService.getEnterpiseByUserName(username);
			if(enterpise!=null) {
				String enterpisePassword = SecurityUtil.encryptPassword(password);
				if(enterpisePassword.equals(enterpise.getPassword())) {
					res.put("status", "ok");
					res.put("nextStep", "index.html");
					request.getSession().setAttribute("isLogin", true);
					request.getSession().setAttribute("type", "enterpise");
					request.getSession().setAttribute("enterpiseEntity", enterpise);
				}
				else {
					res.put("status", "error");
					res.put("message", "账户或密码有误");
				}
			}
			else {
				res.put("status", "error");
				res.put("message", "账号或密码有误");
			}
		}
		else {
			res.put("status", "error");
			res.put("message", "请求有误");
		}
		return res;
	}
	
	@RequestMapping(value="enterpise_register")
	@ResponseBody
	public Map<String ,Object> enterpiseRegister(HttpServletRequest request,HttpServletResponse response){
		Map<String ,Object> res = new HashMap<String ,Object>();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String enterpiseName = request.getParameter("enterpiseName");
		EnterpiseEntity enterpise = enterpiseService.getEnterpiseByUserName(username);
		if(!username.isEmpty()&&!password.isEmpty()&&!enterpiseName.isEmpty()) {
			if(enterpise==null) {
				enterpise = enterpiseService.getEnterpiseByEnterpiseName(enterpiseName);
				if(enterpise==null) {
					enterpise = new EnterpiseEntity();
					enterpise.setEnterpiseName(enterpiseName);
					enterpise.setPassword(SecurityUtil.encryptPassword(password));
					enterpise.setUserName(username);
					enterpiseService.addEnterpise(enterpise);
					res.put("status", "ok");
					res.put("nextStep","index.html");
					request.getSession().setAttribute("isLogin", true);
					request.getSession().setAttribute("type", "enterpise");
					request.getSession().setAttribute("enterpiseEntity", enterpise);
				}
				else {
					res.put("status", "error");
					res.put("message", "公司名称已注册");
				}
			}
			else {
				res.put("status", "error");
				res.put("message","账号已注册");
			}
		}
		return res;
	}
	
	@RequestMapping(value="getVericode")
	@ResponseBody
	public Map<String ,Object> getVericode(HttpServletRequest request,HttpServletResponse response){
		Map<String ,Object> res = new HashMap<String ,Object>();
		Date getVericodeDate = (Date)request.getSession().getAttribute("getVericodeDate");
		String phone = request.getParameter("phone");
		if(getVericodeDate.compareTo(new Date())<0) {
			String verificationCode = VericodeUtil.sendVerificationCode();
			Date generateDate = new Date();
			Date expireDate = new Date(generateDate.getTime()+60000);
			request.getSession().setAttribute("getVericodeDate", expireDate);
			VericodeEntity vericode = new VericodeEntity();
			vericode.setCode(verificationCode);
			vericode.setGenerateDate(generateDate);
			vericode.setExpireDate(expireDate);
			vericode.setPhone(phone);
			vericodeService.addVericode(vericode);
			res.put("status", "ok");
		}
		else {
			res.put("status", "error");
			res.put("message", "请求过于频繁，请稍后再试");
		}
		return res;
	}
	
	@RequestMapping(value="forget_password")
	@ResponseBody
	public Map<String ,Object> forgetPassword(HttpServletRequest request,HttpServletResponse response){
		Map<String ,Object> res = new HashMap<String ,Object>();
		String username = request.getParameter("username");
		String code = request.getParameter("vericode");
		String newPassword = request.getParameter("newPassword");
		String phone = request.getParameter("phone");
		VericodeEntity vericode = vericodeService.getVericodeByPhone(phone);
		if(vericode!=null) {
			if(vericode.getCode().equals(code)) {
				UserEntity user = userService.getUserByUserName(username);
				user.setPassword(SecurityUtil.encryptPassword(newPassword));
				userService.updateUser(user);
				res.put("status", "ok");
				request.getSession().setAttribute("isLogin", true);
				request.getSession().setAttribute("type", "user");
				request.getSession().setAttribute("userEntity", user);
			}
			else {
				res.put("status", "error");
				res.put("message", "验证码错误");
			}
		}
		else {
			res.put("status", "error");
			res.put("message", "验证码过期");
		}
		return res;
	}
}
