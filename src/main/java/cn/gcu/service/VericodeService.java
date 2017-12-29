package cn.gcu.service;

import cn.gcu.entity.VericodeEntity;

public interface VericodeService {
	
	public void addVericode(VericodeEntity vericode);
	
	public VericodeEntity getVericodeByPhone(String phone);

}
