package com.company.controller;

import com.company.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/test")
    public String test(){
        System.out.println("testController");
        testService.test();

        return "main";
    }
}
