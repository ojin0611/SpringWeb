package com.example.service;

import java.util.List;

import com.example.vo.BbsVO;
import com.example.vo.QnaVO;

public interface QnaService {
	void create(QnaVO qnaVO);
	QnaVO read(int bno);
	List<QnaVO> readAll();
	void update(QnaVO qnaVO);
	void delete(int bno);
	void updateReadnum(int bno);
	void reply(QnaVO qnaVO);
	int getTotalPage(int pageSize);
}
