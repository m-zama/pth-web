package jp.co.stylez.pth.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.stylez.pth.web.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer>{

}
