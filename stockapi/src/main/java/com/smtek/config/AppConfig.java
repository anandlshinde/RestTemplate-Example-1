package com.smtek.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class AppConfig {

	@Bean
	public RestTemplate createRestTemplateObj() {
		return new RestTemplate();
	}
	
	@Bean
	public ObjectMapper createObjMapperObj() {
		return new ObjectMapper();
	}
}
