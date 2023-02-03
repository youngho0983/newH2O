package com.company.mapper;

import com.company.dto.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BasicBoardMapper {
    List<Board> selectBoardList(int pageNum);
    int test();
    int insertBoard(Board board);
}
