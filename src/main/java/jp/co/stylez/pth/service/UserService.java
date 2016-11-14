package jp.co.stylez.pth.service;

import java.util.List;

import jp.co.stylez.pth.web.entity.UserEntity;

public interface UserService {

	public List<UserEntity> findAll();
	public UserEntity createUser(UserEntity userEntity);
}
