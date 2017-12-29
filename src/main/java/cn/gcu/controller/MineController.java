package cn.gcu.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.gcu.entity.ApplyEntity;
import cn.gcu.entity.EducationEntity;
import cn.gcu.entity.ExperienceEntity;
import cn.gcu.entity.ResumeEntity;
import cn.gcu.entity.UserEntity;
import cn.gcu.service.ResumeService;

@Controller
public class MineController {
	
	@Resource
	ResumeService resumeService;

	@RequestMapping(value="resume.html")
	public String getResumePage(HttpServletRequest request) {
		UserEntity user = (UserEntity) request.getSession().getAttribute("userEntity");
		request.setAttribute("resumes", resumeService.getResumeByUser(user));
		return "user/resume";
	}
	
	@RequestMapping(value="add-resume.html")
	public String addResumePage() {
		return "user/add-resume";
	}
	
	@RequestMapping(value="info.html")
	public String getInfoPage() {
		return "user/info";
	}
	
	@RequestMapping(value="edit-resume.html")
	public String editResume(String resumeId) {
		return "user/edit-resume";
	}
	
	@RequestMapping(value="user/add_resume")
	public Map<String,Object> doAddResume(String name,String gender,String phone,String email,String applyWork,
			String birthday,String timeToWork,String residence,String orginResidence, String educationList, String experienceList, 
			String evaluate, String projectExperience,HttpServletRequest request) throws IOException{
		ObjectMapper objm = new ObjectMapper();
		List<EducationEntity> educationListObj = objm.readValue(educationList,new TypeReference<List<EducationEntity>>(){});
		List<ExperienceEntity> experienceListObj = objm.readValue(educationList,new TypeReference<List<ExperienceEntity>>(){});
		UserEntity user = (UserEntity) request.getSession().getAttribute("userEntity");
		ResumeEntity resume = new ResumeEntity();
		resume.setApplyWork(applyWork);
		resume.setBirthday(birthday);
		resume.setEmail(email);
		resume.setEvaluate(evaluate);
		resume.setGender(gender);
		resume.setName(name);
		resume.setOrginResidence(orginResidence);
		resume.setPhone(phone);
		resume.setProjectExperience(projectExperience);
		resume.setResidence(residence);
		resume.setTimeToWork(timeToWork);
		resume.setUser(user);
		resumeService.addResume(resume);
		if(educationListObj!=null && !educationListObj.isEmpty()) {
			for(EducationEntity edu : educationListObj ) {
				edu.setResume(resume);
				resumeService.addEducation(edu);
			}
		}
		if(experienceListObj!=null && !experienceListObj.isEmpty()) {
			for( ExperienceEntity experience  : experienceListObj) {
				experience.setResume(resume);
				resumeService.addExperience(experience);
			}
		}
		return null;
	}

}