package com.fondofit.stock.portfolio.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Profile;


//@Profile("k8s")
@FeignClient(name = "stock-exchange", fallback = StockProxyFallBack.class)

@RibbonClient(name = "stock-exchange")
public interface StockProxyK8s extends BaseProxy {

}

