package com.fastcampus.ch4.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fastcampus.ch4.dao.UserDao;
import com.fastcampus.ch4.domain.UserDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class LoginTest {
	@Autowired
	private UserDao userDao;
	
	@Test
	public void loginTest() throws Exception {
		userDao.deleteAll();
		assertTrue(userDao.count() == 0);
		
		System.out.println("userDao.count() = " + userDao.count());
		
		UserDto userDto1 = new UserDto("aaaa",
				"aaa",
				"aaa",
				"aaa@aaa.aaa",
				"aaa");
		
		System.out.println(userDto1.toString());
		
		userDao.insert(userDto1);
		
		String id = "aaaa";
		String pwd = "aaa";
		String wrongid = "bbbb";
		String wrongpwd = "bbb";
		
		assertTrue(loginCheck(id, pwd));
		assertTrue(!loginCheck(wrongid, pwd));
		assertTrue(!loginCheck(id, wrongpwd));
		assertTrue(!loginCheck(wrongid, wrongpwd));
		
		userDao.deleteAll();
		assertTrue(userDao.count() == 0);
	}
	
	private boolean loginCheck(String id, String pwd) {
		UserDto user;
		
		try {
			user = userDao.select(id);
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return user != null && user.getPwd().equals(pwd);
	}
}
