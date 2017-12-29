package cn.gcu.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.gcu.dao.BaseDao;
import cn.gcu.pojo.Page;
import cn.gcu.utils.PageUtil;


@SuppressWarnings("all")
public class BaseDaoImpl<T, PrimaryKey extends Serializable> extends HibernateDaoSupport implements BaseDao<T, PrimaryKey> {

	private Class<T> entity;

	public BaseDaoImpl() {
		this.entity = null;
		Class c = getClass();
		Type t = c.getGenericSuperclass();
		if (t instanceof ParameterizedType) {
			Type[] p = ((ParameterizedType) t).getActualTypeArguments();
			this.entity = (Class<T>) p[0];
		}
	}
	
	@Resource(name = "sessionFactory")
	public void setSessionFactoryDI(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Resource
	public void setHibernateTemplateDI(HibernateTemplate hibernateTemplate) {
		super.setHibernateTemplate(hibernateTemplate);
	}

	@Override
	public T get(PrimaryKey id) {
		return (T) getHibernateTemplate().get(entity, id);
	}

	@Override
	public List<T> getAll() {
		return getHibernateTemplate().loadAll(entity);
	}

	@Override
	public void update(T entity) {
		try {
			getHibernateTemplate().update(entity);
		} catch (DataAccessException exception) {

		}
	}

	@Override
	public void save(T entity) {
		try {
			getHibernateTemplate().save(entity);
		} catch (DataAccessException exception) {

		}
	}

	@Override
	public void saveOrUpdate(T entity) {
		try {
			getHibernateTemplate().saveOrUpdate(entity);
		} catch (DataAccessException exception) {

		}
	}

	@Override
	public void delete(T entity) {
		try {
			getHibernateTemplate().delete(entity);
		} catch (DataAccessException exception) {
			
		}
	}

	@Override
	public long count() {
		String type = entity.getTypeName();
		String hql = "select count(*) from " + type;
		return (long) getHibernateTemplate().find(hql).get(0);
	}

	@Override
	public Page<T> queryByPage(int pageNumber , int prePage) {
		long sum = this.count();
		final String hql = "from "+entity.getTypeName()+" order by id desc";
		final Page<T> page = new Page<T>();
		PageUtil.generatePage(page, sum, prePage, pageNumber);
		List<T> res = getHibernateTemplate().execute(new HibernateCallback<List<T>>() {

			@Override
			public List<T> doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(hql);
				query.setFirstResult((int) ((page.getPageNumber()-1)*page.getPageSize()));
				query.setMaxResults((int) page.getPageSize());
				return query.list();
			}  
			 
        });
		page.setPageData(res);
		return page;
	}

}
