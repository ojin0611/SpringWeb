package com.example.service;

import java.util.List;

import com.example.vo.BbsVO;

public interface BbsService {
	void create(BbsVO bbsVO);
	BbsVO read(int bno);
	List<BbsVO> readAll();
	void update(BbsVO bbsVO);
	void delete(int bno);
	void updateReadnum(int bno);
}
