package cn.gcu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import cn.gcu.dao.JobDao;
import cn.gcu.entity.EnterpiseEntity;
import cn.gcu.entity.JobsEntity;
import cn.gcu.pojo.Page;
import cn.gcu.utils.PageUtil;

@Repository
public class JobDaoImpl extends BaseDaoImpl<JobsEntity,String> implements JobDao{
	
	@Override
	public Page<JobsEntity> queryByPage(int pageNumber , int prePage) {
		long sum = this.count();
		final String hql = "from JobsEntity where isDelete = ? order by id desc";
		final Page<JobsEntity> page = new Page<JobsEntity>();
		PageUtil.generatePage(page, sum, prePage, pageNumber);
		List<JobsEntity> res = getHibernateTemplate().execute(new HibernateCallback<List<JobsEntity>>() {

			@Override
			public List<JobsEntity> doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(hql);
				query.setBoolean(0,false);
				query.setFirstResult((int) ((page.getPageNumber()-1)*page.getPageSize()));
				query.setMaxResults((int) page.getPageSize());
				return query.list();
			}  
			 
        });
		page.setPageData(res);
		return page;
	}

	public long countByUser(String keyword) {
		String hql = "select count(*) from JobsEntity where jobName like ? or enterpise.enterpiseName like ? ";
		return (long) getHibernateTemplate().find(hql,"%"+keyword+"%","%"+keyword+"%").get(0);
	}
	
	@Override
	public Page<JobsEntity> searchJob(int pageNumber, int prePage, String keyword) {
		long sum = this.count();
		final String hql = "from JobsEntity where isDelete = ? and ( jobName like ? or enterpise.enterpiseName like ? ) order by id desc";
		final Page<JobsEntity> page = new Page<JobsEntity>();
		PageUtil.generatePage(page, sum, prePage, pageNumber);
		List<JobsEntity> res = getHibernateTemplate().execute(new HibernateCallback<List<JobsEntity>>() {

			@Override
			public List<JobsEntity> doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(hql);
				query.setBoolean(0,false);
				query.setString(1, "%"+keyword+"%");
				query.setString(2, "%"+keyword+"%");
				query.setFirstResult((int) ((page.getPageNumber()-1)*page.getPageSize()));
				query.setMaxResults((int) page.getPageSize());
				return query.list();
			}  
			 
        });
		page.setPageData(res);
		return page;
	}
	
	public long countByEnterpise(EnterpiseEntity enterpise) {
		String hql = "select count(*) from JobsEntity where enterpise  = ? ";
		return (long) getHibernateTemplate().find(hql,enterpise).get(0);
	}

	@Override
	public Page<JobsEntity> getJobsByEnterpise(EnterpiseEntity enterpise, int prePage, int pageNumber) {
		long sum = this.count();
		final String hql = "from JobsEntity where isDelete = ? and enterpise = ? order by id desc";
		final Page<JobsEntity> page = new Page<JobsEntity>();
		PageUtil.generatePage(page, sum, prePage, pageNumber);
		List<JobsEntity> res = getHibernateTemplate().execute(new HibernateCallback<List<JobsEntity>>() {

			@Override
			public List<JobsEntity> doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(hql);
				query.setBoolean(0,false);
				query.setEntity(1, enterpise);
				query.setFirstResult((int) ((page.getPageNumber()-1)*page.getPageSize()));
				query.setMaxResults((int) page.getPageSize());
				return query.list();
			}  
			 
        });
		page.setPageData(res);
		return page;
	}

}
