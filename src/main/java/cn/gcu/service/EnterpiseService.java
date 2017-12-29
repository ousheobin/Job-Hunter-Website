package cn.gcu.service;

import cn.gcu.entity.EnterpiseEntity;

public interface EnterpiseService {
	
	public void addEnterpise(EnterpiseEntity enterpise);
	
	public EnterpiseEntity getEnterpiseByUserName(String userName);
	
	public EnterpiseEntity getEnterpiseByEnterpiseName(String enterpiseName);
	
}
