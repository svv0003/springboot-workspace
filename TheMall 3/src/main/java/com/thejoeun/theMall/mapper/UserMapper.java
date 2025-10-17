package com.thejoeun.theMall.mapper;

import com.thejoeun.theMall.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> getAllUser();

    void insertUser(User user);
}
