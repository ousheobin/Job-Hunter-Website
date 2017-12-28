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
//import cn.gcu.entity.ResumeEntity;
import cn.gcu.entity.UserEntity;
import cn.gcu.service.ApplyService;
import cn.gcu.service.JobService;
import cn.gcu.service.UserService;

@Controller
public class ApplyController {
	
	@Resource
	ApplyService applyService;
	
	@Resource
	JobService jobService;
	
//	@Resource
//	ResumeService resumeService;
	
	@Resource
	UserService userService;
	
	@RequestMapping(value="apply_list")
	@ResponseBody
	public Map<String ,Object> getApplyList(HttpServletRequest request,HttpServletResponse response){
		String userId = request.getParameter("userId");
		List<ApplyEntity> aList = applyService.getApplyByUserId(userId);
		String listString = String.valueOf(aList);
		Map<String ,Object> res = new HashMap<String ,Object>();
		res.put("applyList", listString);
		return res;
	}
	
	@RequestMapping(value="delete_apply")
	public void delteApply(HttpServletRequest request,HttpServletResponse response) {
		String applyId = request.getParameter("applyId");
		applyService.deleteApply(applyId);
	}
	
	@RequestMapping(value="add_apply")
	public void addApply(HttpServletRequest request,HttpServletResponse response) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date applyTime = dateFormat.parse((String)request.getParameter("applyTime"));
		boolean isOffer = Boolean.parseBoolean((String)request.getParameter("isOffer"));
		String jobId = request.getParameter("jobId");
		JobsEntity job = jobService.getJobById(jobId);
//		String resumeId = request.getParameter("resumeId");
//		ResumeEntity resume = resumeService.getResumeById(resumeId)
		String userId = request.getParameter("userId");
		UserEntity user = userService.getUserById(userId);
		ApplyEntity apply = new ApplyEntity();
//		apply.setApplyTime(applyTime);
		apply.setJob(job);
		apply.setOffer(isOffer);
//		apply.setResume(resume);
		apply.setUser(user);
		applyService.addApply(apply);
	}
	
}
