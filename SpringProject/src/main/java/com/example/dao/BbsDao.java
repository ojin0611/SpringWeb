package com.example.dao;

import java.util.List;

import com.example.vo.BbsVO;

public interface BbsDao {
	void insertBoard(BbsVO bbsVO);
	BbsVO selectBoard(int bno);
	List<BbsVO> selectAllBoard();
	void updateBoard(BbsVO bbsVO);
	void deleteBoard(int bno);
	void readnumUpdate(int bno);
}
