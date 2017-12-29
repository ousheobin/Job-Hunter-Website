package cn.gcu.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import cn.gcu.dao.MessageDao;
import cn.gcu.entity.JobsEntity;
import cn.gcu.entity.MessageEntity;
import cn.gcu.pojo.Page;
import cn.gcu.utils.PageUtil;

@Repository
public class MessageDaoImpl extends BaseDaoImpl<MessageEntity,String> implements MessageDao{

	@Override
	public List<MessageEntity> getAllMessageByID(String userId) {
		return (List<MessageEntity>)this.getHibernateTemplate().find("from MessageEntity where user.id = ? ", userId);
	}
	
	public long countByUser(String userId) {
		String hql = "select count(*) from MessageEntity where user.id = ?";
		return (long) getHibernateTemplate().find(hql,userId).get(0);
	}

	@Override
	public Page<MessageEntity> queryByPage(int pageNumber, int prePage, String userId) {
		long sum = this.countByUser(userId);
		final String hql = "from MessageEntity where user.id = ? order by id desc";
		final Page<MessageEntity> page = new Page<MessageEntity>();
		PageUtil.generatePage(page, sum, prePage, pageNumber);
		List<MessageEntity> res = getHibernateTemplate().execute(new HibernateCallback<List<MessageEntity>>() {

			@Override
			public List<MessageEntity> doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(hql);
				query.setString(0,userId);
				query.setFirstResult((int) ((page.getPageNumber()-1)*page.getPageSize()));
				query.setMaxResults((int) page.getPageSize());
				return query.list();
			}  
			 
        });
		page.setPageData(res);
		return page;
	}

}
