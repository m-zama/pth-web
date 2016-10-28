package jp.co.stylez.pth.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.stylez.pth.web.dto.UserDto;
import jp.co.stylez.pth.web.mapper.UserMapper;
import jp.co.stylez.pth.web.service.UserService;



@Service("UserServiceImpl")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	    public void registerUser(UserDto userBean){
	      userMapper.insert(userBean);
	    }
	    
	    public List<UserDto> findUserAll(){
	    		List<UserDto> list = userMapper.selectAll();
	    		return list;
	    }
}
