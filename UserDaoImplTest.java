package com.fastcampus.ch4.dao;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fastcampus.ch4.domain.UserDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class UserDaoImplTest {
	
	@Autowired
	private UserDao userDao;
	
	@Test
	public void countTest() throws Exception{
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
		assertTrue(userDao.count() == 1);
		
		System.out.println(userDao.count());
		
		UserDto userDto2 = new UserDto("bbbb",
				"bbb",
				"bbb",
				"bbb@bbb.bbb",
				"bbb");
		
		userDao.insert(userDto2);
		assertTrue(userDao.count() == 2);
	}
	
	@Test
	public void selectTest() throws Exception {
		userDao.deleteAll();
		assertTrue(userDao.count() == 0);
		
		UserDto userDto1 = new UserDto("aaaa",
				"aaa",
				"aaa",
				"aaa@aaa.aaa",
				"aaa");
		
		userDao.insert(userDto1);
		assertTrue(userDao.count() == 1);
		
		UserDto userDto2;
		
		userDto2 = userDao.select("aaaa");
		
		assertTrue(userDto1.equals(userDto2));
	}
	
	@Test
	public void deleteTest() throws Exception {
		userDao.deleteAll();
		assertTrue(userDao.count() == 0);
		
		UserDto userDto1 = new UserDto("aaaa",
				"aaa",
				"aaa",
				"aaa@aaa.aaa",
				"aaa");
		
		userDao.insert(userDto1);
		assertTrue(userDao.count() == 1);
		
		userDao.delete("aaaa");
		assertTrue(userDao.count() == 0);
	}
	
	@Test
	public void updateTest() throws Exception {
		userDao.deleteAll();
		assertTrue(userDao.count() == 0);
		
		UserDto userDto1 = new UserDto("aaaa",
				"aaa",
				"aaa",
				"aaa@aaa.aaa",
				"aaa");
		
		userDao.insert(userDto1);
		assertTrue(userDao.count() == 1);
		
		UserDto userDto2 = new UserDto("aaaa",
				"bbb",
				null,
				null,
				"aaa");
		
		userDao.update(userDto2);
		System.out.println("update complete");
		
		UserDto newuser = userDao.select("aaaa");
		
		System.out.println("newuser = " + newuser.toString());
		assertTrue(userDto2.equals(newuser));
	}
}
