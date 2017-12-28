package cn.gcu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_user")
public class UserEntity extends IdEntity {

	private static final long serialVersionUID = 1805089209447150694L;
	
	@Column(name = "f_user_name")
	private String userName;
	@Column(name = "f_password")
	private String password;
	@Column(name = "f_mobile")
	private String mobilePhone;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

}
