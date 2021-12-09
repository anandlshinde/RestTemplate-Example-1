package com.smtek.serviceImpl;

import java.util.Arrays;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smtek.dto.StockPriceResponse;
import com.smtek.dto.StockRequest;
import com.smtek.dto.StockResponse;
import com.smtek.service.IStockDetails;

@Service
public class StockDetailService implements IStockDetails {
	
	@Value("${api.stockPrice}")
	private String apiUrl;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ObjectMapper objMapper;

	@Override
	public StockResponse getStockDetail(String stockName,int stockQty) {
		
		//step-1
		HashMap<String, String> uriParameters=new HashMap<>();
		uriParameters.put("stockName", stockName);
		
		//step-2
		HttpHeaders headers=new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		//step-3
		HttpEntity<String> request=new HttpEntity<String>(headers);
		
		//calling another api
		ResponseEntity<String> responseEntity = this.restTemplate.exchange(apiUrl,HttpMethod.GET,request,String.class,uriParameters);
		StockPriceResponse priceResponse=null;
		System.out.println("responseEntity.getBody() :: "+responseEntity.getBody());
		try {
			 priceResponse = this.objMapper.readValue(responseEntity.getBody(), StockPriceResponse.class);
			 //{"stockName":"HCL","stockPrice":1750.0}
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		double totalAmount=stockQty*priceResponse.getStockPrice();
		
		StockResponse response=new StockResponse(priceResponse.getStockName(), stockQty, priceResponse.getStockPrice(), totalAmount);
		return response;
	}

}
