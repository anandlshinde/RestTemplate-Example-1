package com.smtek.service;

import com.smtek.dto.StockResponse;

public interface IStockDetails {

	public StockResponse getStockDetail(String stockName,int stockQty);
}
