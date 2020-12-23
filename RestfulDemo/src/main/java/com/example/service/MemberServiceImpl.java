package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.MemberDao;
import com.example.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public void insertMember(MemberVO member) {
		this.memberDao.create(member);
	}

	@Override
	public List<MemberVO> select() {
		return this.memberDao.readAll();
	}

	@Override
	public MemberVO selectMember(String userid) {
		return this.memberDao.read(userid);
	}

	@Override
	public void updateMember(MemberVO member) {
		this.memberDao.update(member);
	}

	@Override
	public void deleteMember(String userid) {
		this.memberDao.delete(userid);
	}

}
