package com.daigou.service.dto;

public class ProductForm {
	private Long prodId;
	private Long productCategory;
	private String productName;
	private String productNameEn;
	private String displayTitle;
	private String productDescription;
	private Double grossWeight;
	private Long primaryPictId;
	private Long selectGuige;
	private String guigeDisplay;
	private Double guigeAmount;
	private String guigeUnit;
	private Integer priceCount;
	private Double priceAmount;
	private Double costCny;
	private Double costNzd;
	public Long getProdId() {
		return prodId;
	}
	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}
	public Long getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(Long productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductNameEn() {
		return productNameEn;
	}
	public void setProductNameEn(String productNameEn) {
		this.productNameEn = productNameEn;
	}
	public String getDisplayTitle() {
		return displayTitle;
	}
	public void setDisplayTitle(String displayTitle) {
		this.displayTitle = displayTitle;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public Double getGrossWeight() {
		return grossWeight;
	}
	public void setGrossWeight(Double grossWeight) {
		this.grossWeight = grossWeight;
	}
	public Long getPrimaryPictId() {
		return primaryPictId;
	}
	public void setPrimaryPictId(Long primaryPictId) {
		this.primaryPictId = primaryPictId;
	}
	public Long getSelectGuige() {
		return selectGuige;
	}
	public void setSelectGuige(Long selectGuige) {
		this.selectGuige = selectGuige;
	}
	public String getGuigeDisplay() {
		return guigeDisplay;
	}
	public void setGuigeDisplay(String guigeDisplay) {
		this.guigeDisplay = guigeDisplay;
	}
	public Double getGuigeAmount() {
		return guigeAmount;
	}
	public void setGuigeAmount(Double guigeAmount) {
		this.guigeAmount = guigeAmount;
	}
	public String getGuigeUnit() {
		return guigeUnit;
	}
	public void setGuigeUnit(String guigeUnit) {
		this.guigeUnit = guigeUnit;
	}
	public Integer getPriceCount() {
		return priceCount;
	}
	public void setPriceCount(Integer priceCount) {
		this.priceCount = priceCount;
	}
	public Double getPriceAmount() {
		return priceAmount;
	}
	public void setPriceAmount(Double priceAmount) {
		this.priceAmount = priceAmount;
	}
	public Double getCostCny() {
		return costCny;
	}
	public void setCostCny(Double costCny) {
		this.costCny = costCny;
	}
	public Double getCostNzd() {
		return costNzd;
	}
	public void setCostNzd(Double costNzd) {
		this.costNzd = costNzd;
	}
}
