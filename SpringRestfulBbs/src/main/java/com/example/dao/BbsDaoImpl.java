package com.example.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.vo.BbsVO;

@Repository("bbsDao")
public class BbsDaoImpl implements BbsDao {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insert(BbsVO bbsVo) {
		this.sqlSession.insert("Bbs.insert", bbsVo);
	}

	@Override
	public void select(Map map) {
		this.sqlSession.selectOne("Bbs.selectOne", map);
	}

	@Override
	public void selectAll(Map map) {
		this.sqlSession.selectList("Bbs.selectAll", map);
	}

	@Override
	public void update(BbsVO bbsVo) {
		this.sqlSession.update("Bbs.update", bbsVo);
	}

	@Override
	public void delete(int idx) {
		this.sqlSession.delete("Bbs.delete", idx);
	}

}
