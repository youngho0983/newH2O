package com.company.controller;

import com.company.dto.Post;
import com.company.service.TestService;
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

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        System.out.println("testController");
        testService.test();

        return "main";
    }


    @GetMapping("/boardForUnity/{pageNum}")
    public String getBoard(@PathVariable int pageNum, Model model) {

        List<Post> testList = new ArrayList<>();
        for(int i = 0; i < 10; i ++){
            testList.add(new Post("writer" + i, "title" + i, "poset" + i, "mainText" + i ,"editTime" + i));
        }
        model.addAttribute(testList);
        return "jsonView";
    }

}
