package cn.gcu.service;

import java.util.List;

import cn.gcu.entity.EducationEntity;
import cn.gcu.entity.ExperienceEntity;
import cn.gcu.entity.ResumeEntity;
import cn.gcu.entity.UserEntity;

public interface ResumeService {
	
	public void addResume(ResumeEntity resume);
	
	public void addExperience(ExperienceEntity expericnce);
	
	public void addEducation(EducationEntity education);
	
	public void updateResume(ResumeEntity resume);
	
	public void deleteExperience(ExperienceEntity experience);
	
	public void deleteEducation(EducationEntity education);
	
	public ResumeEntity getResumeById(String id);
	
	public List<ResumeEntity> getResumeByUser(UserEntity user);

}
