package com.daigou.service;

import static com.daigou.common.DateFunctions.getStartOfDay;
import static com.daigou.common.DateFunctions.getSystemDate;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.daigou.common.paging.Page;
import com.daigou.dao.BestSellingDao;
import com.daigou.dao.GuigeDao;
import com.daigou.dao.PictureDao;
import com.daigou.dao.PriceDao;
import com.daigou.dao.ProductCategoryDao;
import com.daigou.dao.ProductDao;
import com.daigou.datamodel.BestSelling;
import com.daigou.datamodel.Product;
import com.daigou.datamodel.dgou_guige;
import com.daigou.datamodel.dgou_picture;
import com.daigou.datamodel.dgou_price;
import com.daigou.datamodel.dgou_product;
import com.daigou.datamodel.dgou_product_category;
import com.daigou.datamodel.transience.PriceKey;
import com.daigou.service.dto.ProductForm;

@Component
@Transactional
public class ProductServiceImpl implements ProductService {
	private ProductDao productDao;
	private ProductCategoryDao productCategoryDao;
	private BestSellingDao bestSellingDao;
	private GuigeDao guigeDao;
	private PictureDao pictureDao;
	private PriceDao priceDao;
	public ProductServiceImpl(ProductDao productDao,
							  ProductCategoryDao productCategoryDao,
							  BestSellingDao bestSellingDao,
							  GuigeDao guigeDao,
							  PictureDao pictureDao,
							  PriceDao priceDao) {
		this.productDao = productDao;
		this.productCategoryDao = productCategoryDao;
		this.bestSellingDao = bestSellingDao;
		this.guigeDao = guigeDao;
		this.pictureDao = pictureDao;
		this.priceDao = priceDao;
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
		prod.getPrceList().sort((p1, p2) -> {
			Long p1GugeId = p1.getGuge().getGuge_id();
			Long p2GugeId = p2.getGuge().getGuge_id();
			if (!p1GugeId.equals(p2GugeId)) {
				return p1.getGuge().getGuge_amount().compareTo(p2.getGuge().getGuge_amount());
			}
			if (p1.getPrce_count() != p2.getPrce_count()) {
				return p1.getPrce_count() - p2.getPrce_count();
			}
			return p2.getPrce_effective_date().compareTo(p1.getPrce_effective_date());
		});
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
	@Override
	public List<dgou_guige> getAllGuige() {
		return guigeDao.queryList("from dgou_guige");
	}
	@Override
	public void addProduct(@Valid ProductForm product) {
		dgou_product prod = saveProduct(product);
		updatePrimaryPicture(product, prod);
		savePrice(product, prod);
		
	}
	private void savePrice(ProductForm product, dgou_product prod) {
		dgou_guige guge = prepareGuige(product);
		dgou_price prce = new dgou_price();
		prce.setPrce_count(product.getPriceCount());
		prce.setPrce_amount(product.getPriceAmount());
		prce.setPrce_effective_date(getStartOfDay(getSystemDate()));
		prce.setGuge(guge);
		prce.setPrce_cost_cny(product.getCostCny());
		prce.setPrce_cost_nzd(product.getCostNzd());
		prce.setProd(prod);
		priceDao.save(prce);
	}
	private dgou_guige prepareGuige(ProductForm product) {
		dgou_guige guge = null;
		Long selectedGuigeId = product.getSelectGuige();
		if (selectedGuigeId == null || selectedGuigeId <= 0) {
			guge = new dgou_guige();
			guge.setGuge_display(product.getGuigeDisplay());
			guge.setGuge_amount(product.getGuigeAmount());
			guge.setGuge_unit(product.getGuigeUnit());
			guigeDao.save(guge);
		} else {
			guge = guigeDao.get(selectedGuigeId);
		}
		return guge;
	}
	private void updatePrimaryPicture(ProductForm product, dgou_product prod) {
		dgou_picture picture = pictureDao.get(product.getPrimaryPictId());
		picture.setForProd(prod);
		pictureDao.update(picture);
	}
	private dgou_product saveProduct(ProductForm product) {
		dgou_product_category prca = productCategoryDao.get(product.getProductCategory());
		dgou_product prod = new dgou_product();
		prod.setPrca(prca);
		prod.setProd_name(product.getProductName());
		prod.setProd_name_en(product.getProductNameEn());
		prod.setProd_title(product.getDisplayTitle());
		prod.setProd_description(product.getProductDescription());
		prod.setProd_gross_weight(product.getGrossWeight());
		prod.setProd_last_updated(getSystemDate());
		productDao.save(prod);
		return prod;
	}
	@Override
	public void updatePrice(ProductForm product) {
		dgou_product prod = productDao.get(product.getProdId());
		savePrice(product, prod);
	}

}
