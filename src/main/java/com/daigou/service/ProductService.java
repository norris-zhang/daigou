package com.daigou.service;

import java.util.List;

import javax.validation.Valid;

import com.daigou.common.paging.Page;
import com.daigou.datamodel.Product;
import com.daigou.datamodel.dgou_guige;
import com.daigou.datamodel.dgou_product;
import com.daigou.service.dto.ProductForm;

public interface ProductService {
	List<Product> getBestSellings(Page page);
	List<dgou_product> getAllProducts(Page page);
	dgou_product getProduct(Long id);
	List<dgou_product> getProductsByCategory(Long cateId, Page page);
	List<dgou_guige> getAllGuige();
	void addProduct(@Valid ProductForm product);
	void updatePrice(ProductForm product);
}
