package com.company.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/basic_board")
public class BasicBoard {

    @GetMapping
    public String basicBoard() {
        System.out.println("basicBoard");
        return "board/basicBoard";
    }



    @GetMapping("/pageCounter")
    public String getPageCount(int currentPage){
        System.out.println("ajax 페이지 카운트");
        System.out.println("현재 원하는 페이지");
        return "jasonView";
    }
}
