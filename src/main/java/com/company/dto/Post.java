package com.company.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Post {
    String writer;
    String title;
    String post;
    String mainTest;
    String editTime;
}
