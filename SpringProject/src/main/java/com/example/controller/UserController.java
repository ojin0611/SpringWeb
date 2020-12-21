package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.exception.LoginException;
import com.example.service.UserService;
import com.example.vo.UserVO;

import lombok.extern.java.Log;

@Controller
@Log
@RequestMapping("/membership")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		return "/membership/register";   //WEB-INF/views/membership/register.jsp
	}
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register1(UserVO userVO) {
		//log.info(userVO.toString());
		this.userService.create(userVO);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "/membership/login";       //WEB-INF/views/membership/login.jsp
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login1(@RequestParam("userid") String userid, 
			                     @RequestParam("passwd") String passwd,
			                     HttpSession session) throws LoginException{
		int result = this.userService.login(userid, passwd);
		//result : -1, 0, 1
		String page = null;
		if(result == -1) throw new LoginException("존재하지 않는 아이디 입니다.");
		else if(result == 0) throw new LoginException("비밀번호가 일치하지 않습니다.");
		else {
			UserVO userVO = this.userService.read(userid);
			session.setAttribute("userInfo", userVO);
			page = "redirect:/";
		}
		return page;
	}
	
	@RequestMapping(value="/idcheck/{userid}", method = RequestMethod.POST)
	public @ResponseBody Map idcheck(@PathVariable String userid) {
		UserVO userVO = this.userService.read(userid);
		//해당 userid를 찾으면 null이 아니고, 못찾으면 null이다. 
		//해당 userid를 찾으면, 이 아이디는 사용할 수 없고,
		//해당 userid를 못찾으면 이 아이디는 사용할 수 있다. 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "success");
		if(userVO == null) map.put("result", true);  //사용할 수 있음.
		else map.put("result", false);   //사용할 수 없음.
		return map;
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpSession session, Model model) {
		UserVO userVO = (UserVO)session.getAttribute("userInfo");
		session.invalidate();
		model.addAttribute("username", userVO.getName());
		return "membership/logout";      //WEB-INF/views/membership/logout.jsp
	}
	
	@RequestMapping(value="/admin", method = RequestMethod.GET)
	public String admin(Model model) {
		List<UserVO> list = this.userService.readAll();
		model.addAttribute("userlist", list);
		return "membership/admin";           //WEB-INF/views/membership/admin.jsp
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public String delete(HttpSession session) {
		UserVO userVO = (UserVO)session.getAttribute("userInfo");
		session.invalidate();
		this.userService.delete(userVO.getUserid());
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/userinfo", method = RequestMethod.GET)
	public String userinfo() {
		return "membership/userinfo";         //WEB-INF/views/membership/userinfo.jsp
	}
	
	@RequestMapping(value="/update/{age}", method = RequestMethod.GET)
	public String update(@PathVariable int age, HttpSession session) {
		UserVO userVO = (UserVO)session.getAttribute("userInfo");
		userVO.setAge(age);
		this.userService.update(userVO);
		return "redirect:/membership/userinfo";
	}
	
	
}