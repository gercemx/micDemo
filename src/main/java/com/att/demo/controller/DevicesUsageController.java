package com.att.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.att.demo.model.DeviceCycleUsage;
import com.att.demo.model.gui.DeviceUsage;
import com.att.demo.service.DeviceUsageService;

@Controller
@RequestMapping(value="/account/{accountId}/devices")
public class DevicesUsageController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(DevicesUsageController.class); 

	@Autowired
	private DeviceUsageService devUsgService;
	
	@RequestMapping(value="/usage/{cycleId}")
	@ResponseBody
	private List<DeviceUsage> getDeviceUsage( @PathVariable String accountId, 
			@PathVariable String cycleId) throws Exception{
		
		LOGGER.debug(" Iniciando getDeviceUsage {} - ", accountId, cycleId);
		
		// Buscamos los dispositivos
		List<DeviceCycleUsage> devCycles = this.devUsgService.currentCycleUsage(accountId, null, "activated", 50, 1);
		
		List<DeviceUsage> response = null;
		
		//Convertimos objeto de "negocio" a objeto de GUI
		if(devCycles != null && !devCycles.isEmpty()){
			response = new ArrayList<DeviceUsage>();
			
			for(DeviceCycleUsage du : devCycles){
				response.addAll(du.toDeviceUsage());
			}
		}
		
		return response;
	}
}
