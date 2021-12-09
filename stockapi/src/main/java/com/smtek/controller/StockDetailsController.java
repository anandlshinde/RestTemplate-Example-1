package com.smtek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smtek.dto.StockResponse;
import com.smtek.service.IStockDetails;

@RestController
public class StockDetailsController {

	@Autowired
	private IStockDetails iStockDetails;
	
	@GetMapping("/stockDetails")
	public ResponseEntity<StockResponse> getStockDetails(@RequestParam String stockName,@RequestParam int stockQty){
		StockResponse stockResponse = this.iStockDetails.getStockDetail(stockName,stockQty);
		return new ResponseEntity<StockResponse>(stockResponse,HttpStatus.OK);
	}
}
