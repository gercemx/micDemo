package com.att.demo.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Contiene los datos de uso de un dispositivo en un ciclo (agrupados por plan)
 * 
 * @author gerce
 *
 */
public class DeviceCycleUsage extends DeviceCycle {

	private Map<String, DeviceUsage> planUsages;

	public Map<String, DeviceUsage> getPlanUsages() {
		return planUsages;
	}

	public void setPlanUsages(Map<String, DeviceUsage> planUsages) {
		this.planUsages = planUsages;
	}

	public List<com.att.demo.model.gui.DeviceUsage> toDeviceUsage(){
		
		List<com.att.demo.model.gui.DeviceUsage> duList = new ArrayList<com.att.demo.model.gui.DeviceUsage>();
		
		if(this.getPlanUsages() != null && !this.getPlanUsages().isEmpty()){
			
			Iterator<String> planIt = this.getPlanUsages().keySet().iterator();
			
			String key;
			while(planIt.hasNext()){
				key = planIt.next();
				
				DeviceUsage du = this.getPlanUsages().get(key);
				
				com.att.demo.model.gui.DeviceUsage guiDu = new com.att.demo.model.gui.DeviceUsage();
				
				guiDu.setIccid(this.getIccid());
				guiDu.setRatePlan(key);
				guiDu.setStatus(du.getStatus());
				
				guiDu.setDataUsage(du.getCtdDataUsage());
				guiDu.setSmsUsage(du.getCtdSMSUsage());
				guiDu.setVoiceUsage(du.getCtdVoiceUsage());
				
				guiDu.setOverageLimitReached(du.getOverageLimitReached());
				
				duList.add(guiDu);
				
			}
		}
		
		
		return duList;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DeviceCycleUsage [planUsages=");
		builder.append(planUsages);
		builder.append("]");
		return builder.toString();
	}
}
