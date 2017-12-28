package cn.gcu.dao.impl;

import java.util.List;

import cn.gcu.dao.MessageDao;
import cn.gcu.entity.MessageEntity;

public class MessageDaoImpl extends BaseDaoImpl<MessageEntity,String> implements MessageDao{

	@Override
	public List<MessageEntity> getAllMessageByID(String userId) {
		return (List<MessageEntity>)this.getHibernateTemplate().find("from MessageEntity where user.id = ? ", userId);
	}

}
