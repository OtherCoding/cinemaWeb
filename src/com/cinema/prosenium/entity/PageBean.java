package com.cinema.prosenium.entity;
/**
 * ��ҳ��
 * @author Administrator
 *
 */
public class PageBean {
	/**
	 * ��ҳ��
	 */
	private int totalPageCount = 1;
	/**
	 * ��ǰҳ��
	 */
	private int currPageNo = 1;
	/**
	 * �ܼ�¼
	 */
	private int totalCount = 0;
	/**
	 * ÿҳ��ʾ�ļ�¼
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
