package com.att.demo.model;

/**
 * Contiene los datos representativos del ciclo de un dispositivo
 * 
 * @author gerce
 *
 */
public class DeviceCycle {

	private String iccid;
	private String timeStamp;
	private String cycleStartDate;
	private String cycleEndDate;
	public String getIccid() {
		return iccid;
	}
	public void setIccid(String iccid) {
		this.iccid = iccid;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getCycleStartDate() {
		return cycleStartDate;
	}
	public void setCycleStartDate(String cycleStartDate) {
		this.cycleStartDate = cycleStartDate;
	}
	public String getCycleEndDate() {
		return cycleEndDate;
	}
	public void setCycleEndDate(String cycleEndDate) {
		this.cycleEndDate = cycleEndDate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DerviceCycle [iccid=");
		builder.append(iccid);
		builder.append(", timeStamp=");
		builder.append(timeStamp);
		builder.append(", cycleStartDate=");
		builder.append(cycleStartDate);
		builder.append(", cycleEndDate=");
		builder.append(cycleEndDate);
		builder.append("]");
		return builder.toString();
	}
}
