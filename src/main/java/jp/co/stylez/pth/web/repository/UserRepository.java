package jp.co.stylez.pth.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jp.co.stylez.pth.web.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer>{

//	@Query("INSERT INTO user(email,password) VALUES(:email,:password)")
//	UserEntity createUser(@Param("email")String email,@Param("password")String password);
}
