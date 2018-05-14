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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.att.demo.model.sms.SmsMsgsIds;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MichDemoApplicationTests {
	
	private Logger LOGGER = LoggerFactory.getLogger(MichDemoApplicationTests.class);

	private String username = "";
	private String key="";

	
	private String SMS_MSG_ENDPOINT = "https://restapi7.jasper.com/rws/api/v1/smsMessages";
	@Test
	public void contextLoads() throws UnsupportedEncodingException {
		
		System.out.println(" Iniciando test ... ");
		
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
