package com.example.service;

import java.util.Map;

import com.example.vo.BbsVO;

public interface BbsService {
	void create(BbsVO bbsVo);
	void read(Map map);
	void readAll(Map map);
	void update(BbsVO bbsVo);
	void delete(int idx);
}
