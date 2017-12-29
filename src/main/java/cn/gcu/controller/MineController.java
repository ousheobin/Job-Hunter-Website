package cn.gcu.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping(value="resume-edit-{id}.html")
	public String getResumePage(@PathVariable(value="id")String id,HttpServletRequest request,HttpServletResponse response) throws IOException {
		ResumeEntity resume = resumeService.getResumeById(id);
		UserEntity user = (UserEntity) request.getSession().getAttribute("userEntity");
		if(user==null) {
			response.sendRedirect("login.html");
		}else {
			if(resume!=null && resume.getUser()!=null) {
				if(resume.getUser().getId().equals(user.getId())) {
					request.setAttribute("resume", resume);
				}else {
					response.sendRedirect("add-resume.html");
				}
			}else {
				response.sendRedirect("add-resume.html");
			}
		}
		return "user/edit-resume";
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
	@ResponseBody
	public Map<String,Object> doAddResume(String name,String gender,String phone,String email,String applyWork,
			String birthday,String timeToWork,String residence,String originResidence, String educationList, String experienceList, 
			String evaluate, String projectExperience,HttpServletRequest request) throws IOException{
		Map<String,Object> res = new HashMap<String,Object>();
		ObjectMapper objm = new ObjectMapper();
		List<EducationEntity> educationListObj = objm.readValue(educationList,new TypeReference<List<EducationEntity>>(){});
		List<ExperienceEntity> experienceListObj = objm.readValue(experienceList,new TypeReference<List<ExperienceEntity>>(){});
		UserEntity user = (UserEntity) request.getSession().getAttribute("userEntity");
		ResumeEntity resume = new ResumeEntity();
		resume.setApplyWork(applyWork);
		resume.setBirthday(birthday);
		resume.setEmail(email);
		resume.setEvaluate(evaluate);
		resume.setGender(gender);
		resume.setName(name);
		resume.setOriginResidence(originResidence);
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
		res.put("status", "ok");
		return res;
	}
	
	@RequestMapping(value="user/update_resume")
	@ResponseBody
	public Map<String,Object> doUpdateResume(String id,String name,String gender,String phone,String email,String applyWork,
			String birthday,String timeToWork,String residence,String originResidence, String educationList, String experienceList, 
			String evaluate, String projectExperience,HttpServletRequest request) throws IOException{
		Map<String,Object> res = new HashMap<String,Object>();
		ObjectMapper objm = new ObjectMapper();
		List<EducationEntity> educationListObj = objm.readValue(educationList,new TypeReference<List<EducationEntity>>(){});
		List<ExperienceEntity> experienceListObj = objm.readValue(experienceList,new TypeReference<List<ExperienceEntity>>(){});
		UserEntity user = (UserEntity) request.getSession().getAttribute("userEntity");
		if(user!=null && id!=null && !id.isEmpty()) {
			ResumeEntity resume = resumeService.getResumeById(id);
			if(resume!=null) {
				if(!resume.getEducationDeatil().isEmpty()) {
					for(EducationEntity edu : resume.getEducationDeatil() ) {
						resumeService.deleteEducation(edu);
					}
					resume.getEducationDeatil().clear();
				}
				if(!resume.getExperienceDetail().isEmpty()) {
					for( ExperienceEntity experience  : resume.getExperienceDetail()) {
						resumeService.deleteExperience(experience);
					}
					resume.getExperienceDetail().clear();
				}
				resume.setApplyWork(applyWork);
				resume.setBirthday(birthday);
				resume.setEmail(email);
				resume.setEvaluate(evaluate);
				resume.setGender(gender);
				resume.setName(name);
				resume.setOriginResidence(originResidence);
				resume.setPhone(phone);
				resume.setProjectExperience(projectExperience);
				resume.setResidence(residence);
				resume.setTimeToWork(timeToWork);
				resume.setUser(user);
				resumeService.updateResume(resume);
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
				res.put("status", "ok");
			}else {
				res.put("status", "error");
			}
		}else {
			res.put("status", "error");
		}
		return res;
	}

}