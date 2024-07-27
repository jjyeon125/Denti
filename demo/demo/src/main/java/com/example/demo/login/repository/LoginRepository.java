package com.example.demo.login.repository;

import com.example.demo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface LoginRepository extends JpaRepository<Users, Integer> {

    Optional<Object> findByUserId(String userId);


    Optional<Users> findByUserIdAndUserPwd(String userId, String userPwd);
    boolean existsByUserId(String userId);

}
