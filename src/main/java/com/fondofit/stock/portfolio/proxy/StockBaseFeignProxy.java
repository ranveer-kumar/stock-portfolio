package com.fondofit.stock.portfolio.proxy;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fondofit.stock.portfolio.model.ExchangeBean;

//import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@FeignClient(name = "stock-exchange-service", fallback = StockBaseFeignProxyFallBack.class, url = "${stock.exchange.url:http://localhost:9000}")
//@FeignClient(name = "stock-exchange-service",fallback = StockBaseFeignProxyFallBack.class, url = "${STOCK_EXCHANGE_URI:http://localhost}:9000")
//@RibbonClient(name = "stock-exchange-service")
//@CircuitBreaker(name = "stock-exchange")
public interface StockBaseFeignProxy {

	@GetMapping("/api/stock/price/{stockId}")
	Optional<ExchangeBean> getStockPriceByID(@PathVariable(name = "stockId", required = true) String stockId);

}

