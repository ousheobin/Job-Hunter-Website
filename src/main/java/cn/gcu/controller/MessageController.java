package cn.gcu.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.gcu.entity.MessageEntity;
import cn.gcu.service.MessageService;
import cn.gcu.entity.UserEntity;
import cn.gcu.pojo.Page;
import cn.gcu.service.UserService;
import cn.gcu.utils.PageUtil;

@Controller
public class MessageController {
	
	@Resource
	MessageService messageService;
	
	@Resource 
	UserService userService;
	
	@RequestMapping(value="message.html")
	public String getMessagePage(String page,HttpServletRequest request) {
		UserEntity user = (UserEntity) request.getSession().getAttribute("userEntity");
		String userId = user.getId();
		int pageNumber  = 1;
		try {
			pageNumber = Integer.valueOf(page);
		}catch(Exception e) {
			
		}
		Page<MessageEntity> pageBean = messageService.queryByPage(pageNumber, userId);
		String pageNavi = PageUtil.generateBootstrapNav(pageBean, "message.html?page=${pageNumber}");
		request.setAttribute("pageBean", pageBean);
		request.setAttribute("pageNavi", pageNavi);
		return "user/message";
	}
	
//	@RequestMapping(value="message_list")
	@ResponseBody
	public Map<String,Object> getMessageList(HttpServletRequest request,HttpServletResponse response) {
		UserEntity user = (UserEntity) request.getSession().getAttribute("userEntity");
		String userId = user.getId();
		List<MessageEntity> mList = messageService.getAllMessage(userId);
		String listString = String.valueOf(mList);
		Map<String,Object> res = new HashMap<String,Object>();
		res.put("messageList", listString);
		return res;
	}
	
	@RequestMapping(value="user/message_delete")
	@ResponseBody
	public Map<String,Object> deleteMessage(HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> res = new HashMap<String,Object>();
		String messageId = request.getParameter("messageId");
		UserEntity user = (UserEntity) request.getSession().getAttribute("userEntity");
		String userId = user.getId();
		MessageEntity msg = messageService.getMessageById(messageId);
		if(msg!=null && msg.getId()!=null) {
			if(msg.getUser().getId().equals(userId)) {
				messageService.deleteMessage(messageId);
				res.put("status", "ok");
			}else {
				res.put("status", "error");
			}
		}else {
			res.put("status", "error");
		}
		return res;
	}
	
	@RequestMapping(value="message_add")
	public void addMessage(HttpServletRequest request,HttpServletResponse response) {
		String userId = request.getParameter("userId");
		String messageContent = request.getParameter("messageContent");
//		Date date = (Date) request.getAttribute("date");
		UserEntity user = userService.getUserById(userId);
		MessageEntity message = new MessageEntity();
//		message.setDate(date);
		message.setMessage(messageContent);
		message.setUser(user);
		messageService.addMessage(message);
	}
	
}
