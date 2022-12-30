package com.company.mapper;

import com.company.dto.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    public int userCount(String UserId);
    public int signInUser(User user);
    public int findUserInfo(User user);
}
