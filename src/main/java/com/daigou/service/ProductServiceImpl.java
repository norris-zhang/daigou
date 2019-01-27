package com.daigou.service;

import static com.daigou.common.DateFunctions.getSystemDate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.daigou.common.paging.Page;
import com.daigou.dao.BestSellingDao;
import com.daigou.dao.ProductDao;
import com.daigou.datamodel.BestSelling;
import com.daigou.datamodel.Product;
import com.daigou.datamodel.dgou_price;
import com.daigou.datamodel.dgou_product;
import com.daigou.datamodel.transience.PriceKey;

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
	@Override
	public List<dgou_product> getAllProducts(Page page) {
		String hql = "select count(prod_id) from dgou_product";
		int count = productDao.queryCount(hql);
		page.setTotalRecords(count);
		List<dgou_product> prodList = productDao.queryList(page, "prod_last_updated desc");
		for (dgou_product prod : prodList) {
			initializeProduct(prod);
		}
		
		return prodList;
	}
	private void setProdEffectivePrices(dgou_product prod) {
		prod.getPrceList().forEach(prce -> {
			PriceKey priceKey = new PriceKey(prce.getGuge(), prce.getPrce_count());
			dgou_price p = prod.getEffectivePrices().get(priceKey);
			dgou_price moreEffectivePrice = getMoreEffective(prce, p);
			if (moreEffectivePrice != null) {
				prod.putEffectivePrices(priceKey, moreEffectivePrice);
			}
		});
	}
	private dgou_price getMoreEffective(dgou_price p1, dgou_price p2) {		
		List<dgou_price> list = new ArrayList<>();
		if (p1 != null) {
			list.add(p1);
		}
		if (p2 != null) {
			list.add(p2);
		}
		list.sort((p, q) -> {return q.getPrce_effective_date().compareTo(p.getPrce_effective_date());});
		for (dgou_price prce : list) {
			if (!prce.getPrce_effective_date().after(getSystemDate())) {
				return prce;
			}
		}
		return null;
	}

	@Override
	public dgou_product getProduct(Long id) {
		dgou_product prod = productDao.get(id);
		initializeProduct(prod);
		return prod;
	}

	@Override
	public List<dgou_product> getProductsByCategory(Long cateId, Page page) {
		String hql = "select count(id) from dgou_product where prca.prca_id=:cateId";
		int count = productDao.queryCountNamedParameters(hql, "cateId", cateId);
		page.setTotalRecords(count);

		hql = "from dgou_product where prca.prca_id=:cateId order by prod_last_updated desc";
		List<dgou_product> prodList = productDao.queryListNamedParameters(hql, page, "cateId", cateId);
		for (dgou_product prod : prodList) {
			initializeProduct(prod);
		}
		return prodList;
	}
	private void initializeProduct(dgou_product prod) {
		if (!Hibernate.isInitialized(prod.getPrceList())) {
			Hibernate.initialize(prod.getPrceList());
		}
		setProdEffectivePrices(prod);
		if (!Hibernate.isInitialized(prod.getPictList())) {
			Hibernate.initialize(prod.getPictList());
		}
	}

}
