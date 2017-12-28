package cn.gcu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_education")
public class EducationEntity extends IdEntity {

	private static final long serialVersionUID = 4496017150471787523L;

	@Column(name = "f_school_time")
	private String schoolName;
	@Column(name = "f_enrollment_time")
	private String enrollmentTime;
	@Column(name = "f_graduate_time")
	private String graduateTime;
	@Column(name = "f_major")
	private String major;
	@Column(name = "f_degree")
	private String degree;
	@ManyToOne
	@JoinColumn(name = "f_resume")
	ResumeEntity resume;

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getEnrollmentTime() {
		return enrollmentTime;
	}

	public void setEnrollmentTime(String enrollmentTime) {
		this.enrollmentTime = enrollmentTime;
	}

	public String getGraduateTime() {
		return graduateTime;
	}

	public void setGraduateTime(String graduateTime) {
		this.graduateTime = graduateTime;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public ResumeEntity getResume() {
		return resume;
	}

	public void setResume(ResumeEntity resume) {
		this.resume = resume;
	}

}
