package com.fondofit.stock.portfolio.repository;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fondofit.stock.portfolio.model.PortfolioBean;

@Repository
public interface PortfolioRepository extends MongoRepository<PortfolioBean, String> {

	Optional<PortfolioBean> findByCustomerId(String customerId);

}
