package cn.gcu.service;

import java.util.List;

import cn.gcu.entity.ApplyEntity;
import cn.gcu.entity.EnterpiseEntity;
import cn.gcu.pojo.Page;

public interface ApplyService {
	
	public List<ApplyEntity> getApplyByUserId(String userId);
	
	public void deleteApply(String applyId);
	
	public void addApply(ApplyEntity apply);
	
	public void updateApply(ApplyEntity apply);
	
	public ApplyEntity getApplyById(String id);
	
	public Page<ApplyEntity> getApplyByEnterpise(EnterpiseEntity enterpise,int pageNumber);
}
