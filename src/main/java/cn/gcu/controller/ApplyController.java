package cn.gcu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.gcu.entity.ApplyEntity;
import cn.gcu.entity.JobsEntity;
import cn.gcu.entity.ResumeEntity;
//import cn.gcu.entity.ResumeEntity;
import cn.gcu.entity.UserEntity;
import cn.gcu.service.ApplyService;
import cn.gcu.service.JobService;
import cn.gcu.service.ResumeService;
import cn.gcu.service.UserService;

@Controller
public class ApplyController {
	
	@Resource
	ApplyService applyService;
	
	@Resource
	JobService jobService;
	
	@Resource
	ResumeService resumeService;
	
	@Resource
	UserService userService;
	
	@RequestMapping(value="mine.html")
	public String getMinePage(HttpServletRequest request) {
		return "user/mine";
	}
	
	@RequestMapping(value="apply.html")
	public String getApplyPage(String id,HttpServletRequest request) {
		UserEntity user = (UserEntity) request.getSession().getAttribute("userEntity");
		if(user!=null) {
			request.setAttribute("resumes", resumeService.getResumeByUser(user));
			request.setAttribute("job", jobService.getJobById(id));
		}
		return "user/apply";
	}
	
	@RequestMapping(value="user/apply_list")
	@ResponseBody
	public Map<String ,Object> getApplyList(HttpServletRequest request,HttpServletResponse response){
		Map<String ,Object> res = new HashMap<String ,Object>();
		UserEntity user = (UserEntity) request.getSession().getAttribute("userEntity");
		if(user!=null) {
			String userId = user.getId();
			List<ApplyEntity> aList = applyService.getApplyByUserId(userId);
			res.put("status", "ok");
			res.put("applyList", aList);
		}else {
			res.put("status", "error");
		}
		return res;
	}
	
	@RequestMapping(value="user/add_apply")
	@ResponseBody
	public Map<String,Object> addApply(String jobId,String resumeId,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> res = new HashMap<String,Object>();
		JobsEntity job = jobService.getJobById(jobId);
		UserEntity user = (UserEntity) request.getSession().getAttribute("userEntity");
		ResumeEntity resume = resumeService.getResumeById(resumeId);
		if(resume.getUser().getId().equals(user.getId())) {
			ApplyEntity apply = new ApplyEntity();
			apply.setJob(job);
			apply.setUser(user);
			apply.setApplyTime(new Date());
			apply.setResume(resume);
			applyService.addApply(apply);
			res.put("status", "ok");
		}else {
			res.put("status", "error");
		}
		return res;
	}
	
}