package cn.gcu.dao;

import cn.gcu.entity.EnterpiseEntity;

public interface EnterpiseDao extends BaseDao<EnterpiseEntity ,String>{
	
	public EnterpiseEntity getEnterpiseByUserName(String userName);
	
	public EnterpiseEntity getEnterpiseByEnterpiseName(String enterpiseName);
	
}
