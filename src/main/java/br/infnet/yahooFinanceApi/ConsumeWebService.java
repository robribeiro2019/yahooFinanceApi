package br.infnet.yahooFinanceApi;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class ConsumeWebService {
	
	   @Autowired
	   RestTemplate restTemplate;
	
	   @RequestMapping(value = "/")
	   public String getAPIYahooFinancas () {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      
	  	UriComponents uri = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host("query1.finance.yahoo.com")
				.path("v7/finance/quote")
				.queryParam("symbols", "TLS.AX,MUS.AX")
				.build();
	      
	      return restTemplate.exchange(uri.toUriString(), HttpMethod.GET, entity, String.class).getBody();
	   }
	}
