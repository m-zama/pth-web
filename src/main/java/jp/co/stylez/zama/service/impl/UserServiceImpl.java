package jp.co.stylez.zama.service.impl;

import org.springframework.stereotype.Service;

import jp.co.stylez.zama.dto.UserDto;
import jp.co.stylez.zama.service.UserService;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService{

	public String signupUser(UserDto userBean){
//		TestDto userBean = UserRepository.insertUser(userBean);
		return "through  UserService";
	}
}
