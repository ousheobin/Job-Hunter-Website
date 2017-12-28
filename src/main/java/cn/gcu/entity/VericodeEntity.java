package cn.gcu.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_vericode")
public class VericodeEntity extends IdEntity {

	private static final long serialVersionUID = -8297238923670788865L;

	@Column(name = "f_phone")
	private String phone;
	@Column(name = "f_code")
	private String code;
	@Column(name = "f_generate_time")
	private Date generateDate;
	@Column(name = "f_expire_time")
	private Date expireDate;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getGenerateDate() {
		return generateDate;
	}

	public void setGenerateDate(Date generateDate) {
		this.generateDate = generateDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

}
