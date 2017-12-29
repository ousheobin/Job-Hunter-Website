package cn.gcu.dao;

import java.util.List;

import cn.gcu.entity.MessageEntity;
import cn.gcu.pojo.Page;

public interface MessageDao extends BaseDao<MessageEntity,String>{
	
	public List<MessageEntity> getAllMessageByID(String userId);
	
	public Page<MessageEntity> queryByPage(int pageNumber,int prePage,String userId); 

}
