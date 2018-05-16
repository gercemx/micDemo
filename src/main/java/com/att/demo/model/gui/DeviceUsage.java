package com.att.demo.model.gui;

import com.att.demo.model.Device;

public class DeviceUsage extends Device {

	private Long dataUsage;
	private Long smsUsage;
	private Long voiceUsage;
	
	private Boolean overageLimitReached;

	public Long getDataUsage() {
		return dataUsage;
	}

	public void setDataUsage(Long dataUsage) {
		this.dataUsage = dataUsage;
	}

	public Long getSmsUsage() {
		return smsUsage;
	}

	public void setSmsUsage(Long smsUsage) {
		this.smsUsage = smsUsage;
	}

	public Long getVoiceUsage() {
		return voiceUsage;
	}

	public void setVoiceUsage(Long voiceUsage) {
		this.voiceUsage = voiceUsage;
	}

	public Boolean getOverageLimitReached() {
		return overageLimitReached;
	}

	public void setOverageLimitReached(Boolean overageLimitReached) {
		this.overageLimitReached = overageLimitReached;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DeviceUsage [dataUsage=");
		builder.append(dataUsage);
		builder.append(", smsUsage=");
		builder.append(smsUsage);
		builder.append(", voiceUsage=");
		builder.append(voiceUsage);
		builder.append(", overageLimitReached=");
		builder.append(overageLimitReached);
		builder.append("]");
		return builder.toString();
	}
	
}
