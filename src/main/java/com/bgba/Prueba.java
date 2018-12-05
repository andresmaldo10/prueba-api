package com.bgba;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@EnableAutoConfiguration
public class Prueba {

	@RequestMapping("/prueba")
	public String prueba() {
		
		System.setProperty("java.net.useSystemProxies", "false");	
		System.clearProperty("http.proxyHost");
		
		RestTemplate restTemplate = new RestTemplate();
		
		//String fooResourceUrl = "http://dwatsonapp.bancogalicia.com.ar:9080/orquestador-conversation/rest/ObtenerRespuesta";
		String fooResourceUrl = "http://gogs-cicd.devopenshift.bancogalicia.com.ar/L0283495/prueba";
		
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity<String>("{\"UserName\":\"usuario01|17382021\",\"BankID\":\"1000\"}", headers);		
		
		//String response = restTemplate.postForObject(fooResourceUrl, entity, String.class);
		ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
				
		
		return "hola que tal" + response;
	}
	

}
