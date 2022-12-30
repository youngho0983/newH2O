package com.company.service;

import com.company.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public boolean checkCanUseUserId(String userId){
        System.out.println("UserService ==> check same UserId " + userId);
        System.out.println("userCount   : "  + userMapper.userCount(userId));
        if(userMapper.userCount(userId) !=0) {
            return false;
        }
        return true;
    }
}
