package cn.gcu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_enterpise_user")
public class EnterpiseEntity extends IdEntity {

	private static final long serialVersionUID = -2598917815214693725L;

	@Column(name = "f_enterpise_name")
	public String enterpiseName;
	@Column(name = "f_user_name")
	public String userName;
	@Column(name = "f_password")
	public String password;

	public String getEnterpiseName() {
		return enterpiseName;
	}

	public void setEnterpiseName(String enterpiseName) {
		this.enterpiseName = enterpiseName;
	}

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

}
