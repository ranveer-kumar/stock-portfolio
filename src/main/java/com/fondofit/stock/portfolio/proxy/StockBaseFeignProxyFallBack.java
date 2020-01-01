package com.fondofit.stock.portfolio.proxy;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fondofit.stock.portfolio.model.ExchangeBean;

@Component
public class StockBaseFeignProxyFallBack implements StockBaseFeignProxy {
	Logger log = LoggerFactory.getLogger(StockBaseFeignProxyFallBack.class);

	public Optional<ExchangeBean> getStockPriceByID(String stockId) {
		log.error("ERROR: Fallback getPortFolioByID(String stockId)");
		return null;
	}

}
