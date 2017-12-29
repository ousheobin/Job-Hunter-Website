package cn.gcu.dao;

import java.util.List;

import cn.gcu.entity.VericodeEntity;

public interface VericodeDao extends BaseDao<VericodeEntity,String>{
	
	public List<VericodeEntity> getVericodeByPhone(String phone);

}
