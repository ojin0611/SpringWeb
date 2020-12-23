package com.example.dao;

import java.util.List;

import com.example.vo.MemberVO;

public interface MemberDao {
	void create(MemberVO member);
	List<MemberVO> readAll();
	MemberVO read(String userid);
	void update(MemberVO member);
	void delete(String userid);
}
