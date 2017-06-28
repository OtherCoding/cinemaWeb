package com.cinema.prosenium.entity;
/**
 * 分页类
 * @author Administrator
 *
 */
public class PageBean {
	/**
	 * 总页数
	 */
	private int totalPageCount = 1;
	/**
	 * 当前页码
	 */
	private int currPageNo = 1;
	/**
	 * 总记录
	 */
	private int totalCount = 0;
	/**
	 * 每页显示的记录
	 */
	private int pageSize = 8;
	
	public PageBean() {
		super();
	}
	public PageBean(int totalPageCount, int currPageNo, int totalCount, int pageSize) {
		super();
		this.totalPageCount = totalPageCount;
		this.currPageNo = currPageNo;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public int getCurrPageNo() {
		return currPageNo;
	}
	public void setCurrPageNo(int currPageNo) {
		this.currPageNo = currPageNo;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
}
