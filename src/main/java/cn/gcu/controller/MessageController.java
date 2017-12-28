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
import cn.gcu.service.UserService;

@Controller
public class MessageController {
	
	@Resource
	MessageService messageService;
	
	@Resource 
	UserService userService;
	
	@RequestMapping(value="message_list")
	@ResponseBody
	public Map<String,Object> getMessageList(HttpServletRequest request,HttpServletResponse response) {
		String userId = request.getParameter("userId");
		List<MessageEntity> mList = messageService.getAllMessage(userId);
		String listString = String.valueOf(mList);
		Map<String,Object> res = new HashMap<String,Object>();
		res.put("messageList", listString);
		return res;
	}
	
	@RequestMapping(value="message_delete")
	public void deleteMessage(HttpServletRequest request,HttpServletResponse response) {
		String messageId = request.getParameter("messageId");
		messageService.deleteMessage(messageId);
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
