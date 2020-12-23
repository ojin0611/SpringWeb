package com.example.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.service.MemberService;
import com.example.vo.MemberVO;

import lombok.extern.java.Log;

@Controller
@Log
public class HomeController {
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("serverTime", new Date().toString());
		return "home"; // WEB-INF/views/home.jsp
	}

	@RequestMapping(value = "/members", method = RequestMethod.GET)
	@ResponseBody
	public Map members() {
		List<MemberVO> list = this.memberService.select();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "success");
		map.put("data", list);
		return map;
	}

	@RequestMapping(value = "/members/{userid}", method = RequestMethod.GET)
	@ResponseBody
	public Map memberInfo(@PathVariable String userid) {
		MemberVO member = this.memberService.selectMember(userid);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "success");
		map.put("data", member);
		return map;
	}

	@RequestMapping(value = "/members", method = RequestMethod.POST)
	@ResponseBody
	public Map insert(@RequestBody MemberVO memberVO) {
		// 절대로 form 에서 submit하면 안됨.
		// log.info(memberVO.toString());
		this.memberService.insertMember(memberVO);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "success");
		return map;
	}

	@RequestMapping(value = "/members", method = RequestMethod.PUT)
	@ResponseBody
	public Map update(@RequestBody MemberVO memberVO) {
		this.memberService.updateMember(memberVO);
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
}
