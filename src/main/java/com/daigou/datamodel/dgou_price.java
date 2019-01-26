package com.daigou.datamodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class dgou_price extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	private Long prce_id;
	@ManyToOne
	@JoinColumn(name="prce_prod_id")
	private dgou_product prod;
	@ManyToOne
	@JoinColumn(name="prce_guge_id")
	private dgou_guige guge;
	@Column
	private int prce_count;
	@Column
	private Date prce_effective_date;
	@Column
	private double prce_amount;
	@Column
	private Double prce_cost_cny;
	@Column
	private Double prce_cost_nzd;
	public Long getPrce_id() {
		return prce_id;
	}
	public void setPrce_id(Long prce_id) {
		this.prce_id = prce_id;
	}
	public dgou_product getProd() {
		return prod;
	}
	public void setProd(dgou_product prod) {
		this.prod = prod;
	}
	public dgou_guige getGuge() {
		return guge;
	}
	public void setGuge(dgou_guige guge) {
		this.guge = guge;
	}
	public int getPrce_count() {
		return prce_count;
	}
	public void setPrce_count(int prce_count) {
		this.prce_count = prce_count;
	}
	public Date getPrce_effective_date() {
		return prce_effective_date;
	}
	public void setPrce_effective_date(Date prce_effective_date) {
		this.prce_effective_date = prce_effective_date;
	}
	public double getPrce_amount() {
		return prce_amount;
	}
	public void setPrce_amount(double prce_amount) {
		this.prce_amount = prce_amount;
	}
	public Double getPrce_cost_cny() {
		return prce_cost_cny;
	}
	public void setPrce_cost_cny(Double prce_cost_cny) {
		this.prce_cost_cny = prce_cost_cny;
	}
	public Double getPrce_cost_nzd() {
		return prce_cost_nzd;
	}
	public void setPrce_cost_nzd(Double prce_cost_nzd) {
		this.prce_cost_nzd = prce_cost_nzd;
	}

}
