package com.smtek.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smtek.dto.StockPriceDetails;
import com.smtek.entity.StockPrice;
import com.smtek.repository.StockPriceRepository;
import com.smtek.service.IStockPriceService;

@Service
public class StockPriceServiceImpl implements IStockPriceService {

	@Autowired
	private StockPriceRepository stockPriceRepo;
	
	@Override
	public StockPriceDetails getStockPriceByName(String stockName) {
		 StockPrice stockPrice = this.stockPriceRepo.findByStockName(stockName);
		 return entityToDto(stockPrice);
	}
	
	
	
	private static StockPriceDetails entityToDto(StockPrice stockPrice) {
		return new StockPriceDetails(stockPrice.getStockName(), stockPrice.getStockPrice());
	}

}
