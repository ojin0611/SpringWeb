package com.example.service;

import java.util.Map;

import com.example.vo.ReplyVO;

public interface ReplyService {
	void select(Map map);
	void create(ReplyVO replyVo);
}
