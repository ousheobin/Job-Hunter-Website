package cn.gcu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.gcu.dao.JobDao;
import cn.gcu.entity.JobsEntity;
import cn.gcu.pojo.Page;
import cn.gcu.service.JobService;

@Service
public class JobServiceImpl implements JobService{
	
	@Resource
	JobDao jobDao;

	@Override
	public List<JobsEntity> getAllJob() {
		return jobDao.getAll();
	}
	
	@Override
	public JobsEntity getJobById(String jobId) {
		JobsEntity job = jobDao.get(jobId);
		return job;
	}

	@Override
	@Transactional
	public void deleteJob(String jobId) {
		JobsEntity job = jobDao.get(jobId);
		jobDao.delete(job);
	}

	@Override
	@Transactional
	public void addJob(JobsEntity job) {
		jobDao.save(job);
	}

	@Override
	public Page<JobsEntity> getHomePageJobs() {
		return jobDao.queryByPage(1, 8);
	}

}
