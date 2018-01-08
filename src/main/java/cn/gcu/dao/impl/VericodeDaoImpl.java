package cn.gcu.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.gcu.dao.VericodeDao;
import cn.gcu.entity.VericodeEntity;

@Repository
@SuppressWarnings("unchecked")
public class VericodeDaoImpl extends BaseDaoImpl<VericodeEntity,String> implements VericodeDao{

	@Override
	public List<VericodeEntity> getVericodeByPhone(String phone) {
		String hql = "from VericodeEntity where phone=? order by generateDate desc";
		List<VericodeEntity> list = (List<VericodeEntity>)this.getHibernateTemplate().find(hql,phone);
		return list;
	}

}
