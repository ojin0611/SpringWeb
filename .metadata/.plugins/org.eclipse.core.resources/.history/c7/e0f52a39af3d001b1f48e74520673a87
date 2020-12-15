package com.example.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.config.RootConfig;
import com.example.dao.UserDao;
import com.example.vo.UserVO;

import lombok.extern.java.Log;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log
class ServiceTest {
	@Autowired
	private UserDao userDao;
	
	@Test
	void test() {
		assertNotNull(this.userDao);
		List<UserVO> list = this.userDao.selectAllUsers();
		list.forEach(user -> log.info(user.toString()));
	}

}
