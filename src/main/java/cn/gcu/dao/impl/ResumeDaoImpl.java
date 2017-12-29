package cn.gcu.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.gcu.dao.ResumeDao;
import cn.gcu.entity.ResumeEntity;
import cn.gcu.entity.UserEntity;

@Repository
public class ResumeDaoImpl extends BaseDaoImpl < ResumeEntity, String > implements ResumeDao {

	@Override
	public List<ResumeEntity> getResumeByUser(UserEntity user) {
		String hql = "from ResumeEntity where user = ? ";
		return (List<ResumeEntity>) getHibernateTemplate().find(hql, user);
	}

}
