package com.fondofit.stock.portfolio.proxy;

import java.util.Optional;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fondofit.stock.portfolio.model.ExchangeBean;


@FeignClient(name = "stock-exchange", fallback = StockBaseFeignProxyFallBack.class, url = "${stock.exchange.url}")
@RibbonClient(name = "stock-exchange")
public interface StockBaseFeignProxy {

	@GetMapping("/api/stock/price/{stockId}")
	Optional<ExchangeBean> getStockPriceByID(@PathVariable(name = "stockId", required = true) String stockId);

}

