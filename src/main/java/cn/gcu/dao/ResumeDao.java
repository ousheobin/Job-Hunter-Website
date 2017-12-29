package cn.gcu.dao;

import java.util.List;

import cn.gcu.entity.ResumeEntity;
import cn.gcu.entity.UserEntity;

public interface ResumeDao extends BaseDao<ResumeEntity,String> {
	
	public List<ResumeEntity> getResumeByUser(UserEntity user);

}
