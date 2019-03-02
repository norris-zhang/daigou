package com.daigou.common.paging;

public class Page {
	public static final int DEFAULT_PAGE_SIZE = 8;
	private int currentPage;
	private int pageSize;

	private int startRowNum;
	private int totalPages;
	private int totalRecords;

	public Page() {
		
	}
	public Page(int currentPage) {
		this.currentPage = currentPage;
		this.pageSize = DEFAULT_PAGE_SIZE;
	}
	public Page(int currentPage, int pageSize) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
		calculate();
	}
	public int getStartRowNum() {
		return startRowNum;
	}
	public int getTotalPages() {
		return totalPages;
	}
	private void calculate() {
		if (currentPage < 1) currentPage = 1;
		if (pageSize < 1) pageSize = DEFAULT_PAGE_SIZE;

		totalPages = totalRecords == 0 ? 1 :
			(totalRecords % pageSize == 0 ? totalRecords / pageSize : totalRecords / pageSize + 1);

		startRowNum = (currentPage - 1) * pageSize;
		if (startRowNum < 0) startRowNum = 0;
	}
}