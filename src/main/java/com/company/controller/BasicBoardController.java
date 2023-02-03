package com.company.controller;

import com.company.dto.Board;
import com.company.service.BasicBoardService;
import com.company.tool.SessionConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/basic_board")
public class BasicBoardController {

    @Autowired
    BasicBoardService basicBoardService;

    @GetMapping
    public String basicBoard() {
        System.out.println("basicBoard");

        return "/basicBoard/basicBoard";
    }

    @GetMapping("write_page")
    public String writePage(HttpSession session){
        if(session.getAttribute(SessionConst.LOGIN_USER) == null) return "/";
        return "/writePage";
    }

    @GetMapping("/{pageNum}")
    public String getBoard(@PathVariable int pageNum, Model model) {
        System.out.println("getBoardList");
        List<Board> boardList = basicBoardService.getBoardList(pageNum);
        model.addAttribute("boardList",boardList);
        return "/basicBoard/boardList";

    }
    @GetMapping("/page/{pageNum}")
    public String getPage(int pageNum,Model model){

        return "/basicBoard/page";
    }

}
