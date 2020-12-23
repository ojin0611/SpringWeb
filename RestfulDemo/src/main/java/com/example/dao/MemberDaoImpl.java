package com.example.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.vo.MemberVO;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void create(MemberVO member) {
		this.sqlSession.insert("Members.insert", member);
	}

	@Override
	public List<MemberVO> readAll() {
		return this.sqlSession.selectList("Members.select");
	}

	@Override
	public MemberVO read(String userid) {
		return this.sqlSession.selectOne("Members.selectMember", userid);
	}

	@Override
	public void update(MemberVO member) {
		this.sqlSession.update("Members.update", member);
	}

	@Override
	public void delete(String userid) {
		this.sqlSession.delete("Members.delete", userid);
	}

}
