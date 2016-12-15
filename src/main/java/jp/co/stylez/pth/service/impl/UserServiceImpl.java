package jp.co.stylez.pth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.stylez.pth.service.UserService;
import jp.co.stylez.pth.web.entity.UserEntity;
import jp.co.stylez.pth.web.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Transactional(readOnly = true)
	public List<UserEntity> findAll(){
		return userRepository.findAll();
	}
	
	@Transactional
	public UserEntity createUser(UserEntity userEntity){
		return userRepository.save(userEntity);
	}
}
