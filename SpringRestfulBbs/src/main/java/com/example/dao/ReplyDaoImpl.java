package com.example.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.vo.ReplyVO;

@Repository("replyDao")
public class ReplyDaoImpl implements ReplyDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public void insert(ReplyVO replyVo) {
		this.sqlSession.insert("Reply.replyInsert", replyVo);
	}

	@Override
	public void select(Map map) {
		this.sqlSession.selectList("Reply.replySelectAll", map);
	}

}
