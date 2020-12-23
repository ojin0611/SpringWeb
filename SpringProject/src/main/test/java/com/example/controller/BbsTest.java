package com.example.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.dao.BbsDao;
import com.example.vo.BbsVO;

import lombok.extern.java.Log;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log
class BbsTest {
	@Autowired
	private SqlSession sqlSession;

	@Autowired
	private BbsDao bbsDao;
	
	@Test
	void test() {
		BbsVO bbsVO = new BbsVO();
		bbsVO.setBno(1);
		bbsVO.setTitle("제목1");
		bbsVO.setContent("내용1");
		bbsVO.setEmail("aaa@aaa.com");
		this.bbsDao.updateBoard(bbsVO);
	}

}
