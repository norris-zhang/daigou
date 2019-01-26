package com.daigou.web.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.daigou.datamodel.dgou_product;
import com.daigou.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController extends BaseController {
	private ProductService productService;
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	@RequestMapping(value="/{id}", method=GET)
	public ModelAndView viewProduct(@PathVariable Long id, Model model) {
		dgou_product prod = productService.getProduct(id);
		model.addAttribute("prod", prod);
		return new ModelAndView("/product/product-info.jsp", model.asMap());
	}
}
