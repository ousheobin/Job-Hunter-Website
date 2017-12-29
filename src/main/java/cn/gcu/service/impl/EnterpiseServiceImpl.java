package cn.gcu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.gcu.dao.EnterpiseDao;
import cn.gcu.entity.EnterpiseEntity;
import cn.gcu.service.EnterpiseService;

@Service
public class EnterpiseServiceImpl implements EnterpiseService{
	
	@Resource
	EnterpiseDao enterpiseDao;

	@Override
	@Transactional
	public void addEnterpise(EnterpiseEntity enterpise) {
		enterpiseDao.save(enterpise);
	}

	@Override
	public EnterpiseEntity getEnterpiseByUserName(String userName) {
		return enterpiseDao.getEnterpiseByUserName(userName);
	}

	@Override
	public EnterpiseEntity getEnterpiseByEnterpiseName(String enterpiseName) {
		return enterpiseDao.getEnterpiseByEnterpiseName(enterpiseName);
	}
	
}
