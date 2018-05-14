package com.att.demo.model;

public class PagApiResponse<T> {

	private T obj;
	private Integer pageNumber;
	private Boolean lastPage;
	public T getObj() {
		return obj;
	}
	public void setObj(T obj) {
		this.obj = obj;
	}
	public Integer getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	public Boolean getLastPage() {
		return lastPage;
	}
	public void setLastPage(Boolean lastPage) {
		this.lastPage = lastPage;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PagApiResponse [obj=");
		builder.append(obj);
		builder.append(", pageNumber=");
		builder.append(pageNumber);
		builder.append(", lastPage=");
		builder.append(lastPage);
		builder.append("]");
		return builder.toString();
	}
}
