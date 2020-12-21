package com.example.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserVO {
	private String userid;
	private String passwd;
	private String name;
	private int age;
	private String gender;
	private int flag;
	private BbsVO bbsVO;
}