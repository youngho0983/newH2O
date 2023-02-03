package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Board {
    int boardnum;
    String writer;
    String content;
    int parentNum;
	String editTime;
    String regTime;
    String title;

}
