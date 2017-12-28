package cn.gcu.dao;

import java.util.List;

import cn.gcu.entity.ApplyEntity;

public interface ApplyDao extends BaseDao<ApplyEntity,String>{
	
	public List<ApplyEntity> getApplyByUserId(String userId);
	
}
