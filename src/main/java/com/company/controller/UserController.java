package com.company.controller;

import com.company.dto.User;
import com.company.service.UserService;
import com.company.tool.RegexpTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/signin")
    public String signIn() {
        System.out.println("get Into Sign-in page");

        return "/user/signIn";
    }


    @PostMapping("/sign-in")
    public String makeUser(User user) {
        System.out.println(user);

        if(  !userService.checkCanUseUserInfo(user)) return "/user/signIn";

        userService.signInUser(user);
        return "redirect:/";
    }

    @GetMapping("/{userId}")
    public String checkUserId(@PathVariable String userId, ModelMap model){
        System.out.println("check UserId : " + userId);
        model.addAttribute("userId", userId);
        model.addAttribute("canUseId", userService.checkCanUseUserId(userId));
        return "jsonView";
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request){
        request.getSession().invalidate();;
        return"/user/login";
    }
    @PostMapping("/login")
    public String login(User user, HttpServletRequest request, HttpServletResponse response) {
        if (!userService.loginUser(user, request, response)) {

        }
        return "/main";
    }

}
