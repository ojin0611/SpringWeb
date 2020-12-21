package com.example.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.vo.BbsVO;
import com.example.vo.UserVO;

@Repository("bbsDao")
public class BbsDaoImpl implements BbsDao {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertBoard(BbsVO bbsVO) {
		this.sqlSession.insert("Bbs.insertSP", bbsVO);
	}

	@Override
	public BbsVO selectBoard(int bno) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bno", bno);
		this.sqlSession.selectOne("Bbs.selectOneSP", map);
		List<BbsVO> list = (List<BbsVO>)map.get("result");
		return list.get(0);
	}

	@Override
	public List<BbsVO> selectAllBoard() {
		Map<String, Object> map = new HashMap<String, Object>();
		this.sqlSession.selectList("Bbs.selectAllSP", map);
		List<BbsVO> list = (List<BbsVO>)map.get("result");
		return list;
	}

	@Override
	public void updateBoard(BbsVO bbsVO) {
		this.sqlSession.update("Bbs.updateSP", bbsVO);
	}

	@Override
	public void deleteBoard(int bno) {
		this.sqlSession.delete("Bbs.delete", bno);
	}

	//조회수 증가
	@Override
	public void readnumUpdate(int bno) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bno", bno);
		this.sqlSession.update("Bbs.readnumUpdateSP", map);
	}

}
