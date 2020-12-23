package com.example.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.vo.MemberVO;

import lombok.extern.log4j.Log4j;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
class MemberTest {
	@Autowired
	//private MemberService memberService;
	//private MemberDao memberDao;
	private SqlSession sqlSession;
	
	@Test
	void test() {
		assertNotNull(this.sqlSession);
		//List<MemberVO> list = this.memberService.select();
		//List<MemberVO> list = this.memberDao.readAll();
		//List<MemberVO> list = this.sqlSession.selectList("Members.select");
		//list.forEach(member -> log.info(member.toString()));
	}

}
