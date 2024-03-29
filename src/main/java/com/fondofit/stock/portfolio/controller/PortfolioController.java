package com.fondofit.stock.portfolio.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fondofit.stock.portfolio.model.ExchangeBean;
import com.fondofit.stock.portfolio.model.PortfolioBean;
import com.fondofit.stock.portfolio.model.Stocks;
import com.fondofit.stock.portfolio.proxy.StockBaseFeignProxy;
import com.fondofit.stock.portfolio.repository.PortfolioRepository;
import com.fondofit.stock.portfolio.service.InstanceInformation;

@RestController
public class PortfolioController {

	Logger log = LoggerFactory.getLogger(PortfolioController.class);

	@Autowired
	private InstanceInformation instanceInformation;
	
	@Autowired
	PortfolioRepository repository;
	@Autowired
	StockBaseFeignProxy stockBaseFeignProxy;
	@GetMapping("/")
	public String helloPortfolio() {
		return "Hello from portfolio: instance id = "+ instanceInformation.retrieveInstanceInfo();
	}
	@GetMapping("/api/{customerId}")
	public Optional<PortfolioBean> get(@PathVariable("customerId") String customerId) {
		Optional<PortfolioBean> t = repository.findByCustomerId(customerId);
		t.get().setInstanceID(instanceInformation.retrieveInstanceInfo());
		return t;
	} 
	
	
	@GetMapping("/api/portfolio/{customerId}")
	public Optional<PortfolioBean> getPortFolio(@PathVariable("customerId") String customerId) {
		Optional<PortfolioBean> portfolioBean = repository.findByCustomerId(customerId);
		log.info(portfolioBean.toString());
		Float totalValue = 0f;
		if(portfolioBean.isPresent())
		{
			log.info("inside");
			
			List<Stocks> stocks = portfolioBean.get().getStocks();
			for(Stocks stock : stocks)
			{
				Optional<ExchangeBean> exchangeBean = stockBaseFeignProxy.getStockPriceByID(stock.getId());
				log.info(exchangeBean.toString());
				if(exchangeBean.isPresent()) 
				{
					Float stockValue = stock.getCount() * exchangeBean.get().getPrice();
					stock.setValue(stockValue);
					totalValue = totalValue + stockValue;
				}
			}
			portfolioBean.get().setPortfolioValue(totalValue);
		}
		
		portfolioBean.get().setInstanceID(instanceInformation.retrieveInstanceInfo());
		return portfolioBean;
	}
	
	public Optional<ExchangeBean> fallbackGetStockPriceByID(String stockId, Throwable t) {
		log.error("ERROR: Fallback getPortFolioByID(String stockId): from controller");
		return null;
	}
}
