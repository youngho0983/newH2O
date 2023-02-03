package com.company.controller;

import com.company.service.TestService;
import com.company.tool.EncryptTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;


    @Autowired
    EncryptTool encryptTool;


    @GetMapping("/test")
    @ResponseBody
    public String test(){
        System.out.println("testController");
        testService.test();

        return "main";
    }


    @GetMapping("/boardForUnity/{pageNum}")
    public String getBoard(@PathVariable int pageNum, Model model) {


        return "jsonView";
    }

    @GetMapping("/encryptKeyTest")
    public String encryptTest(Model model) {
        model.addAttribute("test",encryptTool.encrypt("hello"));

        return "jasonView";
    }
}
