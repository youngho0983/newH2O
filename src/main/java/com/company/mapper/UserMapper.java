package com.company.mapper;

import com.company.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserMapper {

    public int userCount(String UserId);
    public int signInUser(User user);
    public User findUserInfo(Map user);
}
