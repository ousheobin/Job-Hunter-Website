package cn.gcu.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.gcu.dao.UserDao;
import cn.gcu.entity.UserEntity;

@Repository
@SuppressWarnings("unchecked")
public class UserDaoImpl extends BaseDaoImpl<UserEntity,String> implements UserDao {

	@Override
	public UserEntity getUserByUserName(String userName) {
		String hql = "from UserEntity where userName = ?";
		List<UserEntity> res = (List<UserEntity>) getHibernateTemplate().find(hql, userName);
		if(res.isEmpty()) {
			return null;
		}else {
			return res.get(0);
		}
	}

}
