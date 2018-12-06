package com.daigou.datamodel;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="dgou_best_selling")
public class BestSelling extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="bsel_id")
	@GeneratedValue(strategy=IDENTITY)
	private Long id;
	@Column(name="bsel_effective_date")
	private Date effectiveDate;
	@ManyToOne
	@JoinColumn(name="bsel_prod_id")
	private Product product;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
}
