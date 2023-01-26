package com.company.tool;

import com.company.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SecurityTool {
    public static enum SecuEnum{
        LOGIN_SECURE
    };

    public User removeNotNeedInfo(User user, SecuEnum useage){
        switch (useage) {
            case LOGIN_SECURE:
                user.setPassword("");
                user.setAddress("");
                user.setEmail("");
                user.setName("");
                user.setAge(0);
                user.setPhonenumber("");
            break;
        }
        return user;
    }
}
