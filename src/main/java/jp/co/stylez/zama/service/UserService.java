package jp.co.stylez.zama.service;

import org.springframework.stereotype.Service;

import jp.co.stylez.zama.dto.UserDto;

@Service
public class UserService {

	public String signupUser(UserDto userBean){
//		TestDto userBean = UserRepository.insertUser(userBean);
		return "through  UserService";
	}
}
