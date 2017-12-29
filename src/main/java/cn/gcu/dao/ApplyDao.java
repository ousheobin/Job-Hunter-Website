package cn.gcu.dao;

import java.util.List;

import cn.gcu.entity.ApplyEntity;
import cn.gcu.entity.EnterpiseEntity;
import cn.gcu.pojo.Page;

public interface ApplyDao extends BaseDao<ApplyEntity,String>{
	
	public List<ApplyEntity> getApplyByUserId(String userId);
	
	public Page<ApplyEntity> getApplyByEnterpise(EnterpiseEntity enterpise, int prePage, int pageNumber);
	
}
