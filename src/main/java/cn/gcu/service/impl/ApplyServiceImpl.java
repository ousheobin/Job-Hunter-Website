package cn.gcu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.gcu.dao.ApplyDao;
import cn.gcu.entity.ApplyEntity;
import cn.gcu.entity.EnterpiseEntity;
import cn.gcu.pojo.Page;
import cn.gcu.service.ApplyService;

@Service
public class ApplyServiceImpl implements ApplyService {
	
	@Resource
	ApplyDao applyDao;

	@Override
	@Transactional
	public List<ApplyEntity> getApplyByUserId(String userId) {
		return applyDao.getApplyByUserId(userId);
	}

	@Override
	@Transactional
	public void deleteApply(String applyId) {
	 	ApplyEntity apply =  applyDao.get(applyId);
		applyDao.delete(apply);
	}

	@Override
	@Transactional
	public void addApply(ApplyEntity apply) {
		applyDao.save(apply);
	}

	@Override
	public Page<ApplyEntity> getApplyByEnterpise(EnterpiseEntity enterpise, int pageNumber) {
		return applyDao.getApplyByEnterpise(enterpise, 5, pageNumber);
	}

	@Override
	@Transactional
	public ApplyEntity getApplyById(String id) {
		ApplyEntity apply = applyDao.get(id);
		apply.getResume().getEducationDeatil().size();
		apply.getResume().getExperienceDetail().size();
		return apply;
	}

	@Override
	@Transactional
	public void updateApply(ApplyEntity apply) {
		applyDao.update(apply);
	}

}
