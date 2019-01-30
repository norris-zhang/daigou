package com.daigou.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class dgou_guige extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long guge_id;
	@Column
	private String guge_display;
	@Column
	private Double guge_amount;
	@Column
	private String guge_unit;
	public Long getGuge_id() {
		return guge_id;
	}
	public void setGuge_id(Long guge_id) {
		this.guge_id = guge_id;
	}
	public String getGuge_display() {
		return guge_display;
	}
	public void setGuge_display(String guge_display) {
		this.guge_display = guge_display;
	}
	public Double getGuge_amount() {
		return guge_amount;
	}
	public void setGuge_amount(Double guge_amount) {
		this.guge_amount = guge_amount;
	}
	public String getGuge_unit() {
		return guge_unit;
	}
	public void setGuge_unit(String guge_unit) {
		this.guge_unit = guge_unit;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((guge_amount == null) ? 0 : guge_amount.hashCode());
		result = prime * result + ((guge_display == null) ? 0 : guge_display.hashCode());
		result = prime * result + ((guge_id == null) ? 0 : guge_id.hashCode());
		result = prime * result + ((guge_unit == null) ? 0 : guge_unit.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		dgou_guige other = (dgou_guige) obj;
		if (guge_amount == null) {
			if (other.guge_amount != null)
				return false;
		} else if (!guge_amount.equals(other.guge_amount))
			return false;
		if (guge_display == null) {
			if (other.guge_display != null)
				return false;
		} else if (!guge_display.equals(other.guge_display))
			return false;
		if (guge_id == null) {
			if (other.guge_id != null)
				return false;
		} else if (!guge_id.equals(other.guge_id))
			return false;
		if (guge_unit == null) {
			if (other.guge_unit != null)
				return false;
		} else if (!guge_unit.equals(other.guge_unit))
			return false;
		return true;
	}
}
