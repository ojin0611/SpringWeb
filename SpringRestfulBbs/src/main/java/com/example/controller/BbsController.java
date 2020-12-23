package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.service.BbsService;
import com.example.vo.BbsVO;

@Controller
public class BbsController {
	@Autowired
	private BbsService bbsService;

	@GetMapping("/list")
	public String list() {
		return "list.html";     //   /static/ + list.html
	}
	
	@RequestMapping(value = "/bbs", method = RequestMethod.GET)
	@ResponseBody
	public Map list1() {
		Map<String, Object> map = new HashMap<String, Object>();
		this.bbsService.readAll(map);
		List<BbsVO> list = (List<BbsVO>)map.get("results");
		map.put("code", "success");
		map.put("data", list);
		map.remove("results");
		return map;    //code, data만
	}
	
	@GetMapping("/write")
	public String write() {
		return "write.html";     //  /static/  +  write.html
	}
	
	@PostMapping("/write")
	@ResponseBody
	public Map write(@RequestBody BbsVO bbsVo) {
		this.bbsService.create(bbsVo);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "success");
		return map;
	}
	
}
