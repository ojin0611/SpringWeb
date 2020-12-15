package com.example.biz;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.vo.UserVO;

import lombok.extern.java.Log;

@Controller
@Log
public class RequestController {
	/*
	 * @RequestMapping(value = "/confirm", method = RequestMethod.GET) // method��
	 * ��ġ���� ������ 405 error // ������ html ������ name tag�� �д´�.
	 */
	public String confirm(HttpServletRequest request, Model model) {
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String[] hobbies = request.getParameterValues("hobby");

		model.addAttribute("userid", userid);
		model.addAttribute("passwd", passwd);
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		model.addAttribute("gender", gender);
		model.addAttribute("hobbies", hobbies);
		return "confirm"; // /WEB-INF/views/confirm.jsp
	}

	// @RequestMapping(value = "/confirm", method = RequestMethod.GET)
	// RequestParam ���� ����ȯ �����൵ �ȴ�.
	public String confirm(@RequestParam("userid") String userid, @RequestParam("passwd") String passwd,
			@RequestParam("name") String name, @RequestParam("age") int age, @RequestParam("gender") String gender,
			@RequestParam("hobby") String[] hobbies, Model model) {
		model.addAttribute("userid", userid);
		model.addAttribute("passwd", passwd);
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		model.addAttribute("gender", gender);
		return "confirm"; // /WEB-INF/views/confirm.jsp
	}

	// @RequestMapping(value = "/confirm", method = RequestMethod.GET)
	public String confirm2(@RequestParam("userid") String userid, @RequestParam("passwd") String passwd,
			@RequestParam("name") String name, @RequestParam("age") int age, @RequestParam("gender") String gender,
			@RequestParam("hobby") String[] hobby, Model model) {
		UserVO userVO = new UserVO();
		userVO.setUserid(userid);
		userVO.setPasswd(passwd);
		userVO.setName(name);
		userVO.setAge(age);
		userVO.setGender(gender);
		userVO.setHobby(hobby);

		model.addAttribute("userVO", userVO);
		return "confirm2"; // /WEB-INF/views/confirm2.jsp
	}

	// @RequestMapping(value = "/confirm", method = RequestMethod.GET)
	public String confirm2(UserVO userVO) {
		log.info(userVO.toString());
		return "confirm2"; // /WEB-INF/views/confirm2.jsp
	}

	// @RequestMapping(value = "/confirm/{userid}/{passwd}/{name}/{age}/{gender}/{hobby}", method = RequestMethod.GET)
	public String confirm3(@PathVariable String userid, 
			@PathVariable String passwd, 
			@PathVariable String name,
			@PathVariable int age, 
			@PathVariable String gender, 
			@PathVariable String[] hobby, Model model) {
		UserVO userVO = new UserVO(userid, passwd, name, age, gender, hobby);
		model.addAttribute("userInfo", userVO); // userInfo��� ��ü�� model�� ��Ƽ�
		// confirm3.jsp�� ������!
		return "confirm3";
	}

	@RequestMapping(value = "/confirm", method = RequestMethod.POST)
	public String confirm4(@ModelAttribute("u") UserVO userVO) {
		return "confirm4";
	}
	
	
}