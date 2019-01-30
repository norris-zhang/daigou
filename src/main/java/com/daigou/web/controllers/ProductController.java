package com.daigou.web.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.daigou.common.paging.Page;
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
	@RequestMapping(value="/category/{cateId}", method=GET)
	public ModelAndView viewProductByCategory(@PathVariable Long cateId, Model model) {
		Page page = new Page(1, 30);
		List<dgou_product> prodList = productService.getProductsByCategory(cateId, page);
		model.addAttribute("prodList", prodList);
		model.addAttribute("isLastPage", page.getCurrentPage() >= page.getTotalPages());
		model.addAttribute("requestURI", "/product/category/" + cateId);
		return new ModelAndView("/index.jsp", model.asMap());
	}
}
