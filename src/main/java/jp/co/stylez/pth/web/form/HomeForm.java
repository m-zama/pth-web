package jp.co.stylez.pth.web.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import jp.co.stylez.pth.web.dto.UserDto;

public class HomeForm {

	@NotBlank(message="未入力です")
	@Email(message="メール形式で入力してください")
	private String email;
	
	@NotBlank(message="未入力です")
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public UserDto createUserDto(){
		return new UserDto(this.email,this.password);
	}
}
