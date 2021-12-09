package com.smtek.service;

import com.smtek.dto.StockPriceDetails;

public interface IStockPriceService {

	public StockPriceDetails getStockPriceByName(String stockName);
	
}
