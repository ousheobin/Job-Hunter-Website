package cn.gcu.service;

import java.util.List;

import cn.gcu.entity.MessageEntity;
import cn.gcu.pojo.Page;

public interface MessageService {
	
	public List<MessageEntity> getAllMessage(String userId);
	
	public void deleteMessage(String messageId);
	
	public void addMessage(MessageEntity message);
	
	public Page<MessageEntity> queryByPage(int pageNumber ,  String userId);
}
