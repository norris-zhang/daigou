package com.daigou.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.daigou.dao.ProductCategoryDao;
import com.daigou.datamodel.dgou_product_category;

@Component
@Transactional
public class ProductCategoryServiceImpl implements ProductCategoryService {
	private ProductCategoryDao dao;
	public ProductCategoryServiceImpl(ProductCategoryDao dao) {
		this.dao = dao;
	}
	@Override
	public List<dgou_product_category> getAllCategories() {
		List<dgou_product_category> list = dao.queryList("from dgou_product_category");
		return list;
	}

}
