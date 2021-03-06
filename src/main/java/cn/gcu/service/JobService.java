package cn.gcu.service;

import java.util.List;

import cn.gcu.entity.EnterpiseEntity;
import cn.gcu.entity.JobsEntity;
import cn.gcu.pojo.Page;

public interface JobService {
	
	public List<JobsEntity> getAllJob();
	
	public JobsEntity getJobById(String jobId);
	
	public void deleteJob(String jobId);
	
	public void addJob(JobsEntity job);
	
	public Page<JobsEntity> getHomePageJobs();
	
	public Page<JobsEntity> getJobsByEnterpise(EnterpiseEntity enterpise,int page);
	
	public Page<JobsEntity> searchJob(int pageNumber,String keyword);

}
