package com.tonasolution.microservices.currencyexchangeservice.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tonasolution.microservices.currencyexchangeservice.dao.ExchangeValueDao;
import com.tonasolution.microservices.currencyexchangeservice.models.ExchangeValue;

@Service
public class ExchangeValueService {
	
	@Autowired
	private ExchangeValueDao exchangeValueDao;

	public ExchangeValue findByFromAndTo(String from, String to) {
		return exchangeValueDao.findByFromAndTo(from, to);
	}


}
