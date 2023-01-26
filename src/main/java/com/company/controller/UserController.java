package com.company.controller;

import com.company.dto.User;
import com.company.service.UserService;
import com.company.tool.RegexpTool;
import com.company.tool.SessionConst;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
        request.getSession().invalidate();

        return"/user/login";
    }

    @PostMapping("/login")
    public String loginSuccess(HttpServletRequest request){

        return "/main";
    }

    @PostMapping("/login-try")
    public String loginTry(HttpServletRequest request,ModelMap model, @RequestBody Map user) {
        if (userService.loginUser(user, request)) {
            model.addAttribute("login", "success");
        }
        return "jsonView";
    }

    @GetMapping("/logout")
    public String logOut(HttpSession session){
        session.invalidate();
        return "/main";
    }

    @GetMapping("/test")
    public String tests(HttpServletRequest request) {
        HttpSession session = request.getSession();

        System.out.println(session.getAttribute(SessionConst.LOGIN_USER));
        return "jsonView";
    }

}
