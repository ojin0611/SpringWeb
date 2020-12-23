package com.example.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.service.QnaService;

import lombok.extern.java.Log;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log
class QnaTest {
	@Autowired
	private QnaService qnaService;
	//private SqlSession sqlSession;

	@Test
	void test() {
		int totalPage = this.qnaService.getTotalPage(5);
		log.info("전체페이지 수 = " + totalPage);
	}

}
