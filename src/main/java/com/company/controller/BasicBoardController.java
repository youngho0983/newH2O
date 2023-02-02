package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/basic_board")
public class BasicBoardController {

    @GetMapping
    public String basicBoard() {
        System.out.println("basicBoard");
        return "/basicBoard/basicBoard";
    }



    @GetMapping("/pageView")
    public String getPageCount(int pageNum,Model model){

        return "jsonView";
    }

}
