package jp.co.stylez.pth.web.dao;

import java.util.List;

import jp.co.stylez.pth.web.bean.UserBean;

public interface UserDao {

	public List<UserBean> findAll();
	public UserBean findUserByEmail(String email);
	public int insertUser(UserBean userBean);
}
