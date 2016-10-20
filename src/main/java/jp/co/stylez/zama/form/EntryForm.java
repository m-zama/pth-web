package jp.co.stylez.zama.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import jp.co.stylez.zama.dto.UserDto;

public class EntryForm {

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
	
	public UserDto createTestDto(){
		return new UserDto(this.email,this.password);
	}
}
