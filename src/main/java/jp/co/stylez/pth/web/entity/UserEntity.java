package jp.co.stylez.pth.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;

	@Column(length = 50, nullable = false)
	private String Email;

	@Column(length = 50, nullable = false)
	private String Password;

	public UserEntity() {

	}

	public UserEntity(String email,String password) {
		this();
		this.Email = email;
		this.Password = password;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	

}
