package com.company.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private String id;
    private String password;
    private String name;

	private String address;
    private String phonenumber;
    private String email;
    private int age;
	
}
