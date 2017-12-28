package cn.gcu.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//import cn.gcu.entity.EnterpiseEntity;
import cn.gcu.entity.JobsEntity;
import cn.gcu.service.JobService;

@Controller
public class JobController {
	
	@Resource
	JobService jobService;
	
//	@Resource
//	EnterpiseService enterpiseService;
	
	@RequestMapping(value="job_list")
	@ResponseBody
	public Map<String ,Object> getJobList(HttpServletRequest request,HttpServletResponse response){
		List<JobsEntity> jList = jobService.getAllJob();
		String listString = String.valueOf(jList);
		Map<String ,Object> res = new HashMap<String ,Object>();
		res.put("jobList", listString);
		return res;
	}
	
	@RequestMapping(value="delete_job")
	public void deleteJob(HttpServletRequest request,HttpServletResponse response) {
		String jobId = request.getParameter("jobId");
		jobService.deleteJob(jobId);
	}
	
	@RequestMapping(value="add_job")
	public void addJob(HttpServletRequest request,HttpServletResponse response) {
		String describe = request.getParameter("describe");
//		String enterpiseId = request.getParameter("enterpiseId");
//		EnterpiseEntity enterpise = enterpiseService.get(enterpiseId);
		int highSal = Integer.parseInt((String)request.getParameter("highSal"));
		int lowSal = Integer.parseInt((String)request.getParameter("lowSal"));
		String jobName = request.getParameter("jobName");
		String place = request.getParameter("place");
//		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date date = dateFormat.parse((String)request.getParameter("date"));
		String require = request.getParameter("require");
		JobsEntity job = new JobsEntity();
		job.setDescribe(describe);
//		job.setEnterpise(enterpise);
		job.setHighSal(highSal);
		job.setLowSal(lowSal);
		job.setJobName(jobName);
		job.setPlace(place);
//		job.setPublishDate(publishDate);
		job.setRequire(require);
		jobService.addJob(job);
	}
}
