package com.att.demo.model;

/**
 * Datos de uso de un dispositivo
 * 
 * @author gerce
 *
 */
public class DeviceUsage {

	private String iccid;
	private String imsi;
	private String msisdn;
	private String imei;
	private String status;
	private String ratePlan;
	private String communicationPlan;
	private Long ctdDataUsage;
	private Long ctdSMSUsage;
	private Long ctdVoiceUsage;
	private Long ctdSessionCount;
	private Boolean overageLimitReached;
	private String overageLimitOverride;
	public String getIccid() {
		return iccid;
	}
	public void setIccid(String iccid) {
		this.iccid = iccid;
	}
	public String getImsi() {
		return imsi;
	}
	public void setImsi(String imsi) {
		this.imsi = imsi;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
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
	public Long getCtdDataUsage() {
		return ctdDataUsage;
	}
	public void setCtdDataUsage(Long ctdDataUsage) {
		this.ctdDataUsage = ctdDataUsage;
	}
	public Long getCtdSMSUsage() {
		return ctdSMSUsage;
	}
	public void setCtdSMSUsage(Long ctdSMSUsage) {
		this.ctdSMSUsage = ctdSMSUsage;
	}
	public Long getCtdVoiceUsage() {
		return ctdVoiceUsage;
	}
	public void setCtdVoiceUsage(Long ctdVoiceUsage) {
		this.ctdVoiceUsage = ctdVoiceUsage;
	}
	public Long getCtdSessionCount() {
		return ctdSessionCount;
	}
	public void setCtdSessionCount(Long ctdSessionCount) {
		this.ctdSessionCount = ctdSessionCount;
	}
	public Boolean getOverageLimitReached() {
		return overageLimitReached;
	}
	public void setOverageLimitReached(Boolean overageLimitReached) {
		this.overageLimitReached = overageLimitReached;
	}
	public String getOverageLimitOverride() {
		return overageLimitOverride;
	}
	public void setOverageLimitOverride(String overageLimitOverride) {
		this.overageLimitOverride = overageLimitOverride;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DeviceUsageInZone [iccid=");
		builder.append(iccid);
		builder.append(", imsi=");
		builder.append(imsi);
		builder.append(", msisdn=");
		builder.append(msisdn);
		builder.append(", imei=");
		builder.append(imei);
		builder.append(", status=");
		builder.append(status);
		builder.append(", ratePlan=");
		builder.append(ratePlan);
		builder.append(", communicationPlan=");
		builder.append(communicationPlan);
		builder.append(", ctdDataUsage=");
		builder.append(ctdDataUsage);
		builder.append(", ctdSMSUsage=");
		builder.append(ctdSMSUsage);
		builder.append(", ctdVoiceUsage=");
		builder.append(ctdVoiceUsage);
		builder.append(", ctdSessionCount=");
		builder.append(ctdSessionCount);
		builder.append(", overageLimitReached=");
		builder.append(overageLimitReached);
		builder.append(", overageLimitOverride=");
		builder.append(overageLimitOverride);
		builder.append("]");
		return builder.toString();
	}
}
