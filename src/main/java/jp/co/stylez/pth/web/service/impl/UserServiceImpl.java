package jp.co.stylez.pth.web.service.impl;

import org.springframework.stereotype.Service;

import jp.co.stylez.pth.web.dto.UserDto;
import jp.co.stylez.pth.web.service.UserService;



@Service("UserServiceImpl")
public class UserServiceImpl implements UserService{

	    public String signupUser(UserDto userBean){
//	      TestDto userBean = UserRepository.insertUser(userBean);
	        return "through  UserService";
	    }
}
