package com.daigou.web.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.daigou.common.PictureFunctions;
import com.daigou.datamodel.dgou_guige;
import com.daigou.datamodel.dgou_picture;
import com.daigou.datamodel.dgou_product;
import com.daigou.datamodel.dgou_product_category;
import com.daigou.service.PictureService;
import com.daigou.service.ProductCategoryService;
import com.daigou.service.ProductService;
import com.daigou.service.dto.ProductForm;

@Controller
public class AdminController extends BaseController {
	private ProductCategoryService productCategoryService;
	private ProductService productService;
	private PictureService pictureService;
	public AdminController (ProductCategoryService productCategoryService,
							ProductService productService,
							PictureService pictureService) {
		this.productCategoryService = productCategoryService;
		this.productService = productService;
		this.pictureService = pictureService;
	}
	@RequestMapping(value="/admin/product/add", method=GET)
	public ModelAndView addProduct(Model model) {
		List<dgou_product_category> categoryList = productCategoryService.getAllCategories();
		model.addAttribute("categoryList", categoryList);
		List<dgou_guige> guigeList = productService.getAllGuige();
		model.addAttribute("guigeList", guigeList);
		return new ModelAndView("/admin/product/addProduct.jsp", model.asMap());
	}
	@RequestMapping(value="/admin/product/add", method=POST)
	public ModelAndView saveProduct(@Valid @ModelAttribute("product") ProductForm product, 
		      BindingResult result, RedirectAttributes redirAttrs) {
		productService.addProduct(product);
		List<dgou_product_category> categoryList = productCategoryService.getAllCategories();
		redirAttrs.addFlashAttribute("categoryList", categoryList);
		List<dgou_guige> guigeList = productService.getAllGuige();
		redirAttrs.addFlashAttribute("guigeList", guigeList);
		return new ModelAndView("redirect:/admin/product/add", redirAttrs.asMap());
	}
	@RequestMapping(value="/admin/picupload", method=POST)
	public ModelAndView uploadPict(@RequestParam("picUpload") MultipartFile file) throws IOException {
		dgou_picture pict = new dgou_picture();
		pict.setPict_original_file_name(file.getOriginalFilename());
		pict.setPict_file_extension(file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1));
		pict.setPict_size(file.getSize());
		pictureService.save(pict);
		PictureFunctions.savePicture(pict.getPict_id(), pict.getPict_file_extension(), file.getInputStream());
		return stringModelAndView(pict.getPict_id().toString());
	}
	@RequestMapping(value="/admin/product/price/{prodId}", method=GET)
	public ModelAndView listProduct(@PathVariable Long prodId, Model model) {
		dgou_product prod = productService.getProduct(prodId);
		model.addAttribute("prod", prod);
		List<dgou_guige> guigeList = productService.getAllGuige();
		model.addAttribute("guigeList", guigeList);
		return new ModelAndView("/admin/product/updatePrice.jsp", model.asMap());
	}
}
