package cn.gcu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.gcu.dao.MessageDao;
import cn.gcu.entity.MessageEntity;
import cn.gcu.pojo.Page;
import cn.gcu.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService{
	
	@Resource
	MessageDao messageDao;

	@Override
	public List<MessageEntity> getAllMessage(String userId) {
		return messageDao.getAllMessageByID(userId);
	}

	@Override
	@Transactional
	public void deleteMessage(String messageId) {
		MessageEntity message = messageDao.get(messageId);
		messageDao.delete(message);
	}

	@Override
	@Transactional
	public void addMessage(MessageEntity message) {
		messageDao.save(message);
	}

	@Override
	public Page<MessageEntity> queryByPage(int pageNumber, String userId) {
		return messageDao.queryByPage(pageNumber, 15, userId);
	}
	
	
}
