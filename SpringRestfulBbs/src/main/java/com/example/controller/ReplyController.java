package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.service.ReplyService;
import com.example.vo.ReplyVO;

@Controller
public class ReplyController {
	@Autowired
	private ReplyService replyService;

	@RequestMapping(value = "/reply", method = RequestMethod.POST)
	@ResponseBody
	public Map replyInsert(@RequestBody ReplyVO replyVo) {
		this.replyService.create(replyVo);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "success");
		return map;
	}

	@RequestMapping(value = "/reply/{idx}", method = RequestMethod.GET)
	@ResponseBody
	public Map replylist(@PathVariable int idx) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("idx", idx);
		this.replyService.select(map);
		List<ReplyVO> list = (List<ReplyVO>) map.get("results");
		map.remove("results");
		map.remove("idx");
		map.put("code", "success");
		map.put("data", list);
		return map;
	}
}
