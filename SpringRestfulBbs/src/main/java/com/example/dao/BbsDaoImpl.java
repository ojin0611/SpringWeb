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
		// TODO Auto-generated method stub

	}

	@Override
	public void selectAll(Map map) {
		this.sqlSession.selectList("Bbs.selectAll", map);
	}

	@Override
	public void update(BbsVO bbsVo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int idx) {
		// TODO Auto-generated method stub

	}

}
