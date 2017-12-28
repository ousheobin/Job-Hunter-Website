package cn.gcu.service;

import java.util.List;

import cn.gcu.entity.ApplyEntity;

public interface ApplyService {
	
	public List<ApplyEntity> getApplyByUserId(String userId);
	
	public void deleteApply(String applyId);
	
	public void addApply(ApplyEntity apply);
}
