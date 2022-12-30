package com.company.controller;

import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/sign-in")
    public String signIn() {
        System.out.println("get Into Sign-in page");

        return "/user/signIn";
    }

    @GetMapping("/{userId}")
    public String checkUserId(@PathVariable String userId, ModelMap model){
        System.out.println("check UserId : " + userId);
        model.addAttribute("userId",userId);
        model.addAttribute("canUseId",userService.checkCanUseUserId(userId));
        return "jsonView";
    }


}
