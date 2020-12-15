package com.example.biz;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	@RequestMapping("/view")
	public String view(Model model) {
		model.addAttribute("currentDate", new java.util.Date());
		return "view";
	}

	@RequestMapping("/user")
	public String user(Model model) {
		model.addAttribute("username", "วัม๖นฮ");
		model.addAttribute("userage", 24);
		model.addAttribute("job", "Developer");
		return "user";
	}

	@RequestMapping("/fruits")
	public String fruits(Model model) {
		String[] array = { "Apple", "Mango", "Lemon", "Grape" };
		model.addAttribute("fruits", array);
		return "fruits";
	}

	@RequestMapping(value = "/demo", method = RequestMethod.GET)
	public ModelAndView demo() {
		/*
		 * ModelAndView mav = new ModelAndView("view2"); mav.addObject("username",
		 * "วัม๖นฮ"); mav.addObject("currentDate", new java.util.Date()); return mav;
		 */
		ModelAndView mav = new ModelAndView();
		mav.addObject("userid", "example");
		mav.addObject("passwd", "12345678");
		mav.setViewName("/demo");
		return mav;
	}
}