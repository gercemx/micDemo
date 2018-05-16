package com.att.demo.service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.att.demo.model.Device;
import com.att.demo.model.DeviceCycleUsage;
import com.att.demo.model.DeviceUsage;
import com.att.demo.model.DevicesPage;
import com.att.demo.util.SecurityHeadersFactory;


@Service
@PropertySource("classpath:api.properties")
public class DeviceUsageService {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(DeviceUsageService.class);

	private static final String SMS_USG_ENDPOINT = "https://restapi7.jasper.com/rws/api/v1/devices/{iccid}/ctdUsages";
	
	@Value( "${att.api.username}" )
	private String username;
	
	@Value( "${att.api.key}" )
	private String key;
	
	/**
	 * OBjeto facilitador de servicios REST
	 * 
	 */
	private RestTemplate template;
	
	public DeviceUsageService(){
		template = new RestTemplate();
	}
	
	@Autowired
	private DeviceService devService;
	
	public DeviceUsage getDeviceUsage(String iccId){
		
		ResponseEntity<DeviceUsage> respEntry = template.exchange(
				SMS_USG_ENDPOINT.replace("{iccid}",iccId), 
				HttpMethod.GET, 
				new HttpEntity<String>(
						SecurityHeadersFactory.createHeaders(username, key)),
				DeviceUsage.class);
		
		return respEntry.getBody();
	}
	
	/**
	 * Obtiene la informacion de los consumos de todos los dispositivos de la cuenta
	 * 
	 * @param accountId
	 * @param modifiedSince
	 * @param status
	 * @param page
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<DeviceCycleUsage> currentCycleUsage(String accountId,
			Date modifiedSince, String status, Integer page, 
			Integer pageSize) throws Exception{
		
		List<DeviceCycleUsage> cycUsgs = new ArrayList<DeviceCycleUsage>();
		
		DevicesPage devs = null;
		
		//Obtenemos los dispositivos
		try {
			devs = this.devService.searchDevices(accountId, null, status, 50, 1);
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("{}", e);
			throw new Exception(" Ocurrio un error al recuperar la información. ");
		}
		
		if(devs != null && devs.getDevices() != null && !devs.getDevices().isEmpty()){
			
			//Recorremos los dispositivos y obtenemos sus datos de consumo
			for(Device d : devs.getDevices()){
				LOGGER.debug(" Buscando consumo de dispositivo {} ", d.getIccid());

				//Obtenemos datos de consumo
				DeviceUsage du = this.getDeviceUsage(d.getIccid());
				
				//creamos objeto 
				DeviceCycleUsage cu = new DeviceCycleUsage();
				cu.setIccid(d.getIccid());
				cu.setPlanUsages(new HashMap<String, DeviceUsage>());
				
				cu.getPlanUsages().put(du.getRatePlan(), du);
				
				//agregamos datos a lista
				cycUsgs.add(cu);
			}
		}
		
		
		return cycUsgs;
	}
	
	public DeviceCycleUsage histCycleUsage(String accountId, Date cycleStart){
		
		return null;
	}
}
