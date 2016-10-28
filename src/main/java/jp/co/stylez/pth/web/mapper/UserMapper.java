package jp.co.stylez.pth.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import jp.co.stylez.pth.web.dto.UserDto;

public interface UserMapper {

	@Select("SELECT * FROM user")
	List<UserDto> selectAll();
	@Insert("INSERT INTO user (email,password) VALUES(#{email},#{password})")
	void insert(UserDto form);
}	
