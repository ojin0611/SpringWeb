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
import org.springframework.web.servlet.ModelAndView;

import com.example.service.UserService;
import com.example.vo.UserVO;

import lombok.extern.java.Log;

@Controller
@Log
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(UserVO userVO) {
		//log.info(userVO.toString());
		this.userService.create(userVO);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";       //WEB-INF/views/login.jsp
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login1(@RequestParam("userid") String userid, 
			                     @RequestParam("passwd") String passwd) {
		int result = this.userService.login(userid, passwd);
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", result);
		
		//login에 성공하면 userid를 가지고 해당 유저의 정보를 가져오자.
		UserVO userVO = null;
		if(result == 1) {
			userVO = this.userService.read(userid);
			mav.addObject("userInfo", userVO);
		}
		mav.setViewName("loginresult");  //WEB-INF/views/loginresult.jsp
		return mav;   
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
		return "logout";      //WEB-INF/views/logout.jsp
	}
	
	@RequestMapping(value="/admin", method = RequestMethod.GET)
	public String admin(Model model) {
		List<UserVO> list = this.userService.readAll();
		model.addAttribute("userlist", list);
		return "admin";           //WEB-INF/views/admin.jsp
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public String delete(HttpSession session) {
		UserVO userVO = (UserVO) session.getAttribute("userInfo");
		session.invalidate();
		this.userService.delete(userVO.getUserid());
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/userinfo", method = RequestMethod.GET)
	public String userinfo() {
		
		return "userinfo";
	}
	
}