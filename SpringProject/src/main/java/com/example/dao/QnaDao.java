package com.example.dao;

import java.util.List;

import com.example.vo.BbsVO;
import com.example.vo.QnaVO;

public interface QnaDao {
	void insertQna(QnaVO qnaVO);
	QnaVO selectQna(int bno);
	List<QnaVO> selectAllQna();
	void updateQna(QnaVO qnaVO);
	void deleteQna(int bno);
	void readnumUpdate(int bno);
	void replyQna(QnaVO qnaVO);
	int getTotalCount();
}
