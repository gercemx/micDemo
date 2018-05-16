package com.att.demo.util;

import java.nio.charset.Charset;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpHeaders;

/**
 * Clase encargada de generar los HEADERS de autenticacion basica
 * 
 * @author gerce
 *
 */
public class SecurityHeadersFactory {

	
	public static HttpHeaders createHeaders(String username, String password) {
		return new HttpHeaders() {
			private static final long serialVersionUID = 1L;
			
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
