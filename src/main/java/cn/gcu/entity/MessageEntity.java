package cn.gcu.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "tb_message")
public class MessageEntity extends IdEntity {

	private static final long serialVersionUID = -1131592900013216385L;
	
	@Column(name = "f_message")
	@Type(type = "text")
	private String message;
	@Column(name = "f_publish_date")
	private Date date;
	@ManyToOne
	@JoinColumn(name = "f_user")
	private UserEntity user;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

}
