package jp.co.stylez.pth.web.bean;


public class UserBean {

	private int Id;

	private String Email;
	
	private String Password;

	public UserBean() {

	}

	public UserBean(String email,String password) {
		this();
		this.Email = email;
		this.Password = password;
	}

	public long getId() {
		return Id;
	}

	public void setId(int id) {
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
