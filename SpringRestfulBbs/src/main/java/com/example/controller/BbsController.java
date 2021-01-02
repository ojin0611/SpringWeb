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

import com.example.service.BbsService;
import com.example.vo.BbsVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
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
	
	@RequestMapping(value = "/bbs", method = RequestMethod.POST)
	@ResponseBody
	public Map write(@RequestBody BbsVO bbsVo) {
		//log.warn(bbsVo.toString());
		this.bbsService.create(bbsVo);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "success");
		return map;
	}
	
	@GetMapping("/view")
	public String view(@RequestParam("idx") int idx) {
		return "view.html?idx=" + idx;     //   /static/ + view.html
	}
	
	@RequestMapping(value = "/bbs/{idx}", method = RequestMethod.GET)
	@ResponseBody
	public Map view1(@PathVariable int idx) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("idx", idx);
		this.bbsService.read(map);
		List<BbsVO> list = (List<BbsVO>)map.get("result");
		BbsVO bbsVO = list.get(0);
		map.remove("result");
		map.remove("idx");
		map.put("code", "success");
		map.put("data", bbsVO);
		return map;
	}
	
	@RequestMapping(value = "/bbs/{idx}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map delete(@PathVariable int idx) {
		this.bbsService.delete(idx);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "success");
		return map;
	}
	
	@RequestMapping(value = "/bbs", method = RequestMethod.PUT)
	@ResponseBody
	public Map update(@RequestBody BbsVO bbsVo) {
		this.bbsService.update(bbsVo);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "success");
		return map;
	}
	
	@GetMapping("/update")
	public String update(@RequestParam("idx") int idx) {
		return "update.html?idx=" + idx;
	}
	
}
