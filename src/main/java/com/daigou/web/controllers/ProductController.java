package com.daigou.web.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView viewProductByCategory(@PathVariable Long cateId, @RequestParam(required=false, name="p", defaultValue="1") int pageNumber, Model model) {
		Page page = new Page(pageNumber);
		List<dgou_product> prodList = productService.getProductsByCategory(cateId, page);
		model.addAttribute("prodList", prodList);
		model.addAttribute("isLastPage", page.getCurrentPage() >= page.getTotalPages());
		model.addAttribute("requestURI", "/product/category/" + cateId);
		if (prodList.size() > 0) {
			model.addAttribute("cateName", prodList.get(0).getPrca().getPrca_name());
		}
		if (pageNumber == 1) {
			return new ModelAndView("/index.jsp", model.asMap());
		} else if (prodList.size() == 0) {
			return stringModelAndView("");
		} else {
			return new ModelAndView("/product/product-list.jsp");
		}
	}
	@RequestMapping(value="/customerlist", method=RequestMethod.GET)
	public ModelAndView customerList(@RequestParam(required=false, name="ids", defaultValue="") long[] ids, Model model) throws Exception {
		List<dgou_product> prodList = productService.getProducts(ids);
		model.addAttribute("prodList", prodList);
		model.addAttribute("requestURI", "/");
		return new ModelAndView("/product/customer-list.jsp", model.asMap());
	}
}
