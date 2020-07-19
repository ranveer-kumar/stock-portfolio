package com.fondofit.stock.portfolio.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("portfolio")
public class PortfolioBean {

	@Id
	private String customerId;
	private List<Stocks> stocks;
	private Float portfolioValue;
	private String instanceID;
	
}


