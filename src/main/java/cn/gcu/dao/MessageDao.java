package cn.gcu.dao;

import java.util.List;

import cn.gcu.entity.MessageEntity;

public interface MessageDao extends BaseDao<MessageEntity,String>{
	
	public List<MessageEntity> getAllMessageByID(String userId);

}
