package com.example.dao;

import java.util.Map;

import com.example.vo.ReplyVO;

public interface ReplyDao {
	void insert(ReplyVO replyVo);
	void select(Map map);
}
