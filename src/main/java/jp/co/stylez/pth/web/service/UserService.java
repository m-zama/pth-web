package jp.co.stylez.pth.web.service;

import java.util.List;

import jp.co.stylez.pth.web.dto.UserDto;

public interface UserService {

	public void registerUser(UserDto userBean);
	public List<UserDto> findUserAll();
}
