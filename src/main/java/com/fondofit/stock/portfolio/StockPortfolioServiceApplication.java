package com.fondofit.stock.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StockPortfolioServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockPortfolioServiceApplication.class, args);
	}

}
