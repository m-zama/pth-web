package jp.co.stylez.pth.web.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import jp.co.stylez.pth.web.bean.UserBean;
import jp.co.stylez.pth.web.dao.UserDao;

@Component
public class UserDaoImpl implements UserDao{

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<UserBean> findAll() {
		// SQL
		String sql = "SELECT * FROM user";

		// SELECT
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
		List<UserBean> userList = new ArrayList<UserBean>();

		// Mapping
		for (Map<String, Object> result : resultList) {
			UserBean userBean = new UserBean();
			userBean.setId((int) result.get("id"));
			userBean.setUsername((String) result.get("email"));
			userBean.setPassword((String) result.get("password"));
			userList.add(userBean);
		}

		return userList;
	}

	public UserBean findUserByEmail(String email) {
		// SQL
		String sql = "SELECT * FROM user WHERE email = :email";

		// BindParameter
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("email", email);

		// SELECT
		Map<String, Object> result = namedParameterJdbcTemplate.queryForMap(sql, map);

		// Mapping
		UserBean userBean = new UserBean();
		userBean.setId((int) result.get("id"));
		userBean.setUsername((String) result.get("email"));
		userBean.setPassword((String) result.get("password"));
		return userBean;
	}

	public int insertUser(UserBean userBean) {
		//SQL
		String sql = "INSERT INTO user(email, password) VALUES(:email, :password)";

		// BindParameter
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("email", userBean.getUsername())
			.addValue("password", userBean.getPassword());
		
		//INSERT
		return namedParameterJdbcTemplate.update(sql, map);
	}
}
