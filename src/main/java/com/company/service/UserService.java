package com.company.service;

import com.company.dto.User;
import com.company.mapper.UserMapper;
import com.company.tool.RegexpTool;
import com.company.tool.SessionConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    RegexpTool regexpTool;

    public boolean checkCanUseUserId(String userId){
        System.out.println("UserService ==> check same UserId " + userId);
        int userCount = userMapper.userCount(userId);
        System.out.println("userCount   : "  + userCount);
        if(userCount !=0) {
            return false;
        }
        return true;
    }

    public boolean checkCanUseUserInfo(User user) {
        if ( !regexpTool.idCheck(user.getId())||!regexpTool.passwordCheck(user.getPassword())||!checkCanUseUserId(user.getId())) {
            return false;
        }
        return true;
    }

    public boolean signInUser(User user){
        System.out.println("UserService ==> sign in user " + user);

        if (userMapper.signInUser(user) == 1 ) return true ; return false;
    }

    public boolean loginUser(User user, HttpServletRequest request, HttpServletResponse response) {
        if (userMapper.findUserInfo(user) == 0) return false;
        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_USER, user);
        return true;
    }

}
