package com.fondofit.stock.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RootUriTemplateHandler;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplateHandler;

@SpringBootApplication
@EnableFeignClients
public class StockPortfolioServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockPortfolioServiceApplication.class, args);
	}

	  private static final String baseUrl = "http://localhost:9000";

	    @Bean
	    RestTemplate restTemplate(RestTemplateBuilder builder) {
	        UriTemplateHandler uriTemplateHandler = new RootUriTemplateHandler(baseUrl);
	        return builder
	                .uriTemplateHandler(uriTemplateHandler)
	                .build();
	    }
//	@Bean
//	public RestTemplate restTemplate() {
//		RestTemplate restTemplate = new RestTemplate();
////		restTemplate.setErrorHandler(new CustomResponseErrorHandler());
//		return restTemplate;
//	}
}
