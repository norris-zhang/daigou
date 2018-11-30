package com.daigou.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController {
	@RequestMapping(value= {"", "/"}, method=RequestMethod.GET)
	public ModelAndView saveBaseInfo(Model model) throws Exception {
		return new ModelAndView("/index.jsp", model.asMap());
	}
}
