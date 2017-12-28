package cn.gcu.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;


@MappedSuperclass
public class IdEntity implements Serializable {

	@Id
	@GeneratedValue(generator = "tableGenerator")
	@GenericGenerator(name = "tableGenerator", strategy = "uuid")
	@Column(name = "f_id", nullable = false, length = 32, unique = true)
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}