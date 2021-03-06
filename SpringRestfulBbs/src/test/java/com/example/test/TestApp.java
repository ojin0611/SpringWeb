package com.example.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.config.RootConfig;
import com.example.vo.BbsVO;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class})
@Slf4j
class TestApp {
	@Autowired
	private SqlSession sqlSession;

	@Disabled @Test
	void test() {
		assertNotNull(this.sqlSession);
		Date today = (Date)this.sqlSession.selectOne("Bbs.today");
		log.warn("오늘은 " + today);
	}
	
	@Disabled @Test
	void test1() {
		Map<String, Object> map = new HashMap<String, Object>();
		this.sqlSession.selectList("Bbs.selectAll", map);
		List<BbsVO> list = (List<BbsVO>)map.get("results");
		assertEquals(3, list.size());
		list.forEach(bbs -> log.info(bbs.toString()));
	}
	
	@Disabled @Test
	void test2() {
		BbsVO bbsVO = new BbsVO();
		//bbsVO.setWriter("한지민");
		//bbsVO.setTitle("제목 1");
		//bbsVO.setContents("내용 1");
//		bbsVO.setWriter("김지민");
//		bbsVO.setTitle("제목 2");
//		bbsVO.setContents("내용 2");
		bbsVO.setWriter("박지민");
		bbsVO.setTitle("제목 3");
		bbsVO.setContents("내용 3");
		this.sqlSession.insert("Bbs.insert", bbsVO);
	}
	
	@Disabled @Test
	void test3() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("idx", 21);
		this.sqlSession.selectOne("Bbs.selectOne", map);
		List<BbsVO> list = (List<BbsVO>)map.get("result");
		BbsVO bbsVO = list.get(0);
		log.warn(bbsVO.toString());
	}
	
	@Disabled @Test
	void test4() {
		this.sqlSession.delete("Bbs.delete", 1);
	}
	
	@Test
	void test5() {
		BbsVO bbsVO = new BbsVO();
		bbsVO.setIdx(81);
		bbsVO.setTitle("첫 글 제목 수정");
		bbsVO.setEmail("jimin@aaa.com");
		bbsVO.setContents("<p>첫 글 내용 수정</p>");
		this.sqlSession.update("Bbs.update", bbsVO);
	}

}
