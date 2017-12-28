package cn.gcu.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "tb_jobs")
public class JobsEntity extends IdEntity {

	private static final long serialVersionUID = 4543196423309321634L;

	@Column(name = "f_job_name")
	private String jobName;
	@Column(name = "f_low_sal")
	private int lowSal;
	@Column(name = "f_high_sal")
	private int highSal;
	@Column(name = "f_describe")
	@Type(type = "text")
	private String describe;
	@Column(name = "f_require")
	@Type(type = "text")
	private String require;
	@Column(name = "f_place")
	@Type(type = "text")
	private String place;
	@ManyToOne
	@JoinColumn(name = "f_enterpise")
	private EnterpiseEntity enterpise;
	@Column(name = "f_publish_date")
	private Date publishDate;
	@Column(name = "f_is_delete")
	private boolean isDelete;

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public int getLowSal() {
		return lowSal;
	}

	public void setLowSal(int lowSal) {
		this.lowSal = lowSal;
	}

	public int getHighSal() {
		return highSal;
	}

	public void setHighSal(int highSal) {
		this.highSal = highSal;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getRequire() {
		return require;
	}

	public void setRequire(String require) {
		this.require = require;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public EnterpiseEntity getEnterpise() {
		return enterpise;
	}

	public void setEnterpise(EnterpiseEntity enterpise) {
		this.enterpise = enterpise;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

}
