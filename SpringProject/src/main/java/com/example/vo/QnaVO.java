package com.example.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QnaVO {
	private int bno;
	private String writer;
	private String title;
	private String content;
	private String email;
	private String writeday;
	private int readnum;
	private int grp, lvl, step;
}
