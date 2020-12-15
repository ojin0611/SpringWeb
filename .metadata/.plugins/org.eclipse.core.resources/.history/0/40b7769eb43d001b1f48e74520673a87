package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.vo.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public void create(UserVO userVO) {
		this.userDao.insertUser(userVO);
	}

	@Override
	public UserVO read(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserVO> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(UserVO userVO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String userid) {
		// TODO Auto-generated method stub

	}

}
