package com.daigou.web.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.daigou.common.paging.Page;
import com.daigou.datamodel.dgou_product;
import com.daigou.service.ProductService;

@Controller
public class HomeController extends BaseController {
	private ProductService productService;
	public HomeController(ProductService productService) {
		this.productService = productService;
	}
	@RequestMapping(value= {"", "/"}, method=RequestMethod.GET)
	public ModelAndView home(Model model) throws Exception {
		Page page = new Page(1, 30);
		List<dgou_product> prodList = productService.getAllProducts(page);
		model.addAttribute("prodList", prodList);
		model.addAttribute("isLastPage", page.getCurrentPage() >= page.getTotalPages());
		return new ModelAndView("/index.jsp", model.asMap());
	}
}
