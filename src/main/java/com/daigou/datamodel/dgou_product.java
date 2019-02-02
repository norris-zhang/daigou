package com.daigou.datamodel;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.daigou.datamodel.transience.PriceKey;

@Entity
@Table
public class dgou_product extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long prod_id;
	@ManyToOne
	@JoinColumn(name="prod_prca_id")
	private dgou_product_category prca;
	@Column
	private String prod_name;
	@Column
	private String prod_name_en;
	@Column
	private String prod_title;
	@Column
	private String prod_description;
	@Column
	private Double prod_gross_weight;
	@Column
	private Date prod_last_updated;
	@OneToMany(mappedBy="prod")
	private List<dgou_price> prceList = new ArrayList<>();
	@OneToMany(mappedBy="forProd")
	private List<dgou_picture> pictList = new ArrayList<>();
	// non persistent attributes
	@Transient
	private Map<PriceKey, dgou_price> effectivePrices = new HashMap<>();
	public Long getProd_id() {
		return prod_id;
	}
	public void setProd_id(Long prod_id) {
		this.prod_id = prod_id;
	}
	public dgou_product_category getPrca() {
		return prca;
	}
	public void setPrca(dgou_product_category prca) {
		this.prca = prca;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public String getProd_name_en() {
		return prod_name_en;
	}
	public void setProd_name_en(String prod_name_en) {
		this.prod_name_en = prod_name_en;
	}
	public String getProd_title() {
		return prod_title;
	}
	public void setProd_title(String prod_title) {
		this.prod_title = prod_title;
	}
	public String getProd_description() {
		return prod_description;
	}
	public void setProd_description(String prod_description) {
		this.prod_description = prod_description;
	}
	public Double getProd_gross_weight() {
		return prod_gross_weight;
	}
	public void setProd_gross_weight(Double prod_gross_weight) {
		this.prod_gross_weight = prod_gross_weight;
	}
	public Date getProd_last_updated() {
		return prod_last_updated;
	}
	public void setProd_last_updated(Date prod_last_updated) {
		this.prod_last_updated = prod_last_updated;
	}
	public List<dgou_price> getPrceList() {
		return prceList;
	}
	public void setPrceList(List<dgou_price> prceList) {
		this.prceList = prceList;
	}
	public List<dgou_picture> getPictList() {
		return pictList;
	}
	public void setPictList(List<dgou_picture> pictList) {
		this.pictList = pictList;
	}
	public Map<PriceKey, dgou_price> getEffectivePrices() {
		return effectivePrices;
	}
	public void setEffectivePrices(Map<PriceKey, dgou_price> effectivePrices) {
		this.effectivePrices = effectivePrices;
	}
	public void putEffectivePrices(PriceKey priceKey, dgou_price prce) {
		this.effectivePrices.put(priceKey, prce);
	}
	public String getMainPicPath() {
		if (pictList == null || pictList.size() == 0) {
			return "images/nerdy-dog.jpg";
		}
		return "picture/" + pictList.get(0).getPict_id();
	}
}
