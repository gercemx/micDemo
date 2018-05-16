package com.att.demo.model;

import java.util.List;

/**
 * Contiene el resultado de la busqueda de dispositivos
 * 
 * @author gerce
 *
 */
public class DevicesPage {

	private Integer pageNumber;
	private Boolean lastPage;
	private List<Device> devices;
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
	public List<Device> getDevices() {
		return devices;
	}
	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DevicesPage [pageNumber=");
		builder.append(pageNumber);
		builder.append(", lastPage=");
		builder.append(lastPage);
		builder.append(", devices=");
		builder.append(devices);
		builder.append("]");
		return builder.toString();
	}
}
