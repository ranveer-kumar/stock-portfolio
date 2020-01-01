package com.fondofit.stock.portfolio.model;

import lombok.Data;

@Data
//@Document("stocks")
public class Stocks {

	private String id;
	private Float value;
	private int count;
}
