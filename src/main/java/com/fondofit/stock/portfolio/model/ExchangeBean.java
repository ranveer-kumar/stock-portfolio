package com.fondofit.stock.portfolio.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("exchange")
public class ExchangeBean {

	@Id
	private String id;
	private String name;
	private Float price;
	
}


