package cn.gcu.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import cn.gcu.dao.ApplyDao;
import cn.gcu.entity.ApplyEntity;
import cn.gcu.entity.EnterpiseEntity;
import cn.gcu.pojo.Page;
import cn.gcu.utils.PageUtil;

@Repository
public class ApplyDaoImpl extends BaseDaoImpl<ApplyEntity,String> implements ApplyDao{

	@Override
	public List<ApplyEntity> getApplyByUserId(String userId) {
		return (List<ApplyEntity>)this.getHibernateTemplate().find("from ApplyEntity where user.id = ?", userId);
	}
	
	public long countByEnterpise(EnterpiseEntity enterpise) {
		String hql = "select count(*) from ApplyEntity where job.enterpise = ? ";
		return (long) getHibernateTemplate().find(hql,enterpise).get(0);
	}

	@Override
	public Page<ApplyEntity> getApplyByEnterpise(EnterpiseEntity enterpise, int prePage, int pageNumber) {
		long sum = this.count();
		final String hql = "from ApplyEntity where job.enterpise = ? order by id desc";
		final Page<ApplyEntity> page = new Page<ApplyEntity>();
		PageUtil.generatePage(page, sum, prePage, pageNumber);
		List<ApplyEntity> res = getHibernateTemplate().execute(new HibernateCallback<List<ApplyEntity>>() {

			@Override
			public List<ApplyEntity> doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(hql);
				query.setEntity(0, enterpise);
				query.setFirstResult((int) ((page.getPageNumber()-1)*page.getPageSize()));
				query.setMaxResults((int) page.getPageSize());
				return query.list();
			}  
			 
        });
		page.setPageData(res);
		return page;
	}

}
