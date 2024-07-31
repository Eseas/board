package com.fastcampus.ch4.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fastcampus.ch4.dao.UserDao;
import com.fastcampus.ch4.domain.UserDto;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private UserDao userDao;
	
	@GetMapping("/login")
	public String login() {
		return "/login";
	}
	
	@PostMapping("/login")
	public String login(
				String id, String pwd, boolean rememberId, String toURL,
				HttpServletRequest request,
				HttpServletResponse response
			) {
		
		if(!loginCheck(id, pwd)) {
			String msg = "id나 pw가 일치하지 않습니다.";
			
			return "redirect:login/login?msg=" + msg;
		}
		HttpSession session = request.getSession();
		session.setAttribute("id", "aaaa");
		if(rememberId) {
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(3600);
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
		toURL = toURL == null || toURL.equals("") ? "/" : toURL;
		
		return "redirect:"+toURL;
	}
	
	@GetMapping("/logout")
	public String logout(
				HttpSession session
			) {
		session.invalidate();
		return "redirect:/";
	}
	
	private boolean loginCheck(String id, String pwd) {
		/*UserDto user;
		
		try {
			user = userDao.select(id);
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return user != null && user.getPwd().equals(pwd);
		*/
		return true;
	}
}
