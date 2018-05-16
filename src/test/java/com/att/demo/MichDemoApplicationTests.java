package com.att.demo;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.Charset;

import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.att.demo.model.DevicesPage;
import com.att.demo.model.sms.SmsMsgsIds;
import com.att.demo.service.DeviceService;
import com.att.demo.service.DeviceUsageService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MichDemoApplicationTests {
	
	private Logger LOGGER = LoggerFactory.getLogger(MichDemoApplicationTests.class);

	private String username = "";
	private String key="";

	
	private static final String SMS_MSG_ENDPOINT = "https://restapi7.jasper.com/rws/api/v1/smsMessages";
	
	private static final String SMS_DEV_ENDPOINT = "https://restapi7.jasper.com/rws/api/v1/devices";
	
	private static final String SMS_USG_ENDPOINT = "https://restapi7.jasper.com/rws/api/v1/devices/{iccid}/ctdUsages";
	
	private static final String SMS_USG_IN_ZONE_ENDPOINT = "https://restapi7.jasper.com/rws/api/v1/devices/{iccid}/usageInZone";

	@Autowired
	private DeviceService devService;
	
	@Autowired
	private DeviceUsageService devUsgService;
	
	@Test
	public void contextLoads() throws Exception {
		
		System.out.println(" Iniciando test 2 ... ");
		
//		DevicesPage page =devService.searchDevices("100301514", null, "activated", 50, 1); 
//		System.out.println("Devices found "+page.getDevices().size());
		
		System.out.println(
			this.devUsgService.getDeviceUsage("89520700100000010860")
		);
		
		System.out.println(
			this.devUsgService.currentCycleUsage("100301514", null, "activated", 50, 1)
		);
		
//		sendSMSTest();
		
//		sendDevicesTest();
		
//		sendUsagesTest();
		
//		sendUsagesInZoneTest();
	}
	
	
	private void sendSMSTest()  throws UnsupportedEncodingException {
		RestTemplate template = new RestTemplate();
		
		final UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(SMS_MSG_ENDPOINT);

        uriBuilder.queryParam("accountId" , "");
        uriBuilder.queryParam("fromDate"  , URLEncoder.encode("2018-05-01T00:00:00+00:00", "UTF-8"));
        uriBuilder.queryParam("pageSize"  , "50");
        uriBuilder.queryParam("pageNumber", "1");

        final URI uri = uriBuilder.build(true).toUri();
		
		ResponseEntity<SmsMsgsIds> respEntry = template.exchange(
				uri, HttpMethod.GET, 
				new HttpEntity<String>(createHeaders(username, key)),SmsMsgsIds.class);
		
		System.out.println("RESPONSE : "+ respEntry.getBody());
	}
	
	
	private void sendDevicesTest()  throws UnsupportedEncodingException {
		RestTemplate template = new RestTemplate();
		
		final UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(SMS_DEV_ENDPOINT);
		
        uriBuilder.queryParam("accountId" , "100301514");
        uriBuilder.queryParam("modifiedSince"  , URLEncoder.encode("2017-01-01T00:00:00+00:00", "UTF-8"));
        uriBuilder.queryParam("status"  , "activated");
        uriBuilder.queryParam("pageSize", "50");
        uriBuilder.queryParam("pageNumber", "1");

        final URI uri = uriBuilder.build(true).toUri();
		
		ResponseEntity<String> respEntry = template.exchange(
				uri, HttpMethod.GET, 
				new HttpEntity<String>(createHeaders(username, key)),String.class);
		
		System.out.println("RESPONSE : "+ respEntry.getBody());
	}
	
	private void sendUsagesTest()  throws UnsupportedEncodingException {
		RestTemplate template = new RestTemplate();
		
		String url = SMS_USG_ENDPOINT.replace("{iccid}","89520700100000010860");
		
		ResponseEntity<String> respEntry = template.exchange(
				url, HttpMethod.GET, 
				new HttpEntity<String>(createHeaders(username, key)),String.class);
		
		System.out.println("RESPONSE : "+ respEntry.getBody());
	}
	
	private void sendUsagesInZoneTest()  throws UnsupportedEncodingException {
		RestTemplate template = new RestTemplate();
		
		final UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(SMS_USG_IN_ZONE_ENDPOINT.replace("{iccid}","89520700100000034258"));
		
        uriBuilder.queryParam("cycleStartDate"  , URLEncoder.encode("2018-05-06+00:00", "UTF-8"));
		
        final URI uri = uriBuilder.build(true).toUri();
        
        System.out.println(" URL : "+uri);
        
		ResponseEntity<String> respEntry = template.exchange(
				uri, HttpMethod.GET, 
				new HttpEntity<String>(createHeaders(username, key)),String.class);
		
		System.out.println("RESPONSE : "+ respEntry.getBody());
	}
	
	
	private HttpHeaders createHeaders(String username, String password) {
		return new HttpHeaders() {
			{
				String auth = username + ":" + password;
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);

				set("Authorization", authHeader);
				set("Accept", "application/json");
			}
		};
	}

}
