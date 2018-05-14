package com.att.demo.model.sms;

import java.util.List;

public class SmsMsgsIds {

	private List<Integer> smsMsgIds;
	private Integer pageNumber;
	private Boolean lastPage;
	public List<Integer> getSmsMsgIds() {
		return smsMsgIds;
	}
	public void setSmsMsgIds(List<Integer> smsMsgIds) {
		this.smsMsgIds = smsMsgIds;
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
		builder.append("SmsMsgsIds [smsMsgIds=");
		builder.append(smsMsgIds);
		builder.append(", pageNumber=");
		builder.append(pageNumber);
		builder.append(", lastPage=");
		builder.append(lastPage);
		builder.append("]");
		return builder.toString();
	}
}
