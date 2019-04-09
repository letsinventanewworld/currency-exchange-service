package com.tonasolution.microservices.currencyexchangeservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tonasolution.microservices.currencyexchangeservice.models.ExchangeValue;

@Repository
public interface ExchangeValueDao extends JpaRepository<ExchangeValue, Long>{
	ExchangeValue findByFromAndTo(String from, String to);
}
