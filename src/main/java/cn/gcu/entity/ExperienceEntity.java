package cn.gcu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "tb_experience")
public class ExperienceEntity extends IdEntity {

	private static final long serialVersionUID = 2531058764723678986L;

	@Column(name = "f_company_name")
	private String companyName;
	@Column(name = "f_begin_time")
	private String beginTime;
	@Column(name = "f_end_time")
	private String endTime;
	@Column(name = "f_industry")
	private String industry;
	@Column(name = "f_describe")
	@Type(type = "text")
	private String describe;
	@ManyToOne
	@JoinColumn(name = "f_resume")
	ResumeEntity resume;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public ResumeEntity getResume() {
		return resume;
	}

	public void setResume(ResumeEntity resume) {
		this.resume = resume;
	}

}
