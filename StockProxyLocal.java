package com.fondofit.stock.portfolio.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Profile;


//@Profile("local")
@FeignClient(name = "stock-exchange", fallback = StockProxyFallBack.class, url = "${stock.exchange.url}")

@RibbonClient(name = "stock-exchange")
public interface StockProxyLocal extends BaseProxy {

}

