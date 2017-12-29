package cn.gcu.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
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

//import cn.gcu.entity.EnterpiseEntity;
import cn.gcu.entity.JobsEntity;
import cn.gcu.pojo.Page;
import cn.gcu.service.JobService;
import cn.gcu.utils.PageUtil;

@Controller
public class JobController {
	
	@Resource
	JobService jobService;
	
//	@Resource
//	EnterpiseService enterpiseService;
	
	@RequestMapping(value="search.html")
	public String searchResult(String page,String word,HttpServletRequest request,HttpServletResponse response) throws IOException {
		if(word==null || word.isEmpty()) {
			response.sendRedirect("discovery.html");
			return null;
		}else {
			int currentPage = 1;
			if(page!=null && !page.isEmpty()) {
				try {
					currentPage = Integer.valueOf(page);
				}catch(Exception e) {
					
				}
			}
			Page<JobsEntity> pageData = jobService.searchJob(currentPage, word);
			String pageNavi = PageUtil.generateBootstrapNav(pageData, "search.html?word="+URLEncoder.encode(word, "utf-8")+"&page=${pageNumber}");
			request.setAttribute("word", word);
			request.setAttribute("pageData", pageData);
			request.setAttribute("pageNavi", pageNavi);
		}
		return"public/search";
	}

	@RequestMapping(value="job-deatil-{id}.html")
	public String getDetailPage(@PathVariable(value="id")String detailId,HttpServletRequest request,HttpServletResponse response) {
		if(detailId!=null && !detailId.isEmpty()) {
			JobsEntity job = jobService.getJobById(detailId);
			request.setAttribute("jobDetail", job);
		}
		return "public/job-detail";
	}
	
//	@RequestMapping(value="delete_job")
//	public void deleteJob(HttpServletRequest request,HttpServletResponse response) {
//		String jobId = request.getParameter("jobId");
//		jobService.deleteJob(jobId);
//	}
	
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
