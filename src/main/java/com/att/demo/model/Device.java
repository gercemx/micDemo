package com.att.demo.model;

/**
 * Clase que continene los datos principales de un dispositivo
 * 
 * @author gerce
 *
 */
public class Device {

	private String iccid;
	private String status; // Posible values ... ACTIVATED
	private String ratePlan; //":"Plan de datos IoT 100MB Pool 99",
	private String communicationPlan;
	public String getIccid() {
		return iccid;
	}
	public void setIccid(String iccid) {
		this.iccid = iccid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRatePlan() {
		return ratePlan;
	}
	public void setRatePlan(String ratePlan) {
		this.ratePlan = ratePlan;
	}
	public String getCommunicationPlan() {
		return communicationPlan;
	}
	public void setCommunicationPlan(String communicationPlan) {
		this.communicationPlan = communicationPlan;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Device [iccid=");
		builder.append(iccid);
		builder.append(", status=");
		builder.append(status);
		builder.append(", ratePlan=");
		builder.append(ratePlan);
		builder.append(", communicationPlan=");
		builder.append(communicationPlan);
		builder.append("]");
		return builder.toString();
	}
}
