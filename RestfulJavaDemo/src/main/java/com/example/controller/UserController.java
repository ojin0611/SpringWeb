package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.service.MemberService;
import com.example.vo.MemberVO;

import lombok.extern.java.Log;

@Controller
@Log
public class UserController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/")
	public String main() {
		return "index.html";		//  /static/index.html
	}
	
	// /view?userid=" + userid
	@GetMapping("/view")
	public String view(@RequestParam("userid") String userid) {
		return "view.html?userid=" + userid;	// /static/ + view + .html
	}
	
	@RequestMapping(value = "/members", method = RequestMethod.GET)
	@ResponseBody
	public Map read() {
		List<MemberVO> list = this.memberService.select();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "success");
		map.put("data", list);
		return map;
	}
	
	@RequestMapping(value = "/members/{userid}", method=RequestMethod.GET)
	@ResponseBody
	public Map read(@PathVariable String userid) {
		MemberVO member = this.memberService.selectMember(userid);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "success");
		map.put("data", member);
		return map;
	}
	
	@GetMapping("/register")
	public String register() {
		return "register.html";	// /static/ + register + .html
	}
	
	@RequestMapping(value = "/members", method = RequestMethod.POST)
	@ResponseBody
	public Map register(@RequestBody MemberVO member) {
		this.memberService.insertMember(member);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "success");
		return map;
	}
	
	@RequestMapping(value = "/members/{userid}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map delete(@PathVariable String userid) {
		this.memberService.deleteMember(userid);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "success");
		return map;
	}
	
	@RequestMapping(value = "/members", method = RequestMethod.PUT)
	@ResponseBody
	public Map modify(@RequestBody MemberVO member) {
		this.memberService.updateMember(member);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "success");
		return map;
	}
}
