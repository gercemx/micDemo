package com.att.demo.service;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.att.demo.model.DevicesPage;
import com.att.demo.util.SecurityHeadersFactory;

/**
 * Contiene los metodos necesarios para trabajar/buscar dispositivos
 * 
 * @author gerce
 *
 */
@Service
@PropertySource("classpath:api.properties")
public class DeviceService {
	
	private static final String SMS_DEV_ENDPOINT = "https://restapi7.jasper.com/rws/api/v1/devices";
	
	@Value( "${att.api.username}" )
	private String username;
	
	@Value( "${att.api.key}" )
	private String key;
	/**
	 * OBjeto facilitador de servicios REST
	 * 
	 */
	private RestTemplate template;
	
	public DeviceService(){
		template = new RestTemplate();
	}

	public DevicesPage searchDevices(String accountId, Date modifiedSince,
			String status, Integer pageSize, Integer pageNumber) throws UnsupportedEncodingException{
		
		final UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(SMS_DEV_ENDPOINT);
		
        uriBuilder.queryParam("accountId" , accountId);
        uriBuilder.queryParam("modifiedSince"  , URLEncoder.encode("2017-01-01T00:00:00+00:00", "UTF-8"));
        uriBuilder.queryParam("status"  , status);
        uriBuilder.queryParam("pageSize", pageSize);
        uriBuilder.queryParam("pageNumber", pageNumber);

        final URI uri = uriBuilder.build(true).toUri();
		
		ResponseEntity<DevicesPage> respEntry = template.exchange(
				uri, HttpMethod.GET, 
				new HttpEntity<String>(
						SecurityHeadersFactory.createHeaders(username, key)),
				DevicesPage.class);
		
		
		return respEntry.getBody();
	}
}
