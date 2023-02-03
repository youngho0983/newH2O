package com.company.service;

import com.company.dto.Board;
import com.company.mapper.BasicBoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicBoardService {

    @Autowired
    BasicBoardMapper basicBoardMapper;

    public boolean addBoard(Board board) {
        basicBoardMapper.insertBoard(board);

        return false;
    }

    public List<Board> getBoardList(int pageNum) {
        return  basicBoardMapper.selectBoardList(1);
    }
}
