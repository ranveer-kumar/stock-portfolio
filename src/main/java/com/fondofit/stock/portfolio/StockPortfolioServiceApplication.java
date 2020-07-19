package com.fondofit.stock.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
//@EnableDiscoveryClient
public class StockPortfolioServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockPortfolioServiceApplication.class, args);
	}

//	  private static final String baseUrl = "http://localhost:9000";
//
//	    @Bean
//	    RestTemplate restTemplate(RestTemplateBuilder builder) {
//	        UriTemplateHandler uriTemplateHandler = new RootUriTemplateHandler(baseUrl);
//	        return builder
//	                .uriTemplateHandler(uriTemplateHandler)
//	                .build();
//	    }
//	@Bean
//	public RestTemplate restTemplate() {
//		RestTemplate restTemplate = new RestTemplate();
////		restTemplate.setErrorHandler(new CustomResponseErrorHandler());
//		return restTemplate;
//	}
}
