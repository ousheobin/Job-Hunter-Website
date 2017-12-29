package cn.gcu.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.gcu.dao.EnterpiseDao;
import cn.gcu.entity.EnterpiseEntity;

@Repository
public class EnterpiseDaoImpl extends BaseDaoImpl<EnterpiseEntity ,String> implements EnterpiseDao{

	@Override
	public EnterpiseEntity getEnterpiseByUserName(String userName) {
		String hql = "from EnterpiseEntity where userName=?";
		List<EnterpiseEntity> list = (List<EnterpiseEntity>)this.getHibernateTemplate().find(hql, userName);
		if(list.isEmpty()) {
			return null;
		}
		else {
			return list.get(0);
		}
	}

	@Override
	public EnterpiseEntity getEnterpiseByEnterpiseName(String enterpiseName) {
		String hql = "from EnterpiseEntity where enterpiseName=?";
		List<EnterpiseEntity> list = (List<EnterpiseEntity>)this.getHibernateTemplate().find(hql, enterpiseName);
		if(list.isEmpty()) {
			return null;
		}
		else {
			return list.get(0);
		}
	}

}
