package cn.gcu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.gcu.dao.EducationDao;
import cn.gcu.dao.ExperienceDao;
import cn.gcu.dao.ResumeDao;
import cn.gcu.entity.EducationEntity;
import cn.gcu.entity.ExperienceEntity;
import cn.gcu.entity.ResumeEntity;
import cn.gcu.entity.UserEntity;
import cn.gcu.service.ResumeService;

@Service
public class ResumeServiceImpl implements ResumeService {
	
	@Resource
	ResumeDao resumeDao;
	@Resource
	ExperienceDao experienceDao;
	@Resource
	EducationDao educationDao;

	@Override
	@Transactional
	public void addResume(ResumeEntity resume) {
		resumeDao.save(resume);
	}

	@Override
	@Transactional
	public void addExperience(ExperienceEntity expericnce) {
		experienceDao.save(expericnce);
	}

	@Override
	@Transactional
	public void addEducation(EducationEntity education) {
		educationDao.save(education);
	}

	@Override
	@Transactional
	public void updateResume(ResumeEntity resume) {
		resumeDao.update(resume);
	}

	@Override
	@Transactional
	public void deleteExperience(ExperienceEntity experience) {
		experienceDao.delete(experience);
	}

	@Override
	@Transactional
	public void deleteEducation(EducationEntity education) {
		educationDao.delete(education);
	}

	@Override
	@Transactional
	public ResumeEntity getResumeById(String id) {
		ResumeEntity resume =  resumeDao.get(id);
		resume.getExperienceDetail().size();
		resume.getEducationDeatil().size();
		return resume;
	}

	@Override
	public List<ResumeEntity> getResumeByUser(UserEntity user) {
		return resumeDao.getResumeByUser(user);
	}

}
