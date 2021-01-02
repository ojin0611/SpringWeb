package com.example.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BbsVO {
	private int idx;
	private String writer, title, contents, email;
	private int readnum;
	private Date writeday;
	private ReplyVO replyVO;
}
