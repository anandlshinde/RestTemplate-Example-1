package com.smtek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smtek.dto.StockPriceDetails;
import com.smtek.service.IStockPriceService;

@RestController
public class StockPriceController {

	@Autowired
	private IStockPriceService iStockPriceService;
	
	@GetMapping("/price")
	public ResponseEntity<StockPriceDetails> getStockPrice(@RequestParam String stockName){
		StockPriceDetails stockPriceDetails = this.iStockPriceService.getStockPriceByName(stockName);
		return new ResponseEntity<StockPriceDetails>(stockPriceDetails,HttpStatus.FOUND);
	}
}
