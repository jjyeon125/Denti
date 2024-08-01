package com.example.demo.login.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Users;
import com.example.demo.login.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final LoginRepository loginRepository;

    @Autowired
    public UserServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public void register(UserDTO userDTO) throws Exception {
        if (loginRepository.existsByUserId(userDTO.getUserId())) {
            throw new Exception("이미 존재하는 아이디입니다.");
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date birthDate;
        try {
            birthDate = dateFormat.parse(userDTO.getUserBirth());
        } catch (ParseException e) {
            throw new Exception("Invalid birth date format", e);
        }

        Users user = Users.builder()
                .userId(userDTO.getUserId())
                .userPwd(userDTO.getUserPwd())
                .userName(userDTO.getUserName())
                .userBirth(birthDate)
                .userPhone(userDTO.getUserPhone())
                .userGender(userDTO.getUserGender())
                .build();

        loginRepository.save(user);
    }

    @Override
    public Users login(UserDTO userDTO) {
        Optional<Users> user = loginRepository.findByUserIdAndUserPwd(userDTO.getUserId(), userDTO.getUserPwd());
        return user.orElse(null);
    }

    @Override
    public Object getAllUsers() {
        return loginRepository.findAll();
    }
}