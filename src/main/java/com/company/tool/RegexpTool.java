package com.company.tool;

import org.springframework.stereotype.Component;

@Component
public class RegexpTool {


    String idPattern = "^[a-z]+[a-z0-9]{6,20}$";
    String passwordPattern = "^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\\\(\\\\)\\-_=+]).{8,20}$";
    public boolean passwordCheck(String password) {
        return password.matches(passwordPattern);
    }

    public boolean idCheck(String id) {
        return id.matches(idPattern);
    }


}
