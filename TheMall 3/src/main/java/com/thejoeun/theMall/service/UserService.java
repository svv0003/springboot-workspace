package com.thejoeun.theMall.service;

import com.thejoeun.theMall.mapper.UserMapper;
import com.thejoeun.theMall.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    public UserMapper userMapper;

    public  List<User> getAllUser() {
        return userMapper.getAllUser();
    }
}
