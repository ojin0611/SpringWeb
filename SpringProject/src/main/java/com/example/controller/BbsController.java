package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.exception.BbsException;
import com.example.service.BbsService;
import com.example.vo.BbsVO;
import com.example.vo.UserVO;

import lombok.extern.java.Log;

@Controller
@Log
@RequestMapping("/bbs")
public class BbsController {
	@Autowired
	private BbsService bbsService;

	@GetMapping("/list")
	public String list(Model model) {
		List<BbsVO> list = this.bbsService.readAll();
		model.addAttribute("bbslist", list);
		//list.forEach(bbs -> log.info(bbs.toString()));
		//log.info("글 갯수 = " + list.size());
		return "/bbs/list";   //WEB-INF/views/bbs/list.jsp
	}
	
	@GetMapping("/write")
	public String write(HttpSession session) throws BbsException{
		Object obj = session.getAttribute("userInfo");
		if(obj == null) {
			throw new BbsException("게시판에 글을 쓰시려면 먼저 로그인해 주세요.");
		}
		else return "/bbs/write";    //WEB-INF/views/write.jsp
	}
	
	@PostMapping("/write")
	public String write1(BbsVO bbsVO, 
			@RequestParam("company") String company, 
			HttpSession session) {
		if(!bbsVO.getEmail().equals("")) {
			String email = bbsVO.getEmail();   //bbb
			email = email + "@" + company;   //bbb@ccc.com
			bbsVO.setEmail(email);
		}
		
		UserVO userVO = (UserVO)session.getAttribute("userInfo");
		bbsVO.setUserid(userVO.getUserid());
		//log.info(bbsVO.toString());
		this.bbsService.create(bbsVO);
		return "redirect:/bbs/list";
	}
	
	@GetMapping("/read")
	public String read(HttpServletRequest request, Model model) {
		//log.info("bno = " + request.getParameter("bno"));
		int bno = Integer.parseInt(request.getParameter("bno"));
		BbsVO bbsVO = this.bbsService.read(bno);
		model.addAttribute("bbsInfo", bbsVO);
		//log.info(bbsVO.toString());
		return "/bbs/read";    //WEB-INF/views/bbs/read.jsp
	}
	
	@GetMapping("/readnumUpdate/{bno}")
	public void readnumUpdate(@PathVariable int bno) {
		this.bbsService.updateReadnum(bno);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("bno") int bno) {
		this.bbsService.delete(bno);
		return "redirect:/bbs/list";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView update(@RequestParam("bno") int bno) {
		ModelAndView mav = new ModelAndView();
		BbsVO bbsVO = this.bbsService.read(bno);
		mav.addObject("bbsInfo", bbsVO);
		mav.setViewName("/bbs/update");   //WEB-INF/views/bbs/update.jsp
		return mav;     
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update1(BbsVO bbsVO, 
			@RequestParam("company") String company) {
		//log.info(bbsVO.toString());
		//log.info(company);
		//UserVO userVO = (UserVO)session.getAttribute("userInfo");
		//log.info(userVO.getName());
		String email = bbsVO.getEmail();
		email += "@" + company;    //jimin@nate.com
		bbsVO.setEmail(email);
		this.bbsService.update(bbsVO);
		return "redirect:/bbs/read?bno=" + bbsVO.getBno();
	}
	
	
}
