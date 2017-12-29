package cn.gcu.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "tb_resume")
public class ResumeEntity extends IdEntity {

	private static final long serialVersionUID = 8478299340448179161L;

	@Column(name = "f_name")
	private String name;
	@Column(name = "f_gender")
	private String gender;
	@Column(name = "f_phone")
	private String phone;
	@Column(name = "f_apply_work")
	private String applyWork;
	@Column(name = "f_birthday")
	private String birthday;
	@Column(name = "f_time_to_work")
	private String timeToWork;
	@Column(name = "f_email")
	private String email;
	@Column(name = "f_residence")
	private String residence; // 现居住地址
	@Column(name = "f_orign_residence")
	private String orginResidence; // 户口地址
	@OneToMany
	@JoinColumn(name = "f_resume")
	private List<EducationEntity> educationDeatil;
	@OneToMany
	@JoinColumn(name = "f_resume")
	private List<ExperienceEntity> experienceDetail;
	@Column(name = "f_evaluate")
	@Type(type = "text")
	private String evaluate;
	@Column(name = "f_project_experience")
	@Type(type = "text")
	private String projectExperience;
	@ManyToOne
	@JoinColumn(name = "f_user")
	private UserEntity user;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getApplyWork() {
		return applyWork;
	}

	public void setApplyWork(String applyWork) {
		this.applyWork = applyWork;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getTimeToWork() {
		return timeToWork;
	}

	public void setTimeToWork(String timeToWork) {
		this.timeToWork = timeToWork;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}

	public String getOrginResidence() {
		return orginResidence;
	}

	public void setOrginResidence(String orginResidence) {
		this.orginResidence = orginResidence;
	}

	public List<EducationEntity> getEducationDeatil() {
		return educationDeatil;
	}

	public void setEducationDeatil(List<EducationEntity> educationDeatil) {
		this.educationDeatil = educationDeatil;
	}

	public List<ExperienceEntity> getExperienceDetail() {
		return experienceDetail;
	}

	public void setExperienceDetail(List<ExperienceEntity> experienceDetail) {
		this.experienceDetail = experienceDetail;
	}

	public String getEvaluate() {
		return evaluate;
	}

	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}

	public String getProjectExperience() {
		return projectExperience;
	}

	public void setProjectExperience(String projectExperience) {
		this.projectExperience = projectExperience;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

}
