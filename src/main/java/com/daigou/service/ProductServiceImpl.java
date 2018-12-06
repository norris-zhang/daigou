package com.daigou.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.daigou.common.paging.Page;
import com.daigou.dao.BestSellingDao;
import com.daigou.dao.ProductDao;
import com.daigou.datamodel.BestSelling;
import com.daigou.datamodel.Product;

@Component
@Transactional
public class ProductServiceImpl implements ProductService {
	private ProductDao productDao;
	private BestSellingDao bestSellingDao;
	public ProductServiceImpl(ProductDao productDao,
							  BestSellingDao bestSellingDao) {
		this.productDao = productDao;
		this.bestSellingDao = bestSellingDao;
	}
	@Override
	public List<Product> getBestSellings(Page page) {
		String hql = "select count(id) from " + BestSelling.class.getName();
		int count = bestSellingDao.queryCountNamedParameters(hql);
		page.setTotalRecords(count);
		List<BestSelling> bestSellingList = bestSellingDao.queryList(page, "effectiveDate desc");
		List<Product> prodList = new ArrayList<>();
		for (BestSelling bs : bestSellingList) {
			prodList.add(bs.getProduct());
		}
		return prodList;
	}

}
