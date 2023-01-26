package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Post {
    String writer;
    String title;
    String mainText;

	String editTime;
}
