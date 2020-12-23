package com.example.dao;

import java.util.Map;

import com.example.vo.BbsVO;

public interface BbsDao {
	void insert(BbsVO bbsVo);
	void select(Map map);
	void selectAll(Map map);
	void update(BbsVO bbsVo);
	void delete(int idx);
}
