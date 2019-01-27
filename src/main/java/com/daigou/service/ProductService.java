package com.daigou.service;

import java.util.List;

import com.daigou.common.paging.Page;
import com.daigou.datamodel.Product;
import com.daigou.datamodel.dgou_product;

public interface ProductService {
	List<Product> getBestSellings(Page page);
	List<dgou_product> getAllProducts(Page page);
	dgou_product getProduct(Long id);
	List<dgou_product> getProductsByCategory(Long cateId, Page page);
}
