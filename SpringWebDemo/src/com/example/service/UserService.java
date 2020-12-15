package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.vo.UserVO;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public void insert(UserVO userVO) {
		this.userDao.insertUser(userVO);
	}
}
