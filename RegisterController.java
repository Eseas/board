package com.fastcampus.ch4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.fastcampus.ch4.dao.UserDao;
import com.fastcampus.ch4.domain.UserDto;

@Controller
public class RegisterController {
	@Autowired
	UserDao userDao;
	
	@GetMapping("/register")
	public String regist() {
		return "/register";
	}
	
	@PostMapping("/register")
	public String regist(
			String id,
			String pwd,
			String name,
			String email,
			String birth,
			String sns ) throws Exception {
		
		UserDto userDto = new UserDto(id, pwd, name, email, birth, sns);
		
		if(regist(userDto) == -1) {
			String msg = "회원가입에 실패했습니다.";
			
			return "redirect:/register?msg=" + msg;
		}
		
		return "/login";
	}
	
	private int regist(UserDto userDto) throws Exception{
		try {
			return userDao.insert(userDto);
		} catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
}
