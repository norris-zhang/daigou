package com.daigou.datamodel.transience;

import java.io.Serializable;

import com.daigou.datamodel.dgou_guige;

public class PriceKey implements Serializable {
	private static final long serialVersionUID = 1L;
	private dgou_guige guge;
	private int count;
	public PriceKey(dgou_guige guge, int count) {
		this.guge = guge;
		this.count = count;
	}
	public dgou_guige getGuge() {
		return guge;
	}
	public void setGuge(dgou_guige guge) {
		this.guge = guge;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + ((guge == null) ? 0 : guge.hashCode());
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
		PriceKey other = (PriceKey) obj;
		if (count != other.count)
			return false;
		if (guge == null) {
			if (other.guge != null)
				return false;
		} else if (!guge.equals(other.guge))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PriceKey [guge=" + guge + ", count=" + count + "]";
	}
}
