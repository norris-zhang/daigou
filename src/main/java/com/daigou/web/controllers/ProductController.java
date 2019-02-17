package com.daigou.web.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.daigou.common.JsonFunctions;
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
	public ModelAndView customerList(@RequestParam(required=false) long[] ids,
			@RequestParam(required=false) String items,
			Model model) throws Exception {
		if (items != null && JsonFunctions.isJSONArray(items)) {
			Map<Long, Integer> productCountMap = parseProductCountMap(items);
			model.addAttribute("prodCountMap", productCountMap);
			if (ids == null) {
				ids = keySetAsLongArray(productCountMap);
			}
		}
		List<dgou_product> prodList = productService.getProducts(ids);
		model.addAttribute("prodList", prodList);
		return new ModelAndView("/product/customer-list.jsp", model.asMap());
	}
	private long[] keySetAsLongArray(Map<Long, Integer> productCountMap) {
		long[] ids = new long[productCountMap.size()];
		int index = 0;
		for (Long id : productCountMap.keySet()) {
			ids[index++] = id;
		}
		return ids;
	}
	private Map<Long, Integer> parseProductCountMap(String items) {
		List<Map<String, Object>> jsonArray = JsonFunctions.jsonArray2MapList(items);
		Map<Long, Integer> map = new HashMap<>();
		for (Map<String, Object> item : jsonArray) {
			Object id = item.get("id");
			Object count = item.get("count");
			map.put(((Number)id).longValue(), ((Number)count).intValue());
			System.out.println();
		}
		return map;
	}
}
