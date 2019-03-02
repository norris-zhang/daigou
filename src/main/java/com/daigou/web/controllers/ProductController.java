package com.daigou.web.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.daigou.common.paging.Page;
import com.daigou.datamodel.dgou_product;
import com.daigou.service.ProductService;
import com.daigou.service.dto.SearchForm;

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
	public ModelAndView viewProductByCategory(@PathVariable Long cateId,
			@RequestParam(required=false, name="p", defaultValue="1") int pageNumber,
			@RequestParam(required=false, name="sc") String showCost, Model model) {
		Page page = new Page(pageNumber);
		List<dgou_product> prodList = productService.getProductsByCategory(cateId, page);
		model.addAttribute("prodList", prodList);
		model.addAttribute("isLastPage", page.getCurrentPage() >= page.getTotalPages());
		String requestURI = "/product/category/" + cateId;
		if (showCost != null) {
			requestURI += "?sc=" + showCost;
		}
		model.addAttribute("requestURI", requestURI);
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
	@RequestMapping(value="/search", method=POST)
	public ModelAndView postSearch(@Valid @ModelAttribute("searchForm") SearchForm searchForm,
			@RequestParam(required=false, name="sc") String showCost,
			BindingResult result, RedirectAttributes redirAttrs) throws Exception {
		String keyword = searchForm.getKeyword();
		String kwEncoded = URLEncoder.encode(keyword, "UTF-8");
		String redirUri = "/product/search?kw="+kwEncoded;
		if (showCost != null) {
			redirUri += "&sc=" + showCost;
		}
		return new ModelAndView("redirect:"+redirUri, redirAttrs.asMap());
	}
	@RequestMapping(value="/search", method=GET)
	public ModelAndView getSearch(@RequestParam(required=true, name="kw") String keyword,
			@RequestParam(required=false, name="p", defaultValue="1") int pageNumber,
			@RequestParam(required=false, name="sc") String showCost, Model model) throws Exception {
		Page page = new Page(pageNumber);
		List<dgou_product> prodList = productService.searchProduct(keyword, page);
		model.addAttribute("prodList", prodList);
		model.addAttribute("isLastPage", page.getCurrentPage() >= page.getTotalPages());
		String requestURI = "/product/search?kw=" + URLEncoder.encode(keyword, "UTF-8");
		if (showCost != null) {
			requestURI += "&sc=" + showCost;
		}
		model.addAttribute("requestURI", requestURI);
		model.addAttribute("cateName", "搜索结果");
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
		Map<Long, Integer> productCountMap = parseProductCountMap(items);
		model.addAttribute("prodCountMap", productCountMap);
		if (ids == null) {
			ids = keySetAsLongArray(productCountMap);
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
		Map<Long, Integer> map = new HashMap<>();
		if (items == null || items.trim().length() == 0) {
			return map;
		}
		String[] productCounts = items.trim().split("\\|");
		for (String prodCount : productCounts) {
			String[] prodIdAndCount = prodCount.split(",");
			if (prodIdAndCount.length == 0) {
				continue;
			} else if (prodIdAndCount.length == 1) {
				if (prodIdAndCount[0].trim().matches("\\d+")) {
					map.put(Long.valueOf(prodIdAndCount[0].trim()), 1);
				}
			} else {
				if (prodIdAndCount[0].trim().matches("\\d+")) {
					Integer count = 1;
					if (prodIdAndCount[1].trim().matches("\\d+")) {
						count = Integer.valueOf(prodIdAndCount[1].trim());
					}
					map.put(Long.valueOf(prodIdAndCount[0].trim()), count);
				}
			}
		}
		return map;
	}
}
