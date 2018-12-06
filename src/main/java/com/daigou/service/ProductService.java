package com.daigou.service;

import java.util.List;

import com.daigou.common.paging.Page;
import com.daigou.datamodel.Product;

public interface ProductService {
	List<Product> getBestSellings(Page page);
}
