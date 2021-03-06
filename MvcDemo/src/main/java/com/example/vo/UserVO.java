package com.example.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter // confirm2.jsp 의 ul부분에서 꺼내오기위해!
@Setter
@ToString
public class UserVO {
	private String userid;
	private String passwd;
	private String name;
	private int age;
	private String gender;
	private String[] hobby;
}