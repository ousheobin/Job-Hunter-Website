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
		if(!username.isEmpty()&&!password.isEmpty()&&!phone.isEmpty()) {
			UserEntity user = userService.getUserByUserName(username);
			if(user==null) {
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
				res.put("message", "该用户已注册");
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
	
	@RequestMapping(value="findpassword")
	@ResponseBody
	public Map<String ,Object> findPassword(HttpServletRequest request,HttpServletResponse response){
		Map<String ,Object> res = new HashMap<String ,Object>();
		String username = request.getParameter("username");
		String mobilePhone = request.getParameter("mobilePhone");
		if(!username.isEmpty()&&!mobilePhone.isEmpty()) {
			Date getVericodeDate = (Date)request.getSession().getAttribute("getVericodeDate");
			if(getVericodeDate.compareTo(new Date())<0) {
				UserEntity user = userService.getUserByUserName(username);
				if(user!=null) {
					//生成并发送验证码
					String verificationCode = VericodeUtil.sendVerificationCode();
					Date generateDate = new Date();
					Date expireDate = new Date(generateDate.getTime()+60000);
					request.getSession().setAttribute("getVericodeDate", expireDate);
					VericodeEntity vericode = new VericodeEntity();
					vericode.setCode(verificationCode);
					vericode.setGenerateDate(generateDate);
					vericode.setExpireDate(expireDate);
					vericode.setPhone(mobilePhone);
					vericodeService.addVericode(vericode);
				}
				else {
					res.put("status", "error");
					res.put("message", "该用户名为空");
				}
			}
			else {
				res.put("status", "error");
				res.put("message", "请求过于频繁，请稍后再试");
			}
		}
		else {
			res.put("status", "error");
			res.put("message","请求有误");
		}
		return res;
	}
	
	@RequestMapping(value="verificationCode")
	@ResponseBody
	public Map<String ,Object> checkVeriCode(HttpServletRequest request,HttpServletResponse response){
		Map<String ,Object> res = new HashMap<String ,Object>();
		String username = request.getParameter("username");
		String phone = request.getParameter("phone");
		String code = request.getParameter("vericode");
		if(!phone.isEmpty()&&!code.isEmpty()) {
			VericodeEntity vericode = vericodeService.getVericodeByPhone(phone);
			if(vericode!=null) {
				if(vericode.getCode().equals(code)) {
					UserEntity user = userService.getUserByUserName(username);
					res.put("status", "ok");
					//跳到设置密码页面
					//res.put("nextStep", "setpassword.html");
					res.put("oldSecurityPassword", user.getPassword());
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
				res.put("message","验证码已过期");
			}
		}
		else {
			res.put("status", "error");
			res.put("message", "请求有误");
		}
		return res;
	}

	@RequestMapping(value="modifypassword")
	@ResponseBody
	public Map<String ,Object> modifPassword(HttpServletRequest request,HttpServletResponse response){
		Map<String ,Object> res = new HashMap<String ,Object>();
		String username = request.getParameter("username");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		boolean isSecurity = Boolean.parseBoolean("isSecurity");
		if(!oldPassword.isEmpty()&&!newPassword.isEmpty()&&!username.isEmpty()) {
			UserEntity user = userService.getUserByUserName(username);
			String password = isSecurity?oldPassword:SecurityUtil.encryptPassword(oldPassword);
			if(user.getPassword().equals(password)) {
				UserEntity userEntity = new UserEntity();
				userEntity.setPassword(SecurityUtil.encryptPassword(newPassword));
				userEntity.setUserName(username);
				userService.updateUser(user);
				res.put("status", "ok");
				res.put("nextStep", "index.html");
				request.getSession().setAttribute("isLogin", true);
				request.getSession().setAttribute("type", "user");
				request.getSession().setAttribute("userEntity", userService.getUserByUserName(username));
			}
			else {
				res.put("status", "error");
				res.put("message", "旧密码错误");
			}
		}
		else {
			res.put("status", "error");
			res.put("message", "请求有误");
		}
		return res;
	}
}
