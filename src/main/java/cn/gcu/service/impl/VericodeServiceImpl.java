package cn.gcu.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.gcu.dao.VericodeDao;
import cn.gcu.entity.VericodeEntity;
import cn.gcu.service.VericodeService;

@Service
public class VericodeServiceImpl implements VericodeService{
	
	@Resource
	VericodeDao vericodeDao;

	@Override
	@Transactional
	public void addVericode(VericodeEntity vericode) {
		vericodeDao.save(vericode);
	}

	@Override
	public VericodeEntity getVericodeByPhone(String phone) {
		List<VericodeEntity> list = vericodeDao.getVericodeByPhone(phone);
		if(list.isEmpty()) {
			return null;
		}
		else {
			VericodeEntity vericode = list.get(0);
			Date nowDate = new Date();
			if(nowDate.compareTo(vericode.getExpireDate())>0) {
				return vericode;
			}
			else {
				return null;
			}
		}
	}

}
