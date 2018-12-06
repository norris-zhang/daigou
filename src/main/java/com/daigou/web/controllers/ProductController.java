package com.daigou.web.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/products")
public class ProductController extends BaseController {
	@RequestMapping(value="/bestsellings", method=GET, params="p")
	public ModelAndView getBestSellings(@RequestParam("p") int page) {
		System.out.println(page);
		return null;
	}
}
