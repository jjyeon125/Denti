package com.example.demo.login.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Users;

public interface UserService {
    Users login(UserDTO userDTO);
    void register(UserDTO userDTO) throws Exception;
    Object getAllUsers();
}