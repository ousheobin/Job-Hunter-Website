package cn.gcu.dao;

import cn.gcu.entity.EnterpiseEntity;
import cn.gcu.entity.JobsEntity;
import cn.gcu.pojo.Page;

public interface JobDao extends BaseDao<JobsEntity,String>{
	
	public Page<JobsEntity> searchJob(int pageNumber,int prePage,String keyword);
	
	public Page<JobsEntity> getJobsByEnterpise(EnterpiseEntity enterpise,int prePage,int page);

}
