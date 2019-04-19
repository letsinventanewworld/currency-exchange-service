package com.tonasolution.microservices.currencyexchangeservice.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tonasolution.microservices.currencyexchangeservice.business.ExchangeValueService;
import com.tonasolution.microservices.currencyexchangeservice.models.ExchangeValue;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueService exchangeValueService;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retreiveExchangeValue(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exchangeValue = exchangeValueService
									.findByFromAndTo(from.toUpperCase(), to.toUpperCase());
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exchangeValue;
	}
}
